/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.mapper.time;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import gl.yezi.data.model.time.College;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月4日
 */
public interface CollegeMapper {

    @Insert("INSERT INTO college (schid, name) VALUES (#{schid}, #{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int create(College college);
    
    @Select("SELECT * FROM college WHERE id = #{id}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "schid", property = "schid"),
        @Result(column = "name", property = "name")
    })
    College get(int id);

    @Select("SELECT schid FROM college WHERE id = #{id}")
    int getSchoolId(int id);

    @Select("SELECT * FROM college WHERE schid = #{schid}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "schid", property = "schid"),
        @Result(column = "name", property = "name")
    })
    List<College> getColleges(int schid);
}
