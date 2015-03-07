package gl.yezi.data.dao.beauty;

import gl.yezi.data.mapper.beauty.BeauticianDealMapper;
import gl.yezi.data.model.beauty.BeauticianDeal;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

@Repository
public class BeauticianDealDao {

    @Resource
    BeauticianDealMapper beauticiandealMapper;

    public int create(BeauticianDeal beauticiandeal) {
        return beauticiandealMapper.create(beauticiandeal);
    }

    public BeauticianDeal get(int id) {
        return beauticiandealMapper.get(id);
    }

    public void update(BeauticianDeal beauticiandeal) {
        beauticiandealMapper.update(beauticiandeal);
    }
}