package com.mm.data.mapper.beauty;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import com.mm.data.model.beauty.Beautician;

public interface BeauticianMapper {

    @Insert("INSERT INTO beautician (name, gender, age, birthday, avatar, introduction, jointime, idno, experience, advantage, skill) VALUES (#{name}, #{gender}, #{age}, #{birthday}, #{avatar}, #{introduction}, #{jointime}, #{idno}, #{experience}, #{advantage}, #{skill})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int create(Beautician beautician);

    @Select("SELECT * FROM beautician WHERE id = #{id}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "name", property = "name"),
        @Result(column = "gender", property = "gender"),
        @Result(column = "age", property = "age"),
        @Result(column = "birthday", property = "birthday"),
        @Result(column = "avatar", property = "avatar"),
        @Result(column = "introduction", property = "introduction"),
        @Result(column = "jointime", property = "jointime"),
        @Result(column = "idno", property = "idno"),
        @Result(column = "experience", property = "experience"),
        @Result(column = "advantage", property = "advantage"),
        @Result(column = "skill", property = "skill")
    })
    Beautician get(int id);

    @Update("UPDATE beautician SET name = #{name}, gender = #{gender}, age = #{age}, birthday = #{birthday}, avatar = #{avatar}, introduction = #{introduction}, jointime = #{jointime}, idno = #{idno}, experience = #{experience}, advantage = #{advantage}, skill = #{skill} WHERE id = #{id}")
    int update(Beautician beautician);

    @Select("SELECT * FROM beautician")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "name", property = "name"),
        @Result(column = "gender", property = "gender"),
        @Result(column = "age", property = "age"),
        @Result(column = "birthday", property = "birthday"),
        @Result(column = "avatar", property = "avatar"),
        @Result(column = "introduction", property = "introduction"),
        @Result(column = "jointime", property = "jointime"),
        @Result(column = "idno", property = "idno"),
        @Result(column = "experience", property = "experience"),
        @Result(column = "advantage", property = "advantage"),
        @Result(column = "skill", property = "skill")
    })
    List<Beautician> getList(RowBounds rowBounds);
}