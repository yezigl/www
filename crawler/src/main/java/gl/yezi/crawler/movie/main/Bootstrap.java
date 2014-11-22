/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.crawler.movie.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description here
 *
 * @author yezi
 * @since 2014年8月28日
 */
public class Bootstrap {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        String[] configLocations = {"classpath*:spring/applicationContext-*.xml"};
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(configLocations);
        ctx.registerShutdownHook();
    }
}
