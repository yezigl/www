/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.yueqiu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yueqiu.entity.Order;

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
    
    public boolean create(Order order) {
        return orderDao.create(order);
    }
    
    public boolean update(Order order) {
        return orderDao.update(order);
    }
    
    public List<Order> listByUser(String userId) {
        return orderDao.listByUser(userId);
    }
}
