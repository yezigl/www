/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package com.yueqiu.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yueqiu.service.CacheService;
import com.yueqiu.service.GameService;
import com.yueqiu.service.OrderService;
import com.yueqiu.service.UserService;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月26日
 */
public class AbstractController {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    
    protected int LIMIT = 10;
    
    @Resource
    protected CacheService cacheService;
    @Resource
    protected GameService gameService;
    @Resource
    protected OrderService orderService;
    @Resource
    protected UserService userService;
}
