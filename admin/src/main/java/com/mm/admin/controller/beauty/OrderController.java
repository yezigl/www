/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.admin.controller.beauty;

import org.springframework.stereotype.Controller;

import com.mm.admin.controller.BaseController;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月31日
 */
@Controller
public class OrderController extends BaseController {

    @Override
    protected String vmtpl() {
        return "order";
    }

    @Override
    protected String category() {
        return "order";
    }

}
