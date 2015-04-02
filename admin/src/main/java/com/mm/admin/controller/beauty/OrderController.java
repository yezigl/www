/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.admin.controller.beauty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mm.admin.controller.BaseController;
import com.mm.data.model.beauty.Beautician;
import com.mm.data.model.beauty.Deal;
import com.mm.data.model.beauty.Order;
import com.mm.data.model.user.User;
import com.mm.service.beauty.BeauticianService;
import com.mm.service.beauty.DealService;
import com.mm.service.beauty.OrderService;
import com.mm.service.user.UserService;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月31日
 */
@Controller
@RequestMapping("/beauty")
public class OrderController extends BaseController {

    @Resource
    OrderService orderService;

    @Resource
    UserService userService;

    @Resource
    BeauticianService beauticianService;
    
    @Resource
    DealService dealService;

    @Override
    protected String vmtpl() {
        return "order";
    }

    @Override
    protected String category() {
        return "order";
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String orders(Model model, @RequestParam(defaultValue = "0") int orderId,
            @RequestParam(defaultValue = "") String mobile) {
        if (orderId > 0) {
            Order order = orderService.get(orderId);
            User user = userService.get(order.getUserId());
            Beautician beautician = beauticianService.get(order.getBeauticianId());

            model.addAttribute("order", order);
            model.addAttribute("user", user);
            model.addAttribute("beautician", beautician);
            
            return "redirect:order/" + orderId;
        } else if (StringUtils.isNotBlank(mobile)) {
            List<Order> list = orderService.getListByMobile(mobile);
            List<Map<String, Object>> orders = new ArrayList<>();
            for (Order order : list) {
                Deal deal = dealService.get(order.getDealId());
                Map<String, Object> map = new HashMap<>();
                map.put("id", order.getId());
                map.put("userId", order.getUserId());
                map.put("dealId", order.getDealId());
                map.put("dealName", deal.getTitle());
                map.put("ctime", order.getCtime());
                orders.add(map);
            }
            model.addAttribute("orders", orders);
        }
        return vm("orders");
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String order() {
        return vm("order");
    }

    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET)
    public String order(Model model, @PathVariable int orderId) {

        Order order = orderService.get(orderId);
        User user = userService.get(order.getUserId());
        Beautician beautician = beauticianService.get(order.getBeauticianId());

        model.addAttribute("order", order);
        model.addAttribute("user", user);
        model.addAttribute("beautician", beautician);

        return vm("order");
    }
}
