package gl.yezi.data.mapper.user;

import java.util.List;

import gl.yezi.data.model.user.UserAddress;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserAddressMapper {

    @Insert("INSERT INTO useraddress (userid, province, city, district, detail) VALUES (#{userId}, #{province}, #{city}, #{district}, #{detail})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int create(UserAddress useraddress);

    @Select("SELECT * FROM useraddress WHERE id = #{id}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "userid", property = "userId"),
        @Result(column = "province", property = "province"),
        @Result(column = "city", property = "city"),
        @Result(column = "district", property = "district"),
        @Result(column = "detail", property = "detail")
    })
    UserAddress get(int id);

    @Update("UPDATE useraddress SET userid = #{userId}, province = #{province}, city = #{city}, district = #{district}, detail = #{detail} WHERE id = #{id}")
    int update(UserAddress useraddress);
    
    @Select("SELECT * FROM useraddress")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "userid", property = "userId"),
        @Result(column = "province", property = "province"),
        @Result(column = "city", property = "city"),
        @Result(column = "district", property = "district"),
        @Result(column = "detail", property = "detail")
    })
    List<UserAddress> getList();
}