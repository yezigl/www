/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.mis.controller.beauty;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mm.data.model.beauty.Order;
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
    public String orders(Model model, @RequestParam(defaultValue = "0") int userId,
            @RequestParam(defaultValue = "") String mobile) {
        if (userId > 0) {
            User user = userService.get(userId);

            model.addAttribute("user", user);
            
            redirect("redirect:user/" + userId);
            return null;
        } else if (StringUtils.isNotBlank(mobile)) {
            List<Order> list = userService.getListByMobile(mobile);
        }
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
