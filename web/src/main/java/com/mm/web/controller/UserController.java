/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package com.mm.web.controller;

import java.util.List;
import java.util.Random;

import jakarta.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mm.data.model.user.User;
import com.mm.data.model.user.UserAddress;
import com.mm.service.context.CacheKey;
import com.mm.service.context.Token;
import com.mm.service.context.UserContext;
import com.mm.service.user.UserService;
import com.mm.service.utils.Utils;
import com.mm.web.App;
import com.mm.web.annotation.Auth;
import com.mm.web.res.CaptchaMobileRes;
import com.mm.web.res.LoginRes;
import com.mm.web.res.Res;
import com.mm.web.res.Status;
import com.mm.web.res.UserAddressListRes;
import com.mm.web.res.UserAddressRes;
import com.mm.web.res.UserRes;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月6日
 */
@RestController
@RequestMapping(value = "/1")
public class UserController extends AbstractController {

    @Resource
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public LoginRes register(@ModelAttribute("user") User user,
            @RequestParam(value = "appkey", defaultValue = "tbd") String appkey,
            @RequestHeader(value = "X-Forwarded-For", required = false) String forwardIp,
            @RequestHeader(value = "X-Real-IP", required = false) String realIp) {
        LoginRes login = new LoginRes();

        App app = App.valueOfKey(appkey);
        if (app == App.TBD) {
            login.setStatus(Status.PARAM_ERROR, "appkey");
            return login;
        }

        if (StringUtils.isBlank(user.getLogin()) || user.getLogin().length() > 20) {
            login.setStatus(Status.PARAM_ERROR, "username");
            return login;
        }

        if (StringUtils.isBlank(user.getPassword())) {
            login.setStatus(Status.PARAM_ERROR, "password");
            return login;
        }

        if (StringUtils.length(user.getNickname()) > 20) {
            login.setStatus(Status.PARAM_ERROR, "nickname");
            return login;
        }

        User tempUser = userService.getByLogin(user.getLogin());
        if (tempUser != null) {
            login.setStatus(Status.USER_REGISTERED, user.getLogin());
            return login;
        }

        user.setRegip(Utils.getClientIP(forwardIp, realIp));
        userService.register(user);
        login.setUid(user.getId());
        login.setLogin(user.getLogin());
        login.setNickname(user.getNickname());
        Token token = new Token(user.getId());
        login.setToken(token.encrypt());

        return login;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LoginRes login(@RequestParam String username, @RequestParam String password,
            @RequestParam(value = "appkey", defaultValue = "tbd") String appkey) {
        LoginRes login = new LoginRes();

        App app = App.valueOfKey(appkey);
        if (app == App.TBD) {
            login.setStatus(Status.PARAM_ERROR, "appkey");
            return login;
        }

        User tempUser = userService.getByLogin(username);
        if (tempUser == null) {
            login.setStatus(Status.USER_NOT_EXIST);
            return login;
        }

        String tempPassword = DigestUtils.sha1Hex(tempUser.getSalt() + password);
        if (!tempPassword.equals(tempUser.getPassword())) {
            login.setStatus(Status.USERNAME_OR_PASSWORD_ERROR);
            return login;
        }

        Token token = new Token(tempUser.getId());
        login.setToken(token.encrypt());
        login.setUid(tempUser.getId());
        login.setLogin(tempUser.getLogin());
        login.setNickname(tempUser.getNickname());
        login.setAvatar(tempUser.getAvatar());

        return login;
    }

    @RequestMapping(value = "/captcha/mobile", method = RequestMethod.POST)
    public CaptchaMobileRes captchaMobile(@RequestParam String mobile,
            @RequestParam(value = "appkey", defaultValue = "tbd") String appkey) {

        CaptchaMobileRes res = new CaptchaMobileRes();

        Random random = new Random();
        int captcha = random.nextInt(90000) + 100000;

        cacheService.set(CacheKey.getMobileCaptchaKey(mobile), captcha, 600);

        res.setCaptcha(captcha);

        return res;
    }

    @RequestMapping(value = "/login/mobile", method = RequestMethod.POST)
    public LoginRes registerMobile(@RequestParam String mobile, @RequestParam String captcha,
            @RequestParam(value = "appkey", defaultValue = "tbd") String appkey,
            @RequestHeader(value = "X-Forwarded-For", required = false) String forwardIp,
            @RequestHeader(value = "X-Real-IP", required = false) String realIp) {

        LoginRes res = new LoginRes();

        String captchaOrigin = cacheService.get(CacheKey.getMobileCaptchaKey(mobile));

        if (!StringUtils.equals(captchaOrigin, captcha)) {
            res.setStatus(Status.CAPTCHA_ERROR);
            return res;
        }

        User user = userService.getByLogin(mobile);
        if (user == null) {
            user = new User();
            user.setLogin(mobile);
            user.setNickname("");
            user.setMobile(mobile);
            user.setRegip(Utils.getClientIP(forwardIp, realIp));
            userService.register(user);
        }
        res.setUid(user.getId());
        res.setLogin(user.getLogin());
        res.setNickname(user.getNickname());
        res.setMobile(user.getMobile());
        Token token = new Token(user.getId());
        res.setToken(token.encrypt());
        res.setAvatar(user.getAvatar());

        return res;
    }

    @Auth
    @RequestMapping(value = "/user/me", method = RequestMethod.PUT)
    public Res update(@ModelAttribute User user) {
        Res res = new Res();

        User current = UserContext.getUser();

        userService.update(current);

        return res;
    }

    @Auth
    @RequestMapping(value = "/user/me", method = RequestMethod.GET)
    public UserRes me() {
        UserRes userInfo = new UserRes();

        User user = UserContext.getUser();
        if (user == null) {
            userInfo.setStatus(Status.USER_NOT_LOGIN);
            return userInfo;
        }
        userInfo.setLogin(user.getLogin());
        userInfo.setNickname(user.getNickname());
        userInfo.setEmail(user.getEmail());
        userInfo.setMobile(user.getMobile());

        return userInfo;
    }

    @Auth
    @RequestMapping(value = "/user/address", method = RequestMethod.POST)
    public UserAddressRes userAddressAdd(@ModelAttribute UserAddress userAddress) {
        UserAddressRes res = new UserAddressRes();

        User user = UserContext.getUser();
        userAddress.setUserId(user.getId());
        userService.addAddress(userAddress);

        return res;
    }

    @Auth
    @RequestMapping(value = "/user/address", method = RequestMethod.PUT)
    public UserAddressRes userAddressUpdate(@ModelAttribute UserAddress userAddress) {
        UserAddressRes res = new UserAddressRes();

        User user = UserContext.getUser();
        userAddress.setUserId(user.getId());
        userService.updateAddress(userAddress);

        return res;
    }

    @Auth
    @RequestMapping(value = "/user/addresses", method = RequestMethod.GET)
    public UserAddressListRes userAddresses() {
        UserAddressListRes res = new UserAddressListRes();

        List<UserAddress> list = userService.getAddressList(UserContext.getUid());
        for (UserAddress userAddress : list) {
            res.addAddress(new UserAddressRes(userAddress));
        }

        return res;
    }
}
