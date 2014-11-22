/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.dao.movie;

import gl.yezi.data.mapper.movie.TagMapper;
import gl.yezi.data.model.movie.Tag;

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
public class TagDao {

    @Resource
    TagMapper tagMapper;
    
    public int create(Tag tag) {
        return tagMapper.create(tag);
    }
    
    @Cacheable(value = "tag", key = "#id")
    public Tag get(int id) {
        return tagMapper.get(id);
    }
    
}
