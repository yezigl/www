package com.mm.data.mapper.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mm.data.model.user.User;

public interface UserMapper {

    @Insert("INSERT INTO user (login, regtype, app, password, salt, nickname, email, mobile, regip, ctime, status, avatar, role) VALUES (#{login}, #{regtype}, #{app}, #{password}, #{salt}, #{nickname}, #{email}, #{mobile}, #{regip}, #{ctime}, #{status}, #{avatar}, #{role})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int create(User user);

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "login", property = "login"),
        @Result(column = "regtype", property = "regtype"),
        @Result(column = "app", property = "app"),
        @Result(column = "password", property = "password"),
        @Result(column = "salt", property = "salt"),
        @Result(column = "nickname", property = "nickname"),
        @Result(column = "email", property = "email"),
        @Result(column = "mobile", property = "mobile"),
        @Result(column = "regip", property = "regip"),
        @Result(column = "ctime", property = "ctime"),
        @Result(column = "status", property = "status"),
        @Result(column = "avatar", property = "avatar"),
        @Result(column = "role", property = "role")
    })
    User get(int id);

    @Update("UPDATE user SET login = #{login}, regtype = #{regtype}, app = #{app}, password = #{password}, salt = #{salt}, nickname = #{nickname}, email = #{email}, mobile = #{mobile}, regip = #{regip}, ctime = #{ctime}, status = #{status}, avatar = #{avatar}, role = #{role} WHERE id = #{id}")
    int update(User user);

    @Select("SELECT * FROM user WHERE login = #{login}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "login", property = "login"),
        @Result(column = "regtype", property = "regtype"),
        @Result(column = "app", property = "app"),
        @Result(column = "password", property = "password"),
        @Result(column = "salt", property = "salt"),
        @Result(column = "nickname", property = "nickname"),
        @Result(column = "email", property = "email"),
        @Result(column = "mobile", property = "mobile"),
        @Result(column = "regip", property = "regip"),
        @Result(column = "ctime", property = "ctime"),
        @Result(column = "status", property = "status"),
        @Result(column = "avatar", property = "avatar"),
        @Result(column = "role", property = "role")
    })
    User getByLogin(String login);

    @Select("SELECT * FROM user WHERE mobile = #{mobile}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "login", property = "login"),
        @Result(column = "regtype", property = "regtype"),
        @Result(column = "app", property = "app"),
        @Result(column = "password", property = "password"),
        @Result(column = "salt", property = "salt"),
        @Result(column = "nickname", property = "nickname"),
        @Result(column = "email", property = "email"),
        @Result(column = "mobile", property = "mobile"),
        @Result(column = "regip", property = "regip"),
        @Result(column = "ctime", property = "ctime"),
        @Result(column = "status", property = "status"),
        @Result(column = "avatar", property = "avatar"),
        @Result(column = "role", property = "role")
    })
    User getByMobile(String mobile);
}