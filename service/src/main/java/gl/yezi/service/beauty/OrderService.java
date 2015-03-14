/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.service.beauty;

import gl.yezi.data.dao.beauty.BeauticianTimeDao;
import gl.yezi.data.dao.beauty.CouponDao;
import gl.yezi.data.dao.beauty.OrderDao;
import gl.yezi.data.model.beauty.BeauticianTime;
import gl.yezi.data.model.beauty.Coupon;
import gl.yezi.data.model.beauty.Order;
import gl.yezi.service.BaseService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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

    /**
     * @param bt
     * @return
     */
    public int addHomeTime(BeauticianTime bt) {
        return beauticianTimeDao.create(bt);
    }
}
