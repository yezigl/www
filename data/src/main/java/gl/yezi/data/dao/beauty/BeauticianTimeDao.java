package gl.yezi.data.dao.beauty;

import gl.yezi.data.mapper.beauty.BeauticianTimeMapper;
import gl.yezi.data.model.beauty.BeauticianTime;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

@Repository
public class BeauticianTimeDao {

    @Resource
    BeauticianTimeMapper beauticiantimeMapper;

    public int create(BeauticianTime beauticiantime) {
        return beauticiantimeMapper.create(beauticiantime);
    }

    public BeauticianTime get(int id) {
        return beauticiantimeMapper.get(id);
    }

    public void update(BeauticianTime beauticiantime) {
        beauticiantimeMapper.update(beauticiantime);
    }
}