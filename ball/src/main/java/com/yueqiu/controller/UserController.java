/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package com.yueqiu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yueqiu.annotation.Auth;
import com.yueqiu.entity.Order;
import com.yueqiu.entity.User;
import com.yueqiu.model.CacheKey;
import com.yueqiu.model.OrderStatus;
import com.yueqiu.res.ActivityRes;
import com.yueqiu.res.CaptchaRes;
import com.yueqiu.res.CouponRes;
import com.yueqiu.res.LoginRes;
import com.yueqiu.res.OrderRes;
import com.yueqiu.res.Representation;
import com.yueqiu.res.Status;
import com.yueqiu.res.UserRes;
import com.yueqiu.utils.Token;
import com.yueqiu.utils.UserContext;
import com.yueqiu.utils.Utils;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月6日
 */
@RestController
@RequestMapping(value = "/1")
public class UserController extends AbstractController {

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Representation register(@ModelAttribute("user") User user, @RequestParam String captcha,
            @RequestHeader(value = "X-Forwarded-For", required = false) String forwardIp,
            @RequestHeader(value = "X-Real-IP", required = false) String realIp) {
        Representation rep = new Representation();

        if (StringUtils.isBlank(user.getMobile()) || user.getMobile().length() != 11) {
            rep.setError(Status.PARAM_ERROR, "mobile");
            return rep;
        }

        String captchaOrigin = cacheService.get(CacheKey.getMobileCaptchaKey(user.getMobile()));
        if (!StringUtils.equals(captchaOrigin, captcha)) {
            rep.setError(Status.CAPTCHA_ERROR);
            return rep;
        }

        if (StringUtils.isBlank(user.getPassword())) {
            rep.setError(Status.PARAM_ERROR, "password");
            return rep;
        }

        User tempUser = userService.getByMobile(user.getMobile());
        if (tempUser != null) {
            rep.setError(Status.USER_REGISTERED, user.getMobile());
            return rep;
        }

        LoginRes res = new LoginRes();
        user.setIp(Utils.getClientIP(forwardIp, realIp));
        userService.create(user);
        res.setId(user.getId().toString());
        res.setMobile(user.getMobile());
        res.setNickname(user.getNickname());
        Token token = new Token(user.getId().toString());
        res.setToken(token.encrypt());

        rep.setData(res);

        return rep;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Representation login(@RequestParam String mobile, @RequestParam String password) {
        Representation rep = new Representation();

        User tempUser = userService.getByMobile(mobile);
        if (tempUser == null) {
            rep.setError(Status.USER_NOT_EXIST);
            return rep;
        }

        String tempPassword = DigestUtils.sha1Hex(tempUser.getSalt() + password);
        if (!tempPassword.equals(tempUser.getPassword())) {
            rep.setError(Status.USERNAME_OR_PASSWORD_ERROR);
            return rep;
        }

        LoginRes res = new LoginRes();
        Token token = new Token(tempUser.getId().toString());
        res.setToken(token.encrypt());
        res.setId(tempUser.getId().toString());
        res.setMobile(tempUser.getMobile());
        res.setNickname(tempUser.getNickname());
        res.setAvatar(tempUser.getAvatar());

        rep.setData(res);

        return rep;
    }

    @RequestMapping(value = "/captcha/mobile", method = RequestMethod.POST)
    public Representation captchaMobile(@RequestParam String mobile) {

        Representation rep = new Representation();

        Random random = new Random();
        int captcha = random.nextInt(90000) + 100000;

        cacheService.set(CacheKey.getMobileCaptchaKey(mobile), captcha, 600);

        CaptchaRes res = new CaptchaRes();
        res.setCaptcha(captcha);
        rep.setData(res);

        return rep;
    }

    @Auth
    @RequestMapping(value = "/user/me", method = RequestMethod.PUT)
    public Representation update(@ModelAttribute User user) {
        Representation rep = new Representation();

        User current = UserContext.getUser();

        userService.update(current);

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
        res.setActivity(ares);
        res.setCoupon(new CouponRes());
        return res;
    }

}
