/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.web.controller.beauty;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gl.yezi.web.controller.AbstractController;
import gl.yezi.web.res.beauty.EmployeeListRes;
import gl.yezi.web.res.beauty.EmployeeRes;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月1日
 */
@RestController
@RequestMapping("/1/beauty/")
public class EmployeeController extends AbstractController {

    @RequestMapping(value = "/employee/{employeeId}", method = RequestMethod.GET)
    public EmployeeRes employee() {
        EmployeeRes res = new EmployeeRes();
        
        return res;
    }
    
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public EmployeeListRes employeeList(@RequestParam(defaultValue = "0") int offset) {
        EmployeeListRes res = new EmployeeListRes();
        return res;
    }
}
