package com.mm.data.mapper.time;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mm.data.model.time.UserBuy;

public interface UserBuyMapper {

    @Insert("INSERT INTO userbuy (sellid, uid, ctime, utime, status, ip) VALUES (#{sellid}, #{uid}, #{ctime}, #{utime}, #{status}, #{ip})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int create(UserBuy userbuy);

    @Select("SELECT * FROM userbuy WHERE id = #{id}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "sellid", property = "sellid"),
        @Result(column = "uid", property = "uid"),
        @Result(column = "ctime", property = "ctime"),
        @Result(column = "utime", property = "utime"),
        @Result(column = "status", property = "status"),
        @Result(column = "ip", property = "ip")
    })
    UserBuy get(int id);

    @Update("UPDATE userbuy SET sellid = #{sellid}, uid = #{uid}, ctime = #{ctime}, utime = #{utime}, status = #{status}, ip = #{ip} WHERE id = #{id}")
    int update(UserBuy userbuy);
}