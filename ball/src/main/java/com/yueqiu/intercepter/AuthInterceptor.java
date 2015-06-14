/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.yueqiu.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.yueqiu.entity.User;
import com.yueqiu.service.UserService;
import com.yueqiu.utils.Params;
import com.yueqiu.utils.Token;
import com.yueqiu.utils.UserContext;


/**
 * description here
 *
 * @author yezi
 * @since 2015年3月21日
 */
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {
    
    private static String[] NO_LOGIN_URL = { "/register", "/login", "/captcha" };

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String uri = ((HttpServletRequest) request).getRequestURI();
        for (String nolgin : NO_LOGIN_URL) {
            if (uri.startsWith(nolgin)) {
                return true;
            }
        }
        String tokenStr = request.getParameter(Params.TOKEN);

        Token token = null;
        if (StringUtils.isNotBlank(tokenStr)) {
            // 基于token的认证
            token = Token.decrypt(tokenStr);
        } else {
            // 基于cookie的认证
        }
        if (token != null) {
            UserContext.setUid(token.getUid().toString());
            User user = userService.get(token.getUid());
            UserContext.setUser(user);
        }
        
        return true;
    }
    
}
