/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.dao.movie;

import gl.yezi.data.mapper.movie.RegionMapper;
import gl.yezi.data.model.movie.Region;

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
public class RegionDao {

    @Resource
    RegionMapper regionMapper;

    public int create(Region region) {
        return regionMapper.create(region);
    }

    @Cacheable(value = "region", key = "#id")
    public Region get(int id) {
        return regionMapper.get(id);
    }

}
