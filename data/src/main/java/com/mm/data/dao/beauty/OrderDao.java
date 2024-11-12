package com.mm.data.dao.beauty;

import java.util.List;

import jakarta.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.mm.data.mapper.beauty.OrderMapper;
import com.mm.data.model.beauty.Order;

@Repository
public class OrderDao {

    @Resource
    OrderMapper orderMapper;

    public int create(Order order) {
        return orderMapper.create(order);
    }

    public Order get(int id) {
        return orderMapper.get(id);
    }

    public void update(Order order) {
        orderMapper.update(order);
    }

    public List<Order> getList(int status, int offset, int limit) {
        return orderMapper.getList(status, new RowBounds(offset, limit));
    }

    /**
     * @param mobile
     * @return
     */
    public List<Order> getListByMobile(String mobile) {
        return orderMapper.getListByMobile(mobile);
    }
}