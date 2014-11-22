/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.mapper.time;

import gl.yezi.data.model.time.Timetable;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月4日
 */
public interface TimetableMapper {

    @Insert("INSERT INTO timetable (schid, collid, season, cdate, ctime, classroom) "
            + "VALUES "
            + "(#{schid}, #{collid}, #{season}, #{cdate}, #{ctime}, #{classroom})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int create(Timetable timetable);
    
    @Select("SELECT * FROM timetable WHERE id = #{id}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "schid", property = "schid"),
        @Result(column = "collid", property = "collid"),
        @Result(column = "season", property = "season"),
        @Result(column = "cdate", property = "cdate"),
        @Result(column = "ctime", property = "ctime"),
        @Result(column = "classroom", property = "classroom")
    })
    Timetable get(int id);

    @Select({"<script>",
        "SELECT *", 
        "FROM timetable",
        "<where>", 
            "<if test='schid != 0'>schid = #{schid}</if>",
            "<if test='collid != 0'>AND collid = #{collid}</if>",
            "<if test='cdate != null'>AND cdate = #{cdate}</if>",
        "</where>",
        "</script>"})
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "schid", property = "schid"),
        @Result(column = "collid", property = "collid"),
        @Result(column = "season", property = "season"),
        @Result(column = "cdate", property = "cdate"),
        @Result(column = "ctime", property = "ctime"),
        @Result(column = "classroom", property = "classroom")
    })
    List<Timetable> getList(@Param("schid") int schid, @Param("collid") int collid, @Param("cdate") String cdate);
}
