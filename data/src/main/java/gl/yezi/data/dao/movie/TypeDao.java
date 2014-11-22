/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.dao.movie;

import gl.yezi.data.mapper.movie.TypeMapper;
import gl.yezi.data.model.movie.Type;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * description here
 *
 * @author yezi
 * @since 2014年8月21日
 */
@Repository
public class TypeDao {

    @Resource
    TypeMapper typeMapper;
    
    public int create(Type type) {
        return typeMapper.create(type);
    }
    
    @Cacheable(value = "type", key = "#id")
    public Type get(int id) {
        return typeMapper.get(id);
    }
    
}
