/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.mapper.time;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import gl.yezi.data.model.time.School;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月4日
 */
public interface SchoolMapper {

    @Insert("INSERT INTO school (name, province, city, address, type, homepage) "
            + "VALUES "
            + "(#{name}, #{province}, #{city}, #{address}, #{type}, #{homepage})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int create(School school);
    
    @Select("SELECT * FROM school WHERE id = #{id}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "name", property = "name"),
        @Result(column = "province", property = "province"),
        @Result(column = "city", property = "city"),
        @Result(column = "address", property = "address"),
    })
    School get(int id);
}
