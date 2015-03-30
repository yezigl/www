/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.web.controller.beauty;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mm.web.controller.AbstractController;
import com.mm.web.res.PromotionRes;
import com.mm.web.res.beauty.ConfigRes;

/**
 * description here
 *
 * @author yezi
 * @since 2015年2月6日
 */
@RestController
@RequestMapping("/1/beauty")
public class BeautyController extends AbstractController {

    @RequestMapping(value = "/config", method = RequestMethod.GET)
    public ConfigRes config() {
        ConfigRes res = new ConfigRes();
        return res;
    }
    
    @RequestMapping(value = "/promotions", method = RequestMethod.GET)
    public List<PromotionRes> promotions() {
        List<PromotionRes> list = new ArrayList<PromotionRes>();
        
        PromotionRes res1 = new PromotionRes();
        res1.setImgUrl("http://p1.meituan.net/mmc/dbc70b32f22415bc55d1523d7141735c18365.jpg.webp");
        res1.setRedirectUrl("http://www.meituan.com/");
        PromotionRes res2 = new PromotionRes();
        res2.setImgUrl("http://www.dpfile.com/toevent/img/f41a299264f2c8d38d3ab7697366a6b5.jpg");
        res2.setRedirectUrl("http://www.dianping.com/");
        list.add(res1);
        list.add(res2);
        
        return list;
    }
}
