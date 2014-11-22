/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.web.controller;

import gl.yezi.web.res.Version;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月23日
 */
@Controller
@RequestMapping(value = "/1/app")
public class AppController {

    @RequestMapping(value = "/version/{platform}/{version}", method = RequestMethod.GET)
    public Version version(String platform, int version) {
        Version res = new Version();
        
        res.setUpdate(true);
        res.setChangelog("changelog");
        res.setLatest("1.0");
        res.setUrl("http://yezi.gl/uploads/android/itime.apk");
        
        return res;
    }
}
