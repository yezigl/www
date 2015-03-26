/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.admin.controller.beauty;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mm.admin.controller.BaseController;

/**
 * description here
 *
 * @author lidehua
 * @since 2015年3月26日
 */
@Controller
public class BeauticianController extends BaseController {

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
        
        return vm("beauticians");
    }

}
