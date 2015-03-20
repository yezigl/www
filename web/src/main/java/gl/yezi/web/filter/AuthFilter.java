package gl.yezi.web.filter;

import gl.yezi.data.model.user.User;
import gl.yezi.service.context.Token;
import gl.yezi.service.context.UserContext;
import gl.yezi.service.user.UserService;
import gl.yezi.web.Params;
import gl.yezi.web.holder.ResponseContextHolder;
import gl.yezi.web.res.Res;
import gl.yezi.web.res.Status;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;

import com.alibaba.fastjson.JSON;

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
        if (token == null) {
            Res res = new Res(Status.USER_NOT_LOGIN);
            output(request, response, res);
            return;
        }
        UserContext.setUid(token.getUid());
        User user = userService.get(token.getUid());
        if (user == null) {
            Res res = new Res(Status.USER_NOT_LOGIN);
            output(request, response, res);
            return;
        }
        UserContext.setUser(user);

        // pass the request along the filter chain
        chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
    }

    private void output(ServletRequest request, ServletResponse response, Res res) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        PrintWriter out = response.getWriter();
        out.print(JSON.toJSONString(res));
        out.flush();
        out.close();
    }
}
