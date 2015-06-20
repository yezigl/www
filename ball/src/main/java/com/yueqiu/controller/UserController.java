/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package com.yueqiu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yueqiu.annotation.Auth;
import com.yueqiu.entity.Order;
import com.yueqiu.entity.User;
import com.yueqiu.model.OrderStatus;
import com.yueqiu.res.ActivityRes;
import com.yueqiu.res.CouponRes;
import com.yueqiu.res.OrderRes;
import com.yueqiu.res.Representation;
import com.yueqiu.res.StadiumRes;
import com.yueqiu.res.Status;
import com.yueqiu.res.UserRes;
import com.yueqiu.utils.UserContext;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月6日
 */
@RestController
@RequestMapping(value = "/1")
public class UserController extends AbstractController {

    @Auth
    @RequestMapping(value = "/user/me", method = RequestMethod.POST)
    public Representation update(@ModelAttribute User user) {
        Representation rep = new Representation();

        User current = UserContext.getUser();
        if (StringUtils.isNotBlank(user.getMobile())) {
            current.setMobile(user.getMobile());
        }
        if (StringUtils.isNotBlank(user.getNickname())) {
            current.setNickname(user.getNickname());
        }
        if (StringUtils.isNotBlank(user.getAvatar())) {
            current.setAvatar(user.getAvatar());
        }

        userService.update(current);
        
        UserRes res = new UserRes();
        res.setId(current.getId().toString());
        res.setMobile(current.getMobile());
        res.setNickname(current.getNickname());
        res.setAvatar(current.getAvatar());

        rep.setData(res);

        return rep;
    }

    @Auth
    @RequestMapping(value = "/user/me", method = RequestMethod.GET)
    public Representation me() {
        Representation rep = new Representation();

        User user = UserContext.getUser();
        UserRes res = new UserRes();
        res.setId(user.getId().toString());
        res.setMobile(user.getMobile());
        res.setNickname(user.getNickname());
        res.setAvatar(user.getAvatar());

        rep.setData(res);

        return rep;
    }

    @Auth
    @RequestMapping(value = "/user/orders", method = RequestMethod.GET)
    public Representation orders(@RequestParam(defaultValue = "all") String status,
            @RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = "10") int limit) {
        Representation rep = new Representation();

        OrderStatus os = OrderStatus.valueOfStatus(status);
        List<Order> orders = orderService.listByUser(UserContext.getUser(), os, offset, limit);
        List<OrderRes> list = new ArrayList<OrderRes>();
        for (Order order : orders) {
            OrderRes res = fromOrder(order);
            list.add(res);
        }
        rep.setData(list);

        return rep;
    }

    @Auth
    @RequestMapping(value = "/user/resetpwd", method = RequestMethod.POST)
    public Representation update(@RequestParam String originPassword, @RequestParam String newPassword,
            @RequestParam String confirmPassword) {
        Representation rep = new Representation();

        User user = UserContext.getUser();
        String tempPassword = DigestUtils.sha1Hex(user.getSalt() + originPassword);
        if (!tempPassword.equals(user.getPassword())) {
            rep.setError(Status.ERROR_400, "原密码不正确");
            return rep;
        }
        if (!newPassword.equals(confirmPassword)) {
            rep.setError(Status.ERROR_400, "新密码和确认密码不一致");
            return rep;
        }
        user.setPassword(DigestUtils.sha1Hex(user.getSalt() + newPassword));
        userService.update(user);

        return rep;
    }

    private OrderRes fromOrder(Order order) {
        OrderRes res = new OrderRes();
        res.setId(order.getId().toString());
        res.setAmount(order.getAmount());
        res.setDiscount(order.getDiscount());
        res.setStatus(order.getStatus());
        res.setPaytime(order.getPaytime());
        res.setPaytype(order.getPaytype());
        res.setPaysn(order.getPaysn());
        ActivityRes ares = new ActivityRes();
        ares.setId(order.getActivity().getId().toString());
        ares.setTitle(order.getActivity().getTitle());
        ares.setDate(DateFormatUtils.format(order.getActivity().getDate(), pattern, Locale.CHINA));
        ares.setStadium(new StadiumRes(order.getActivity().getStadium()));
        res.setActivity(ares);
        res.setCoupon(new CouponRes());
        return res;
    }

}
