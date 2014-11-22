/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.mapper.movie;

import gl.yezi.data.model.movie.Tag;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * description here
 *
 * @author yezi
 * @since 2014年8月21日
 */
public interface TagMapper {

    @Insert("INSERT INTO tag (name) VALUES (#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int create(Tag tag);
    
    @Select("SELECT * FROM tag WHERE id = #{id}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "name", property = "name")
    })
    Tag get(int id);
}
