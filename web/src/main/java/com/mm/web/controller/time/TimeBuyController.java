/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package com.mm.web.controller.time;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mm.web.controller.AbstractController;

/**
 * description here
 *
 * @author yezi
 * @since 2014年10月28日
 */
@RestController
@RequestMapping("/1/time")
public class TimeBuyController extends AbstractController {

    @RequestMapping(value = "/buy", method = RequestMethod.GET)
    @ResponseBody
    public void buy() {

    }
}
