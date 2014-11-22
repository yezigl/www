/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.dao.movie;

import javax.annotation.Resource;

import gl.yezi.data.mapper.movie.CelebrityMapper;
import gl.yezi.data.model.movie.Celebrity;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * description here
 *
 * @author yezi
 * @since 2014年8月21日
 */
@Repository
public class CelebrityDao {
    
    @Resource
    CelebrityMapper celebrityMapper;

    public int create(Celebrity celebrity) {
        return celebrityMapper.create(celebrity);
    }

    @Cacheable(value = "celebrity", key = "#id")
    public Celebrity get(int id) {
        return celebrityMapper.get(id);
    }
    
    @CacheEvict(value = "celebrity", key = "#celebrity.id")
    public void update(Celebrity celebrity) {
        celebrityMapper.update(celebrity);
    }
}
