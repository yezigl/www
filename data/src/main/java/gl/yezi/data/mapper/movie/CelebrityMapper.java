/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.mapper.movie;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import gl.yezi.data.model.movie.Celebrity;

/**
 * description here
 *
 * @author yezi
 * @since 2014年8月21日
 */
public interface CelebrityMapper {

    @Insert("INSERT INTO celebrity "
            + "(name, name_en, aka, aka_en, birthday, deadday, gender, constellation, birthplace, summary, avatar, family, professions, douban, imdb) "
            + "VALUES"
            + "(#{name}, #{nameEn}, #{aka}, #{akaEn}, #{birthday}, #{deadday}, #{gender}, #{constellation}, #{birthplace}, #{summary}, #{avatar}, #{family}, #{professions}, #{douban}, #{imdb})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int create(Celebrity celebrity);
    
    @Update("UPDATE celebrity"
            + "SET"
            + "name = #{name}, name_en = #{nameEn}, aka = #{aka}, aka_en = #{akaEn}, birthday = #{birthday}, deadday = #{deadday}, gender = #{gender}, constellation = #{constellation}, "
            + "birthplace = #{birthplace}, summary = #{summary}, avatar = #{avatar}, family = #{family}, professions = #{professions}, douban = #{douban}, imdb = #{imdb}"
            + "WHERE id = #{id}")
    void update(Celebrity celebrity);
    
    @Select("SELECT * FROM celebrity WHERE id = #{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "name_en", property = "nameEn"),
            @Result(column = "aka", property = "aka"),
            @Result(column = "aka", property = "akaEn"),
            @Result(column = "birthday", property = "birthday"),
            @Result(column = "deadday", property = "deadday"),
            @Result(column = "gender", property = "gender"),
            @Result(column = "constellation", property = "constellation"),
            @Result(column = "birthday", property = "birthday"),
            @Result(column = "summary", property = "summary"),
            @Result(column = "avatar", property = "avatar"),
            @Result(column = "family", property = "family"),
            @Result(column = "professions", property = "professions"),
            @Result(column = "douban", property = "douban"),
            @Result(column = "imdb", property = "imdb")
    })
    Celebrity get(int id);
}
