/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.web.controller.beauty;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gl.yezi.web.controller.AbstractController;
import gl.yezi.web.res.beauty.OrderCreateRes;
import gl.yezi.web.res.beauty.OrderListRes;
import gl.yezi.web.res.beauty.OrderRes;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月1日
 */
@RestController
@RequestMapping(value = "/1/beauty")
public class OrderController extends AbstractController {

    @RequestMapping(value = "/order/create", method = RequestMethod.PUT)
    public OrderCreateRes create(@RequestParam int dealId, @RequestParam int employeeId,
            @RequestParam(defaultValue = "0") int couponId) {

        OrderCreateRes res = new OrderCreateRes();

        return res;
    }

    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET)
    public OrderRes order(@PathVariable int orderId) {

        OrderRes res = new OrderRes();

        return res;
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public OrderListRes orderList(@RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "0") int status) {

        OrderListRes res = new OrderListRes();

        return res;
    }
}
