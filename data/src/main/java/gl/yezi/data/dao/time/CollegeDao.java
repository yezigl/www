package gl.yezi.data.dao.time;

import gl.yezi.data.mapper.time.CollegeMapper;
import gl.yezi.data.model.time.College;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

@Repository
public class CollegeDao {

    @Resource
    CollegeMapper collegeMapper;

    public int create(College college) {
        return collegeMapper.create(college);
    }

    public College get(int id) {
        return collegeMapper.get(id);
    }

    public void update(College college) {
        collegeMapper.update(college);
    }
}