/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.yueqiu.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yueqiu.entity.Order;
import com.yueqiu.res.Representation;

/**
 * description here
 *
 * @author yezi
 * @since 2015年6月14日
 */
@RestController
@RequestMapping("/1")
public class OrderController extends AbstractController {

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public Representation create(@ModelAttribute("order") Order order,
            @RequestHeader(value = "X-Forwarded-For", required = false) String forwardIp,
            @RequestHeader(value = "X-Real-IP", required = false) String realIp) {
        Representation rep = new Representation();

        return rep;
    }
    
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public Representation list() {
        Representation rep = new Representation();

        return rep;
    }
    
    @RequestMapping(value = "/order/{id}/pay", method = RequestMethod.POST)
    public Representation pay(@PathVariable String id) {
        Representation rep = new Representation();

        return rep;
    }
}
