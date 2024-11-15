/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.mis.controller.beauty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mm.data.model.beauty.Beautician;
import com.mm.data.model.beauty.Deal;
import com.mm.data.model.beauty.Order;
import com.mm.data.model.user.User;
import com.mm.mis.controller.BaseController;
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
        List<Order> list = new ArrayList<>();
        if (orderId > 0) {
            Order order = orderService.get(orderId);
            list.add(order);
        } else if (StringUtils.isNotBlank(mobile)) {
            list = orderService.getListByMobile(mobile);
        }
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
        
        return vm("orders");
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String order(Model model, @RequestParam(defaultValue = "0") int orderId) {

        if (orderId > 0) {
            Order order = orderService.get(orderId);
            User user = userService.get(order.getUserId());
            Beautician beautician = beauticianService.get(order.getBeauticianId());
    
            model.addAttribute("order", order);
            model.addAttribute("user", user);
            model.addAttribute("beautician", beautician);
        }

        return vm("order");
    }
}
