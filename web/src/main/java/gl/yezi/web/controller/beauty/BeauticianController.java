/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.web.controller.beauty;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gl.yezi.data.model.beauty.Beautician;
import gl.yezi.service.beauty.BeauticianService;
import gl.yezi.web.controller.AbstractController;
import gl.yezi.web.res.Status;
import gl.yezi.web.res.beauty.BeauticianListRes;
import gl.yezi.web.res.beauty.BeauticianRes;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月1日
 */
@RestController
@RequestMapping("/1/beauty")
public class BeauticianController extends AbstractController {
    
    @Resource
    BeauticianService beauticianService;

    @RequestMapping(value = "/beautician/{beauticianId}", method = RequestMethod.GET)
    public BeauticianRes beautician(@PathVariable int beauticianId) {
        BeauticianRes res = new BeauticianRes();
        
        Beautician beautician = beauticianService.get(beauticianId);
        if (beautician == null) {
            res.setStatus(Status.NOT_EXIST, "美容师不存在");
            return res;
        }
        res.setBeautician(beautician);
        
        return res;
    }
    
    @RequestMapping(value = "/beauticians", method = RequestMethod.GET)
    public BeauticianListRes beauticianList(@RequestParam(defaultValue = "0") int offset) {
        BeauticianListRes res = new BeauticianListRes();
        
        List<Beautician> list = beauticianService.getList(offset, LIMIT);
        for (Beautician beautician : list) {
            res.addBeautician(new BeauticianRes(beautician));
        }
        res.setOffset(list.size());
        
        return res;
    }
}
