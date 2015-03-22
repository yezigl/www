/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.web.controller.beauty;

import gl.yezi.data.model.beauty.Beautician;
import gl.yezi.data.model.beauty.BeauticianTime;
import gl.yezi.data.model.beauty.Coupon;
import gl.yezi.data.model.beauty.Deal;
import gl.yezi.data.model.beauty.Order;
import gl.yezi.data.model.user.UserAddress;
import gl.yezi.data.utils.DateUtils;
import gl.yezi.service.beauty.BeauticianService;
import gl.yezi.service.beauty.DealService;
import gl.yezi.service.beauty.OrderService;
import gl.yezi.service.context.UserContext;
import gl.yezi.service.user.UserService;
import gl.yezi.service.utils.Utils;
import gl.yezi.web.annotation.Auth;
import gl.yezi.web.controller.AbstractController;
import gl.yezi.web.res.Status;
import gl.yezi.web.res.beauty.BeauticianRes;
import gl.yezi.web.res.beauty.DealRes;
import gl.yezi.web.res.beauty.OrderCreateRes;
import gl.yezi.web.res.beauty.OrderListRes;
import gl.yezi.web.res.beauty.OrderRes;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月1日
 */
@RestController
@RequestMapping(value = "/1/beauty")
public class OrderController extends AbstractController {

    @Resource
    OrderService orderService;

    @Resource
    DealService dealService;

    @Resource
    BeauticianService beauticianService;

    @Resource
    UserService userService;

    @Auth
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public OrderCreateRes create(@RequestParam int dealId, @RequestParam int beauticianId,
            @RequestParam(defaultValue = "0") int couponId, @RequestParam int addressId,
            @RequestParam String startTime, @RequestParam String endTime,
            @RequestHeader(value = "X-Forwarded-For", required = false) String forwardIp,
            @RequestHeader(value = "X-Real-IP", required = false) String realIp) {

        OrderCreateRes res = new OrderCreateRes();

        // TODO param check
        Date st = DateUtils.parse(startTime);
        Date et = DateUtils.parse(endTime);
        if (st == null || et == null) {
            res.setStatus(Status.PARAM_ERROR, "上门时间错误");
        }

        Deal deal = dealService.get(dealId);
        Order order = new Order();
        order.setDealId(dealId);
        order.setAmount(deal.getPrice());
        if (couponId > 0) {
            Coupon coupon = orderService.getCoupon(couponId);
            if (coupon != null) {
                order.setDiscount(coupon.getDiscount());
                order.setCouponId(couponId);
            } else {
                res.setStatus(Status.NOT_EXIST, "优惠券不存在");
                return res;
            }
        } else {
            order.setDiscount(0);
        }
        order.setBeauticianId(beauticianId);
        order.setIp(Utils.getClientIP(forwardIp, realIp));
        order.setAddressId(addressId);
        order.setUserId(UserContext.getUid());
        order.setStatus(Order.STATUS_TOPAY);

        orderService.create(order);
        if (order.getId() > 0) {
            BeauticianTime bt = new BeauticianTime();
            bt.setOrderId(order.getId());
            bt.setBeauticianId(beauticianId);
            bt.setStatus(BeauticianTime.STATUS_TODO);
            bt.setStartTime(st);
            bt.setEndTime(et);
            orderService.addHomeTime(bt);
        }

        res.setId(order.getId());
        res.setCtime(order.getCtime());
        res.setPayPrice(order.getAmount() - order.getDiscount());

        return res;
    }

    @Auth
    @RequestMapping(value = "/order", method = RequestMethod.PUT)
    public OrderCreateRes create(@RequestParam int orderId, @RequestParam(required = false) String startTime,
            @RequestParam(required = false) String endTime) {

        OrderCreateRes res = new OrderCreateRes();

        return res;
    }

    @Auth
    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET)
    public OrderRes order(@PathVariable int orderId) {
        OrderRes res = new OrderRes();

        Order order = orderService.get(orderId);
        if (order == null) {
            res.setStatus(Status.NOT_EXIST, "订单不存在");
            return res;
        }

        res = getOrderRes(order);

        return res;
    }

    @Auth
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public OrderListRes orderList(@RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "0") int status) {

        OrderListRes res = new OrderListRes();

        List<Order> list = orderService.getList(status, offset, LIMIT);
        for (Order order : list) {
            res.addOrderRes(getOrderRes(order));
        }
        res.setOffset(list.size());

        return res;
    }

    private OrderRes getOrderRes(Order order) {
        OrderRes res = new OrderRes();
        Deal deal = dealService.get(order.getDealId());
        Beautician beautician = beauticianService.get(order.getBeauticianId());
        UserAddress userAddress = userService.getAddress(order.getId());
        res.setId(order.getId());
        res.setCtime(order.getCtime());
        res.setAmount(order.getAmount());
        res.setDiscount(order.getDiscount());
        res.setStatus(order.getStatusStr());
        res.setAddress(userAddress.getAddress());
        res.setPay(order.isPay());
        res.setDeal(new DealRes(deal));
        res.setBeautician(new BeauticianRes(beautician));

        return res;
    }
}
