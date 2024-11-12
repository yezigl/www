/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.web.aop;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson2.JSON;
import com.mm.service.context.UserContext;
import com.mm.web.holder.ResponseContextHolder;
import com.mm.web.res.Res;
import com.mm.web.res.Status;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月18日
 */
@Aspect
@Component
public class AuthAspect {

    @Around("@annotation(com.mm.web.annotation.Auth)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        if (UserContext.isAuth()) {
            return pjp.proceed();
        } else {
            Res res = new Res();
            res.setStatus(Status.USER_NOT_LOGIN);
            output(ResponseContextHolder.getResponse(), res);
            return null;
        }

    }

    private void output(ServletResponse response, Res res) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        PrintWriter out = response.getWriter();
        out.print(JSON.toJSONString(res));
        out.flush();
        out.close();
    }
}
