/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.web.aop;

import gl.yezi.service.context.UserContext;
import gl.yezi.web.holder.ResponseContextHolder;
import gl.yezi.web.res.Res;
import gl.yezi.web.res.Status;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月18日
 */
@Aspect
@Component
public class AuthAspect {

    @Around("@annotation(gl.yezi.web.annotation.Auth)")
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
