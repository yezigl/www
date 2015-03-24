package com.mm.data.mapper.time;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mm.data.model.time.School;

public interface SchoolMapper {

    @Insert("INSERT INTO school (name, province, city, address, type, homepage) VALUES (#{name}, #{province}, #{city}, #{address}, #{type}, #{homepage})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int create(School school);

    @Select("SELECT * FROM school WHERE id = #{id}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "name", property = "name"),
        @Result(column = "province", property = "province"),
        @Result(column = "city", property = "city"),
        @Result(column = "address", property = "address"),
        @Result(column = "type", property = "type"),
        @Result(column = "homepage", property = "homepage")
    })
    School get(int id);

    @Update("UPDATE school SET name = #{name}, province = #{province}, city = #{city}, address = #{address}, type = #{type}, homepage = #{homepage} WHERE id = #{id}")
    int update(School school);
}