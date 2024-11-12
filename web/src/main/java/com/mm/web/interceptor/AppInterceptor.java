/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.web.interceptor;


import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mm.data.model.user.User;
import com.mm.service.context.Token;
import com.mm.service.context.UserContext;
import com.mm.service.user.UserService;
import com.mm.service.utils.Params;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月21日
 */
public class AppInterceptor implements HandlerInterceptor {
    
    private static String[] NO_LOGIN_URL = { "/register", "/login", "/captcha" };

    @Resource
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
            UserContext.setUid(token.getUid());
            User user = userService.get(token.getUid());
            UserContext.setUser(user);
        }
        
        return true;
    }
    
}
