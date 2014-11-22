/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.dao.time;

import gl.yezi.data.mapper.time.CollegeMapper;
import gl.yezi.data.model.time.College;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月5日
 */
@Repository
public class CollegeDao {

    @Resource
    CollegeMapper collegeMapper;

    public int create(College college) {
        return collegeMapper.create(college);
    }

    @Cacheable(value = { "college" }, key = "#id")
    public College getCollege(int id) {
        return collegeMapper.get(id);
    }
    
    public int getSchoolId(int collid) {
        return collegeMapper.getSchoolId(collid);
    }
    
    public List<College> getColleges(int schid) {
        return collegeMapper.getColleges(schid);
    }
}
