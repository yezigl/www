/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.web.controller.beauty;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gl.yezi.web.controller.AbstractController;
import gl.yezi.web.res.beauty.DealListRes;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月1日
 */
@RestController
@RequestMapping(value = "/1/beauty")
public class DealController extends AbstractController {

    @RequestMapping(value = "/deals", method = RequestMethod.GET)
    public DealListRes dealList(@RequestParam(defaultValue = "0") int offset) {
        DealListRes res = new DealListRes();
        
        return res;
    }
}
