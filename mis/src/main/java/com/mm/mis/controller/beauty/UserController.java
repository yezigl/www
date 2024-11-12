/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.mis.controller.beauty;

import jakarta.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mm.data.model.user.User;
import com.mm.mis.controller.BaseController;
import com.mm.service.user.UserService;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月30日
 */
@Controller
@RequestMapping("/beauty")
public class UserController extends BaseController {
    
    @Resource
    UserService userService;

    @Override
    protected String vmtpl() {
        return "user";
    }

    @Override
    protected String category() {
        return "user";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users(Model model, @RequestParam(defaultValue = "0") int userId,
            @RequestParam(defaultValue = "") String mobile) {
        User user = null;
        if (userId > 0) {
            user = userService.get(userId);
        } else if (StringUtils.isNotBlank(mobile)) {
            user = userService.getByMobile(mobile);
        }
        model.addAttribute("user", user);
        model.addAttribute("userId", userId);
        model.addAttribute("mobile", mobile);
        return vm("users");
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String order() {
        return vm("user");
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public String order(Model model, @PathVariable int userId) {

        User user = userService.get(userId);

        model.addAttribute("user", user);

        return vm("user");
    }
}
