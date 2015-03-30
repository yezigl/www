package com.mm.data.dao.beauty;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.mm.data.mapper.beauty.DealMapper;
import com.mm.data.model.beauty.Deal;

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

    public int update(Deal deal) {
        return dealMapper.update(deal);
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