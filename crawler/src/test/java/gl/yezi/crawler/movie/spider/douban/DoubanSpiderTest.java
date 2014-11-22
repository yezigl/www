/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.crawler.movie.spider.douban;

import gl.yezi.crawler.spider.movie.douban.DoubanMovie;
import gl.yezi.crawler.spider.movie.douban.DoubanSpider;
import gl.yezi.service.utils.HttpUtils;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * description here
 *
 * @author yezi
 * @since 2014年8月26日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-test.xml")
public class DoubanSpiderTest {
    
    @Resource
    DoubanMovie doubanMovie;
    
    @Resource
    DoubanSpider doubanSpider;
    
    String url = "http://movie.douban.com/subject/1292470/";
    
    String charset = "UTF-8";

    /**
     * Test method for {@link gl.yezi.crawler.spider.movie.douban.DoubanSpider#crawl()}.
     */
    @Test
    public void testCrawl() {
        String html = HttpUtils.get(url, charset);
        doubanMovie.parse(DoubanSpider.getId(url), html);
    }

}
