/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.ball.model;

/**
 * description here
 *
 * @author lidehua
 * @since 2015年5月29日
 */
public class Ball {
    
    private final long id;
    private final String content;

    public Ball(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
