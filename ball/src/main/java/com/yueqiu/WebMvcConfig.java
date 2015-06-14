/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.yueqiu;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.yueqiu.intercepter.AuthInterceptor;

/**
 * description here
 *
 * @author yezi
 * @since 2015年6月14日
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor());
    }
    
}
