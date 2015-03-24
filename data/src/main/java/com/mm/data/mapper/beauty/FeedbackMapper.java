package com.mm.data.mapper.beauty;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import com.mm.data.model.beauty.Feedback;

public interface FeedbackMapper {

    @Insert("INSERT INTO feedback (userid, dealid, beauticianid, content, ctime, utime, ip, score, status, reply, replytime) VALUES (#{userId}, #{dealId}, #{beauticianId}, #{content}, #{ctime}, #{utime}, #{ip}, #{score}, #{status}, #{reply}, #{replyTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int create(Feedback feedback);

    @Select("SELECT * FROM feedback WHERE id = #{id}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "userid", property = "userId"),
        @Result(column = "dealid", property = "dealId"),
        @Result(column = "beauticianid", property = "beauticianId"),
        @Result(column = "content", property = "content"),
        @Result(column = "ctime", property = "ctime"),
        @Result(column = "utime", property = "utime"),
        @Result(column = "ip", property = "ip"),
        @Result(column = "score", property = "score"),
        @Result(column = "status", property = "status"),
        @Result(column = "reply", property = "reply"),
        @Result(column = "replytime", property = "replyTime")
    })
    Feedback get(int id);

    @Update("UPDATE feedback SET userid = #{userId}, dealid = #{dealId}, beauticianid = #{beauticianId}, content = #{content}, ctime = #{ctime}, utime = #{utime}, ip = #{ip}, score = #{score}, status = #{status}, reply = #{reply}, replytime = #{replyTime} WHERE id = #{id}")
    int update(Feedback feedback);

    @Select({"SELECT * FROM feedback WHERE", 
        "<where>", 
        "<if test='dealId != 0'> userId = #{userId}</if>",
        "<if test='dealId != 0'> AND dealId = #{dealId}</if>",
        "<if test='beauticianId != 0'> AND beauticianId = #{beauticianId}</if>",
        "</where>", "ORDER BY id DESC", "</script>"})
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "userid", property = "userId"),
        @Result(column = "dealid", property = "dealId"),
        @Result(column = "beauticianid", property = "beauticianId"),
        @Result(column = "content", property = "content"),
        @Result(column = "ctime", property = "ctime"),
        @Result(column = "utime", property = "utime"),
        @Result(column = "ip", property = "ip"),
        @Result(column = "score", property = "score"),
        @Result(column = "status", property = "status"),
        @Result(column = "reply", property = "reply"),
        @Result(column = "replytime", property = "replyTime")
    })
    List<Feedback> getList(@Param("userId") int userId, @Param("dealId") int dealId, @Param("beauticianId") int beauticianId, RowBounds rowBounds);
}