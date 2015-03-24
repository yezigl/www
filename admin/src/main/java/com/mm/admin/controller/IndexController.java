/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.admin.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mm.admin.holder.AclUserContext;
import com.mm.admin.model.AclUser;
import com.mm.admin.utils.CookieUtils;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月22日
 */
@Controller
public class IndexController extends BaseController {
    
    @Override
    protected String vmtpl() {
        return "";
    }
    
    @Override
    protected String category() {
        return "index";
    }

    @RequestMapping("/")
    public String index() {

        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String preLogin() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(@RequestParam String username, @RequestParam String password,
            @RequestParam(defaultValue = "") String ru, Model model) {

        if (username.equals("mm") && password.equals("123456")) {
            AclUser aclUser = new AclUser();
            aclUser.setId(1);
            AclUserContext.setUser(aclUser);
            CookieUtils.setLoginCookie(aclUser);
            if (StringUtils.isNotBlank(ru)) {
                redirect(ru);
            } else {
                redirect("/");
            }
        } else {
            model.addAttribute("error", "用户名或密码不正确");
        }

        return "login";
    }
}
