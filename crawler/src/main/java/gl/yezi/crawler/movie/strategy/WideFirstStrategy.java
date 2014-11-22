/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.crawler.movie.strategy;

import gl.yezi.service.utils.HttpUtils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * description here
 *
 * @author yezi
 * @since 2014年8月24日
 */
public class WideFirstStrategy implements Strategy {
    
    private static Logger logger = LoggerFactory.getLogger(WideFirstStrategy.class);

    //private String initUrl;

    private Pattern urlPattern;

    private String charset;

    private Queue<String> urlQueue;

    private Set<String> distinctTest;
    
    public WideFirstStrategy(String urlPattern, String charset) {
        this.urlPattern = Pattern.compile(urlPattern);
        this.charset = charset;
        this.urlQueue = new LinkedList<String>();
        this.distinctTest = new HashSet<String>();
    }

    public WideFirstStrategy(String url, String urlPattern, String charset) {
        //this.initUrl = url;
        this.urlPattern = Pattern.compile(urlPattern);
        this.charset = charset;
        this.urlQueue = new LinkedList<String>();
        this.distinctTest = new HashSet<String>();
        this.parseHtmlPage(url);
    }

    public void setInitUrl(String url) {
        //this.initUrl = url;
        this.parseHtmlPage(url);
    }

    public void setUrlPattern(Pattern urlPattern) {
        this.urlPattern = urlPattern;
    }

    private String parseHtmlPage(String url) {
        if (StringUtils.isBlank(url)) {
            return null;
        }
        String html = HttpUtils.get(url, charset);
        Matcher matcher = urlPattern.matcher(html);
        while (matcher.find()) {
            String murl = matcher.group(1);
            this.addUrl(murl);
        }
        return html;
    }

    @Override
    public void addUrl(String url) {
        if (!this.distinctTest.contains(url)) {
            this.distinctTest.add(url);
            this.urlQueue.offer(url);
            logger.debug("Url queue size is {}", urlQueue.size());
        }
    }

    @Override
    public String getUrl() {
        String url = this.urlQueue.poll();
        this.parseHtmlPage(url);
        return url;
    }

    @Override
    public String getHtml() {
        String url = this.urlQueue.poll();
        return this.parseHtmlPage(url);
    }

    @Override
    public boolean hasUrl() {
        return !this.urlQueue.isEmpty();
    }
}
