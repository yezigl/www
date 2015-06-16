/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.yueqiu.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yueqiu.annotation.Auth;
import com.yueqiu.entity.Activity;
import com.yueqiu.entity.Order;
import com.yueqiu.entity.User;
import com.yueqiu.res.OrderRes;
import com.yueqiu.res.Representation;
import com.yueqiu.res.Status;
import com.yueqiu.utils.UserContext;
import com.yueqiu.utils.Utils;

/**
 * description here
 *
 * @author yezi
 * @since 2015年6月14日
 */
@RestController
@RequestMapping("/1")
public class OrderController extends AbstractController {

    @Auth
    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public Representation list(@RequestParam String activityId,
            @RequestHeader(value = "X-Forwarded-For", required = false) String forwardIp,
            @RequestHeader(value = "X-Real-IP", required = false) String realIp) {
        Representation rep = new Representation();

        User user = UserContext.getUser();
        Activity activity = activityService.get(activityId);
        if (activity == null) {
            rep.setError(Status.NOT_EXIST, "活动不存在");
            return rep;
        }

        Order order = orderService.getByUserAndActivity(user, activity);
        if (order == null) {
            order = new Order();
            order.setActivity(activity);
            order.setUser(user);
            order.setAmount(activity.getPrice());
            order.setIp(Utils.getClientIP(forwardIp, realIp));
            String id = orderService.create(order);
            if (id == null) {
                rep.setError(Status.ERROR_400, "生成订单失败");
                return rep;
            }
        }

        OrderRes res = new OrderRes();
        res.setId(order.getId().toString());
        rep.setData(res);

        return rep;
    }

    @RequestMapping(value = "/order/{id}/pay", method = RequestMethod.POST)
    public Representation pay(@PathVariable String id) {
        Representation rep = new Representation();

        return rep;
    }
}
