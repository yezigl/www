/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.crawler.time.main;

import jakarta.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月11日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-test.xml")
public class SchoolCrawlerTest {
    
    String url = "http://zh.wikipedia.org/wiki/%E6%B9%96%E5%8C%97%E7%9C%81%E9%AB%98%E7%AD%89%E5%AD%A6%E6%A0%A1%E5%88%97%E8%A1%A8";

    @Resource
    SchoolCrawler schoolCrawler;
    
    @Test
    public void testProvince() {
        schoolCrawler.parseProvince();
    }
    
    @Test
    public void testCity() {
        schoolCrawler.parseList(url);
    }

}
