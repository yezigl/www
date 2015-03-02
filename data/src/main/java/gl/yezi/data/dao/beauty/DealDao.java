package gl.yezi.data.dao.beauty;

import gl.yezi.data.mapper.beauty.DealMapper;
import gl.yezi.data.model.beauty.Deal;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

@Repository
public class DealDao {

    @Resource
    DealMapper dealMapper;

    public int create(Deal deal) {
        return dealMapper.create(deal);
    }

    public Deal get(int id) {
        return dealMapper.get(id);
    }

    public void update(Deal deal) {
        dealMapper.update(deal);
    }
}