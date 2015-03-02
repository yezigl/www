package gl.yezi.data.dao.beauty;

import gl.yezi.data.mapper.beauty.OrderMapper;
import gl.yezi.data.model.beauty.Order;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

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
}