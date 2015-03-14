/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.web.controller;

import gl.yezi.data.model.user.User;
import gl.yezi.data.model.user.UserAddress;
import gl.yezi.service.context.CacheKey;
import gl.yezi.service.context.Token;
import gl.yezi.service.context.UserContext;
import gl.yezi.service.user.UserService;
import gl.yezi.service.utils.Utils;
import gl.yezi.web.App;
import gl.yezi.web.res.CaptchaMobileRes;
import gl.yezi.web.res.LoginRes;
import gl.yezi.web.res.Res;
import gl.yezi.web.res.Status;
import gl.yezi.web.res.UserAddressListRes;
import gl.yezi.web.res.UserAddressRes;
import gl.yezi.web.res.UserRes;

import java.util.List;
import java.util.Random;

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
    

    @RequestMapping(value = "/user/{uid}", method = RequestMethod.PUT)
    public Res update(@PathVariable int uid, @ModelAttribute User user,
            @RequestParam(value = "appkey", defaultValue = "tbd") String appkey, @RequestParam int type) {
        Res res = new Res();

        return res;
    }

    @RequestMapping(value = "/user/{uid}", method = RequestMethod.GET)
    public UserRes userInfo(@PathVariable int uid, @RequestParam(value = "appkey", defaultValue = "tbd") String appkey) {
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
        userInfo.setLogin(user.getLogin());
        userInfo.setNickname(user.getNickname());
        userInfo.setEmail(user.getEmail());
        userInfo.setMobile(user.getMobile());

        return userInfo;
    }

    @RequestMapping(value = "/captcha/mobile", method = RequestMethod.POST)
    public CaptchaMobileRes mobileCaptchaCreate(@RequestParam String mobile) {

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
        
//        App app = App.valueOfKey(appkey);
//        if (app == App.TBD) {
//            res.setStatus(Status.PARAM_ERROR, "appkey");
//            return res;
//        }
        
//        if (!StringUtils.equals(captchaOrigin, captcha)) {
//            res.setStatus(Status.PARAM_ERROR, "captcha");
//            return res;
//        }

        User user = userService.getByLogin(mobile);
        if (user == null) {
            user = new User();
            user.setLogin(mobile);
            user.setNickname(mobile);
            user.setRegip(Utils.getClientIP(forwardIp, realIp));
            int id = userService.register(user);
            user.setId(id);
        }
        res.setUid(user.getId());
        res.setLogin(user.getLogin());
        res.setNickname(user.getNickname());
        Token token = new Token(user.getId());
        res.setToken(token.encrypt());

        return res;
    }
    
    @RequestMapping(value = "/user/address", method = RequestMethod.POST)
    public UserAddressRes userAddressAdd(@ModelAttribute UserAddress userAddress) {
        UserAddressRes res = new UserAddressRes();
        
        User user = UserContext.getUser();
        userAddress.setUserId(user.getId());
        int id = userService.addAddress(userAddress);
        res.setId(id);
        
        return res;
    }
    
    @RequestMapping(value = "/user/address", method = RequestMethod.PUT)
    public UserAddressRes userAddressUpdate(@ModelAttribute UserAddress userAddress) {
        UserAddressRes res = new UserAddressRes();
        
        User user = UserContext.getUser();
        userAddress.setUserId(user.getId());
        userService.updateAddress(userAddress);
        
        return res;
    }
    
    @RequestMapping(value = "/user/addresses", method = RequestMethod.GET)
    public UserAddressListRes userAddresses() {
        UserAddressListRes res = new UserAddressListRes();
        
        List<UserAddress> list = userService.getAddressList();
        for (UserAddress userAddress : list) {
            res.addAddress(new UserAddressRes(userAddress));
        }
        
        return res;
    }
}
