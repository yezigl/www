package gl.yezi.data.dao.beauty;

import java.util.List;

import gl.yezi.data.mapper.beauty.OrderMapper;
import gl.yezi.data.model.beauty.Order;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
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

    public List<Order> getList(int status, int offset, int limit) {
        return orderMapper.getList(status, new RowBounds(offset, limit));
    }
}