/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.crawler.spider.movie.douban;

import gl.yezi.crawler.movie.spider.Spider;
import gl.yezi.crawler.movie.spider.UrlQueue;
import gl.yezi.data.dao.movie.MovieDao;
import gl.yezi.service.utils.HttpUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * description here
 *
 * @author yezi
 * @since 2014年8月25日
 */
@Component
public class DoubanSpider implements Spider, InitializingBean {
    
    private static Logger logger = LoggerFactory.getLogger(DoubanSpider.class);
    
    public static String charset = "UTF-8";
    
    public String movieUrlPattern = "http://movie.douban.com/subject/\\d+/";
    
    public String celebrityUrlPattern = "http://movie.douban.com/celebrity/\\d+/";
    
    private static Pattern idPattern = Pattern.compile("(\\d+)");
    
    private UrlQueue movieQueue = new UrlQueue();
    
    private UrlQueue celebrityQueue = new UrlQueue();
    
    private String startUrl = "http://movie.douban.com/subject/3718269/";
    
    private static Map<String, String> header = new HashMap<String, String>();
    
    private Timer timer = new Timer();
    
    static {
        header.put("Host", "movie.douban.com");
        header.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.76 Safari/537.36");
        header.put("Referer", "http://movie.douban.com");
        header.put("Cookie", "viewed=\"1885170\"; bid=\"J+wXRWu7bt8\"; ll=\"108288\"; __utma=30149280.181458921.1376578656.1409153941.1409158245.32; __utmc=30149280; __utmz=30149280.1407244967.25.22.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); __utmv=30149280.5237; __utma=223695111.2037665317.1392286389.1409153941.1409158245.10; __utmc=223695111; __utmz=223695111.1407244967.3.3.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); _pk_ref.100001.4cf6=%5B%22%22%2C%22%22%2C1409228667%2C%22https%3A%2F%2Fwww.google.com%2F%22%5D; _pk_id.100001.4cf6=10192d966f7018a3.1407244967.10.1409228667.1409162251.; _pk_ses.100001.4cf6=*");
    }
    
    @Resource
    DoubanMovie doubanMovie;
    
    @Resource
    DoubanCelebrity doubanCelebrity;
    
    @Resource
    MovieDao movieDao;
    
    @Override
    public void afterPropertiesSet() throws Exception {
        crawl();
    }

    @Override
    public void crawl() {
        //String html = HttpUtils.get(startUrl, charset);
        
        //Set<String> urls = doubanMovie.parse(getId(startUrl), html);
        movieQueue.add(startUrl);
        
        timer.schedule(new MovieTask(), 0);
        //timer.schedule(new CelebrityTask(), 60 * 1000);
    }
    
    public static int getId(String url) {
        Matcher idMatcher = idPattern.matcher(url);
        while (idMatcher.find()) {
            return NumberUtils.toInt(idMatcher.group(1));
        }
        return 0;
    }
    
    public static String loop(String url) {
        String html = null;
        int count = 0;
        while (StringUtils.isBlank(html)) {
            html = HttpUtils.get(url, header, charset);
            count++;
            if (count > 10) {
                break;
            }
        }
        logger.info("loop count {}", count);
        return html;
    }
    
    class MovieTask extends TimerTask {

        @Override
        public void run() {
            while (movieQueue.hasNext()) {
                String url = movieQueue.next();
                String html = loop(url);
                int id = getId(url);
                if (movieDao.getByDouban(id) != null) {
                    continue;
                }
                Set<String> urls = doubanMovie.parse(id, html);
                
                movieQueue.add(urls);
                
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
//                if (!celebrityRun) {
//                    timer.schedule(new CelebrityTask(), 0);
//                }
            }
            logger.info("spider down");
        }
        
    }
    
    class CelebrityTask extends TimerTask {

        @Override
        public void run() {
            while (celebrityQueue.hasNext()) {
                String url = celebrityQueue.next();
                String html = HttpUtils.get(url, charset);
                doubanCelebrity.parse(getId(url), html);
            }
        }
        
    }

}
