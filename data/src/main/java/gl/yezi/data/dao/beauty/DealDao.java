package gl.yezi.data.dao.beauty;

import java.util.List;

import gl.yezi.data.mapper.beauty.DealMapper;
import gl.yezi.data.model.beauty.Deal;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
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

    /**
     * @param offset
     * @param limit
     * @return
     */
    public List<Deal> getList(int offset, int limit) {
        return dealMapper.getList(new RowBounds(offset, limit));
    }
}