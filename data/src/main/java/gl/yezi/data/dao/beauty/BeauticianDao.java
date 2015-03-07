package gl.yezi.data.dao.beauty;

import java.util.List;

import gl.yezi.data.mapper.beauty.BeauticianMapper;
import gl.yezi.data.model.beauty.Beautician;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

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

    public void update(Beautician beautician) {
        beauticianMapper.update(beautician);
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