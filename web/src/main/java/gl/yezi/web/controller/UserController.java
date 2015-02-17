/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.web.controller;

import gl.yezi.data.model.time.User;
import gl.yezi.service.UserService;
import gl.yezi.service.context.Token;
import gl.yezi.service.utils.Utils;
import gl.yezi.web.App;
import gl.yezi.web.res.LoginRes;
import gl.yezi.web.res.Res;
import gl.yezi.web.res.Status;
import gl.yezi.web.res.UserRes;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

        if (StringUtils.isBlank(user.getUsername()) || user.getUsername().length() > 20) {
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

        User tempUser = userService.get(user.getUsername());
        if (tempUser != null) {
            login.setStatus(Status.USER_REGISTERED, user.getUsername());
            return login;
        }

        user.setRegip(Utils.getClientIP(forwardIp, realIp));
        userService.register(user);
        login.setUid(user.getId());
        login.setUsername(user.getUsername());
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
        
        User tempUser = userService.get(username);
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
        login.setUsername(tempUser.getUsername());
        login.setNickname(tempUser.getNickname());
        login.setAvatar(tempUser.getAvatar());

        return login;
    }

    @RequestMapping(value = "/users/{uid}", method = RequestMethod.PUT)
    public Res update(@PathVariable int uid, @ModelAttribute User user,
            @RequestParam(value = "appkey", defaultValue = "tbd") String appkey, @RequestParam int type) {
        Res res = new Res();

        return res;
    }

    @RequestMapping(value = "/users/{uid}", method = RequestMethod.GET)
    public UserRes userinfo(@PathVariable int uid, @RequestParam(value = "appkey", defaultValue = "tbd") String appkey) {
        UserRes userInfo = new UserRes();
        
        App app = App.valueOfKey(appkey);
        if (app == App.TBD) {
            userInfo.setStatus(Status.PARAM_ERROR, "appkey");
            return userInfo;
        }
        
        User user = userService.get(uid);
        if (user == null) {
            userInfo.setStatus(Status.USER_NOT_EXIST);
            return userInfo;
        }
        userInfo.setUsername(user.getUsername());
        userInfo.setNickname(user.getNickname());
        userInfo.setEmail(user.getEmail());
        userInfo.setPhone(user.getPhone());
        userInfo.setAlipay(user.getAlipay());

        return userInfo;
    }
}
