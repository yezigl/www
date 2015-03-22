/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.web.interceptor;

import gl.yezi.data.model.user.User;
import gl.yezi.service.context.Token;
import gl.yezi.service.context.UserContext;
import gl.yezi.service.user.UserService;
import gl.yezi.web.Params;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月21日
 */
public class AppInterceptor extends HandlerInterceptorAdapter {
    
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
