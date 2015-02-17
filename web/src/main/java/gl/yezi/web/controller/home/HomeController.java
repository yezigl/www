/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.web.controller.home;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gl.yezi.web.controller.AbstractController;
import gl.yezi.web.res.PromotionRes;

/**
 * description here
 *
 * @author yezi
 * @since 2015年2月6日
 */
@RestController
public class HomeController extends AbstractController {

    @RequestMapping(value = "/promotions")
    public PromotionRes promotions() {
        PromotionRes res = new PromotionRes();
        
        
        
        return res;
    }
}
