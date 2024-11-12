package com.mm.data.dao.beauty;

import java.util.List;

import jakarta.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.mm.data.mapper.beauty.FlowMapper;
import com.mm.data.model.beauty.Flow;

@Repository
public class FlowDao {

    @Resource
    FlowMapper flowMapper;

    public int create(Flow flow) {
        return flowMapper.create(flow);
    }

    public Flow get(int id) {
        return flowMapper.get(id);
    }

    public void update(Flow flow) {
        flowMapper.update(flow);
    }
    
    public List<Flow> getList(int... ids) {
        return flowMapper.getList(ids);
    }
}