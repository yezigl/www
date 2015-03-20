/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.web.interceptor;

import gl.yezi.web.App;
import gl.yezi.web.Params;
import gl.yezi.web.res.Res;
import gl.yezi.web.res.Status;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月21日
 */
public class AppInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        String appstr = request.getParameter(Params.APP);
        App app = App.valueOfKey(appstr);
        if (app == App.TBD) {
            output(response, new Res(Status.APP_NOT_EXIST));
            return false;
        }
        
        return true;
    }
    
    private void output(ServletResponse response, Res res) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        PrintWriter out = response.getWriter();
        out.print(JSON.toJSONString(res));
        out.flush();
        out.close();
    }
}
