package gl.yezi.web.filter;

import gl.yezi.data.model.user.User;
import gl.yezi.service.context.Token;
import gl.yezi.service.context.UserContext;
import gl.yezi.service.user.UserService;
import gl.yezi.web.Params;
import gl.yezi.web.holder.ResponseContextHolder;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

/**
 * Servlet Filter implementation class AuthFilter
 */
public class AuthFilter implements Filter {

    private static String[] NO_LOGIN_URL = { "/register", "/login", "/captcha" };

    @Resource
    UserService userService;

    /**
     * Default constructor.
     */
    public AuthFilter() {
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {

        ResponseContextHolder.set(response);

        String uri = ((HttpServletRequest) request).getRequestURI();
        for (String nolgin : NO_LOGIN_URL) {
            if (uri.startsWith(nolgin)) {
                chain.doFilter(request, response);
                return;
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

        // pass the request along the filter chain
        chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
    }

}
