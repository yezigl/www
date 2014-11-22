/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.crawler.movie.strategy;

/**
 * description here
 *
 * @author yezi
 * @since 2014年8月24日
 */
public interface Strategy {

    void addUrl(String url);
    
    String getUrl();
    
    String getHtml();
    
    boolean hasUrl();
}
