/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.service.beauty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mm.data.dao.beauty.BeauticianTimeDao;
import com.mm.data.dao.beauty.CouponDao;
import com.mm.data.dao.beauty.OrderDao;
import com.mm.data.model.beauty.BeauticianTime;
import com.mm.data.model.beauty.Coupon;
import com.mm.data.model.beauty.Order;
import com.mm.service.BaseService;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月9日
 */
@Service
public class OrderService extends BaseService {
    
    @Resource
    OrderDao orderDao;
    
    @Resource
    CouponDao couponDao;
    
    @Resource
    BeauticianTimeDao beauticianTimeDao;

    public int create(Order order) {
        order.setCtime(new Date());
        order.setUtime(new Date());
        return orderDao.create(order);
    }
    
    public Order get(int id) {
        if (id <= 0) {
            return null;
        }
        return orderDao.get(id);
    }

    public Coupon getCoupon(int couponId) {
        return couponDao.get(couponId);
    }

    public List<Order> getList(int status, int offset, int limit) {
        List<Order> list = orderDao.getList(status, offset, limit);
        return list == null ? new ArrayList<Order>() : list;
    }

    public int addHomeTime(BeauticianTime bt) {
        return beauticianTimeDao.create(bt);
    }

    public List<Order> getListByMobile(String mobile) {
        return orderDao.getListByMobile(mobile);
    }
}
