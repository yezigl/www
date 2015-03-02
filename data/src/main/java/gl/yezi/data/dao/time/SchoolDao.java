package gl.yezi.data.dao.time;

import gl.yezi.data.mapper.time.SchoolMapper;
import gl.yezi.data.model.time.School;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

@Repository
public class SchoolDao {

    @Resource
    SchoolMapper schoolMapper;

    public int create(School school) {
        return schoolMapper.create(school);
    }

    public School get(int id) {
        return schoolMapper.get(id);
    }

    public void update(School school) {
        schoolMapper.update(school);
    }
}