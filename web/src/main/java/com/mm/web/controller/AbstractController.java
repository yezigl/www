/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package com.mm.web.controller;

import jakarta.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mm.service.CacheService;

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
    CacheService cacheService;
}
