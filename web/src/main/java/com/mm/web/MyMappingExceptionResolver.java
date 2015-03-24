/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package com.mm.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.mm.web.res.Res;
import com.mm.web.res.Status;

/**
 * description here
 *
 * @author yezi
 * @since 2014年10月28日
 */
public class MyMappingExceptionResolver extends SimpleMappingExceptionResolver {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) {
        logger.error("uri = {}", request.getRequestURI(), ex);
        ModelAndView mv = super.doResolveException(request, response, handler, ex);
        Res error = new Res();
        error.setStatus(Status.ERROR, ex.getMessage());
        mv.addObject("error", error);
        return mv;
    }
}
