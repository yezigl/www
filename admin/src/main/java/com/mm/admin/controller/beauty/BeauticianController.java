/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.admin.controller.beauty;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mm.admin.controller.BaseController;
import com.mm.data.model.beauty.Beautician;
import com.mm.data.model.beauty.Deal;
import com.mm.service.beauty.BeauticianService;
import com.mm.service.beauty.DealService;

/**
 * description here
 *
 * @author lidehua
 * @since 2015年3月26日
 */
@Controller
@RequestMapping("/beauty")
public class BeauticianController extends BaseController {
    
    @Resource
    BeauticianService beauticianService;
    
    @Resource
    DealService dealService;

    @Override
    protected String vmtpl() {
        return "beautician";
    }

    @Override
    protected String category() {
        return "beautician";
    }
    
    @RequestMapping(value = "/beauticians", method = RequestMethod.GET)
    public String beauticians(Model model, @RequestParam(defaultValue = "0") int offset) {
        
        List<Beautician> list = beauticianService.getList(offset, 100);
        
        model.addAttribute("beauticians", list);
        
        return vm("beauticians");
    }
    
    @RequestMapping(value = "/beautician/{beauticianId}", method = RequestMethod.GET)
    public String beautician(Model model, @PathVariable int beauticianId) {
        
        Beautician beautician = beauticianService.get(beauticianId);
        // 获取相关项目
        List<Integer> ids = beauticianService.getDealIds(beauticianId);
        List<Deal> deals = new ArrayList<Deal>();
        for (int id : ids) {
            deals.add(dealService.get(id));
        }
        // 获取时间
        
        model.addAttribute("beautician", beautician);
        model.addAttribute("deals", deals);
        
        return "beautician";
    }

}
