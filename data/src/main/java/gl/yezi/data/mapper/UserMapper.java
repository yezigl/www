/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.mapper;

import gl.yezi.data.model.time.User;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月4日
 */
public interface UserMapper {

    @Insert("INSERT INTO user (username, password, salt, nickname, email, phone, regip, ctime, status, alipay, avatar) "
            + "VALUES "
            + "(#{username}, #{password}, #{salt}, #{nickname}, #{email}, #{phone}, #{regip}, #{ctime}, #{status}, #{alipay}, #{avatar})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int create(User user);

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({ 
        @Result(column = "id", property = "id"), 
        @Result(column = "username", property = "username"),
        @Result(column = "password", property = "password"), 
        @Result(column = "nickname", property = "nickname"),
        @Result(column = "email", property = "email"), 
        @Result(column = "phone", property = "phone"),
        @Result(column = "regip", property = "regip"),
        @Result(column = "ctime", property = "ctime"),
        @Result(column = "status", property = "status"),
        @Result(column = "alipay", property = "alipay")
    })
    User get(int id);

    @Update("UPDATE user SET"
            + "username = #{username}, password = #{password}, nickname = #{nickname}, "
            + "email = #{email}, phone = #{phone}, regip = #{regip}, "
            + "ctime = #{ctime}, status = #{status}, alipay = #{alipay} "
            + "WHERE id = #{id}")
    void update(User user);

    @Select("SELECT * FROM user WHERE username = #{username}")
    @Results({ 
        @Result(column = "id", property = "id"), 
        @Result(column = "username", property = "username"),
        @Result(column = "password", property = "password"), 
        @Result(column = "nickname", property = "nickname"),
        @Result(column = "email", property = "email"), 
        @Result(column = "phone", property = "phone"),
        @Result(column = "regip", property = "regip"),
        @Result(column = "ctime", property = "ctime"),
        @Result(column = "status", property = "status"),
        @Result(column = "alipay", property = "alipay")
    })
    User getByUsername(String username);
}
