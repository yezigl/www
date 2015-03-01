/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.web.controller.beauty;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gl.yezi.web.controller.AbstractController;
import gl.yezi.web.res.beauty.ConfigRes;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月1日
 */
@RestController
@RequestMapping("/1/beauty/")
public class BeautyController extends AbstractController {

    @RequestMapping(value = "/config", method = RequestMethod.GET)
    public ConfigRes config() {
        ConfigRes res = new ConfigRes();
        return res;
    }
}
