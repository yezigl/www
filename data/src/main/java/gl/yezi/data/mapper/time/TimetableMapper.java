package gl.yezi.data.mapper.time;

import gl.yezi.data.model.time.Timetable;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TimetableMapper {

    @Insert("INSERT INTO timetable (schid, collid, season, cdate, ctime, classroom) VALUES (#{schid}, #{collid}, #{season}, #{cdate}, #{ctime}, #{classroom})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
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

    @Update("UPDATE timetable SET schid = #{schid}, collid = #{collid}, season = #{season}, cdate = #{cdate}, ctime = #{ctime}, classroom = #{classroom} WHERE id = #{id}")
    int update(Timetable timetable);
}