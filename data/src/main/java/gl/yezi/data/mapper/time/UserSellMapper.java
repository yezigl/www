package gl.yezi.data.mapper.time;

import gl.yezi.data.model.time.UserSell;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserSellMapper {

    @Insert("INSERT INTO usersell (uid, ttid, ctime, utime, ip, price, status, remark) VALUES (#{uid}, #{ttid}, #{ctime}, #{utime}, #{ip}, #{price}, #{status}, #{remark})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int create(UserSell usersell);

    @Select("SELECT * FROM usersell WHERE id = #{id}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "uid", property = "uid"),
        @Result(column = "ttid", property = "ttid"),
        @Result(column = "ctime", property = "ctime"),
        @Result(column = "utime", property = "utime"),
        @Result(column = "ip", property = "ip"),
        @Result(column = "price", property = "price"),
        @Result(column = "status", property = "status"),
        @Result(column = "remark", property = "remark")
    })
    UserSell get(int id);

    @Update("UPDATE usersell SET uid = #{uid}, ttid = #{ttid}, ctime = #{ctime}, utime = #{utime}, ip = #{ip}, price = #{price}, status = #{status}, remark = #{remark} WHERE id = #{id}")
    int update(UserSell usersell);
}