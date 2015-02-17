package gl.yezi.data.mapper.home;

import gl.yezi.data.model.home.Order;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface OrderMapper {

    @Insert("INSERT INTO order (userid, dealid, employeeid, ctime, utime, paytime, status, ip, hometime) VALUES (#{userId}, #{dealId}, #{employeeId}, #{ctime}, #{utime}, #{paytime}, #{status}, #{ip}, #{homeTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int create(Order order);

    @Select("SELECT * FROM order WHERE id = #{id}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "userid", property = "userId"),
        @Result(column = "dealid", property = "dealId"),
        @Result(column = "employeeid", property = "employeeId"),
        @Result(column = "ctime", property = "ctime"),
        @Result(column = "utime", property = "utime"),
        @Result(column = "paytime", property = "paytime"),
        @Result(column = "status", property = "status"),
        @Result(column = "ip", property = "ip"),
        @Result(column = "hometime", property = "homeTime")
    })
    Order get(int id);

    @Update("UPDATE order SET userid = #{userId}, dealid = #{dealId}, employeeid = #{employeeId}, ctime = #{ctime}, utime = #{utime}, paytime = #{paytime}, status = #{status}, ip = #{ip}, hometime = #{homeTime} WHERE id = #{id}")
    int update(Order order);
}