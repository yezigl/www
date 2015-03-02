package gl.yezi.data.mapper.beauty;

import gl.yezi.data.model.beauty.Feedback;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface FeedbackMapper {

    @Insert("INSERT INTO feedback (userid, dealid, employeeid, content, ctime, utime, reply, replytime, ip, score) VALUES (#{userId}, #{dealId}, #{employeeId}, #{content}, #{ctime}, #{utime}, #{reply}, #{replyTime}, #{ip}, #{score})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int create(Feedback feedback);

    @Select("SELECT * FROM feedback WHERE id = #{id}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "userid", property = "userId"),
        @Result(column = "dealid", property = "dealId"),
        @Result(column = "employeeid", property = "employeeId"),
        @Result(column = "content", property = "content"),
        @Result(column = "ctime", property = "ctime"),
        @Result(column = "utime", property = "utime"),
        @Result(column = "reply", property = "reply"),
        @Result(column = "replytime", property = "replyTime"),
        @Result(column = "ip", property = "ip"),
        @Result(column = "score", property = "score")
    })
    Feedback get(int id);

    @Update("UPDATE feedback SET userid = #{userId}, dealid = #{dealId}, employeeid = #{employeeId}, content = #{content}, ctime = #{ctime}, utime = #{utime}, reply = #{reply}, replytime = #{replyTime}, ip = #{ip}, score = #{score} WHERE id = #{id}")
    int update(Feedback feedback);
}