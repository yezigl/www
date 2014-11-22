/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.dao.time;

import gl.yezi.data.mapper.time.SchoolMapper;
import gl.yezi.data.model.time.School;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月4日
 */
@Repository
public class SchoolDao {

    @Resource
    SchoolMapper schoolMapper;

    public int create(School school) {
        return schoolMapper.create(school);
    }
    
    @Cacheable(value = { "school" }, key = "#id")
    public School get(int id) {
        return schoolMapper.get(id);
    }
}
