/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package com.mm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mm.web.res.Version;

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
    @ResponseBody
    public Version version(@PathVariable String platform, @PathVariable int version) {
        Version res = new Version();
        
        res.setUpdate(true);
        res.setChangelog("changelog");
        res.setLatest("1.0");
        res.setUrl("http://yezi.gl/uploads/android/itime.apk");
        
        return res;
    }
}
