/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.yueqiu.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yueqiu.entity.Activity;
import com.yueqiu.entity.Order;
import com.yueqiu.entity.User;
import com.yueqiu.model.OrderStatus;

/**
 * description here
 *
 * @author yezi
 * @since 2015年6月14日
 */
@Service
public class OrderService extends BaseService {

    public Order get(String id) {
        return orderDao.get(id);
    }
    
    public String create(Order order) {
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        order.setStatus(OrderStatus.CREATE.code);
        return orderDao.create(order);
    }
    
    public boolean update(Order order) {
        return orderDao.update(order);
    }
    
    public List<Order> listByUser(User user, OrderStatus status, int offset, int limit) {
        return orderDao.listByUser(user, status, offset, limit);
    }
    
    public List<Order> getByUserAndActivity(User user, Activity activity, OrderStatus status) {
        return orderDao.getByUserAndActivity(user, activity, status);
    }
}
