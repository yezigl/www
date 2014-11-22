/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.mapper.movie;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import gl.yezi.data.model.movie.Region;

/**
 * description here
 *
 * @author yezi
 * @since 2014年8月21日
 */
public interface RegionMapper {

    @Insert("INSERT INTO region (name) VALUES (#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int create(Region region);
    
    @Select("SELECT * FROM region WHERE id = #{id}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "name", property = "name")
    })
    Region get(int id);
}
