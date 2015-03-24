package com.mm.data.mapper.user;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mm.data.model.user.UserAddress;

public interface UserAddressMapper {

    @Insert("INSERT INTO `useraddress` (userid, province, city, district, location, detail, langitude, latitude, type) VALUES (#{userId}, #{province}, #{city}, #{district}, #{location}, #{detail}, #{langitude}, #{latitude}, #{type})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int create(UserAddress useraddress);

    @Select("SELECT * FROM `useraddress` WHERE id = #{id}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "userid", property = "userId"),
        @Result(column = "province", property = "province"),
        @Result(column = "city", property = "city"),
        @Result(column = "district", property = "district"),
        @Result(column = "location", property = "location"),
        @Result(column = "detail", property = "detail"),
        @Result(column = "langitude", property = "langitude"),
        @Result(column = "latitude", property = "latitude"),
        @Result(column = "type", property = "type")
    })
    UserAddress get(int id);

    @Update("UPDATE `useraddress` SET userid = #{userId}, province = #{province}, city = #{city}, district = #{district}, location = #{location}, detail = #{detail}, langitude = #{langitude}, latitude = #{latitude}, type = #{type} WHERE id = #{id}")
    int update(UserAddress useraddress);

    @Select("SELECT * FROM `useraddress` WHERE userid = #{userId}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "userid", property = "userId"),
        @Result(column = "province", property = "province"),
        @Result(column = "city", property = "city"),
        @Result(column = "district", property = "district"),
        @Result(column = "location", property = "location"),
        @Result(column = "detail", property = "detail"),
        @Result(column = "langitude", property = "langitude"),
        @Result(column = "latitude", property = "latitude"),
        @Result(column = "type", property = "type")
    })
    List<UserAddress> getList(int userId);
}