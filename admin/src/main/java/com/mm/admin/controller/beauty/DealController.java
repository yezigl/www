/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.admin.controller.beauty;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mm.admin.controller.BaseController;
import com.mm.data.model.beauty.Deal;
import com.mm.data.model.beauty.Flow;
import com.mm.data.model.beauty.Product;
import com.mm.service.beauty.DealService;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月24日
 */
@Controller
@RequestMapping("/beauty")
public class DealController extends BaseController {
    
    @Resource
    DealService dealService;
    
    @Override
    protected String vmtpl() {
        return "deal";
    }
    
    @Override
    protected String category() {
        return "deal";
    }

    @RequestMapping(value = "/deals", method = RequestMethod.GET)
    public String deals(Model model, @RequestParam(defaultValue = "0") int offset) {
        
        List<Deal> deals = dealService.getList(offset, 10);
        
        model.addAttribute("deals", deals);
        
        return vm("deals");
    }
    
    @RequestMapping(value = "/deal/{dealId}", method = RequestMethod.GET)
    public String deal(Model model, @PathVariable int dealId) {
        
        Deal deal = dealService.get(dealId);
        
        List<Product> products = dealService.getProducts(deal);
        List<Flow> flows = dealService.getFlows(deal);
        
        model.addAttribute("deal", deal);
        model.addAttribute("products", products);
        model.addAttribute("flows", flows);
        
        return vm("deal");
    }
    
    @RequestMapping(value = "/deal/add", method = RequestMethod.GET)
    public String dealAddPGet(Model model) {
        return vm("dealadd");
    }
    
    @RequestMapping(value = "/deal/add", method = RequestMethod.POST)
    @ResponseBody
    public String dealAddPost(Model model) {
        return vm("dealadd");
    }
}
