/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.crawler.movie.spider;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * description here
 *
 * @author yezi
 * @since 2014年8月25日
 */
public class UrlQueue {

    private static Logger logger = LoggerFactory.getLogger(UrlQueue.class);

    private Pattern pattern;

    private Queue<String> queue;

    private Set<String> test;

    public UrlQueue() {
        this.queue = new LinkedList<String>();
        this.test = new HashSet<String>();
    }
    
    @Deprecated
    public UrlQueue(String urlPattern) {
        this.pattern = Pattern.compile(urlPattern);
        this.queue = new LinkedList<String>();
        this.test = new HashSet<String>();
    }

    @Deprecated
    public void parse(String html) {
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()) {
            String murl = matcher.group(1);
            this.add(murl);
        }
    }

    public void add(String url) {
        if (!this.test.contains(url)) {
            this.test.add(url);
            this.queue.offer(url);
            logger.debug("Url queue size is {}", queue.size());
        }
    }
    
    public void add(Collection<String> urls) {
        for (String url : urls) {
            add(url);
        }
    }

    public String next() {
        return this.queue.poll();
    }

    public boolean hasNext() {
        return !this.queue.isEmpty();
    }
}
