/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.mis.interceptor;

import java.net.URLEncoder;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import com.mm.mis.holder.AclUserContext;
import com.mm.mis.model.AclUser;
import com.mm.mis.service.AclUserService;
import com.mm.mis.utils.CookieUtils;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月21日
 */
public class AuthInterceptor implements HandlerInterceptor {

    private static final String NO_LOGIN_REDIRECT_URL = "/login";
    private static final String INDEX_URI = "/";

    @Resource
    AclUserService aclUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String uri = ((HttpServletRequest) request).getRequestURI();
        String ru = null;
        if (!uri.equals(INDEX_URI)) {
            ru = uri + (request.getQueryString() == null ? "" : "?" + request.getQueryString());
        }

        AclUser aclUser = CookieUtils.getLoginUser(request);
        if (aclUser != null) {
            aclUser = aclUserService.get(aclUser.getId());
        }
        if (aclUser == null) {
            if (ru == null) {
                response.sendRedirect(NO_LOGIN_REDIRECT_URL);
            } else {
                response.sendRedirect(NO_LOGIN_REDIRECT_URL + "?ru=" + URLEncoder.encode(ru, "utf-8"));
            }
            return false;
        }
        AclUserContext.setUser(aclUser);

        return true;
    }

}
