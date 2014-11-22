/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.web.controller.time;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * description here
 *
 * @author yezi
 * @since 2014年10月28日
 */
@Controller
@RequestMapping("/1/time")
public class TimeBuyController {

    @RequestMapping(value = "/buy", method = RequestMethod.GET)
    public void buy() {

    }
}
