package gl.yezi.data.dao.beauty;

import java.util.List;

import gl.yezi.data.mapper.beauty.FlowMapper;
import gl.yezi.data.model.beauty.Flow;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

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