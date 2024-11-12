package com.mm.data.dao.beauty;

import java.util.List;

import jakarta.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.mm.data.mapper.beauty.BeauticianMapper;
import com.mm.data.model.beauty.Beautician;

@Repository
public class BeauticianDao {

    @Resource
    BeauticianMapper beauticianMapper;

    public int create(Beautician beautician) {
        return beauticianMapper.create(beautician);
    }

    public Beautician get(int id) {
        return beauticianMapper.get(id);
    }

    public int update(Beautician beautician) {
        return beauticianMapper.update(beautician);
    }

    /**
     * @param offset
     * @param limit
     * @return
     */
    public List<Beautician> getList(int offset, int limit) {
        return beauticianMapper.getList(new RowBounds(offset, limit));
    }
}