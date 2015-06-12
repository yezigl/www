/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.ball.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mm.ball.model.Ball;

/**
 * description here
 *
 * @author lidehua
 * @since 2015年5月29日
 */
@RestController
public class BallController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Ball greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Ball(counter.incrementAndGet(), String.format(template, name));
    }

}
