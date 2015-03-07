package gl.yezi.data.mapper.beauty;

import gl.yezi.data.model.beauty.Order;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface OrderMapper {

    @Insert("INSERT INTO order (userid, dealid, beauticianid, ctime, utime, paytime, paytype, amount, discount, status, ip) VALUES (#{userId}, #{dealId}, #{beauticianId}, #{ctime}, #{utime}, #{paytime}, #{paytype}, #{amount}, #{discount}, #{status}, #{ip})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int create(Order order);

    @Select("SELECT * FROM order WHERE id = #{id}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "userid", property = "userId"),
        @Result(column = "dealid", property = "dealId"),
        @Result(column = "beauticianid", property = "beauticianId"),
        @Result(column = "ctime", property = "ctime"),
        @Result(column = "utime", property = "utime"),
        @Result(column = "paytime", property = "paytime"),
        @Result(column = "paytype", property = "paytype"),
        @Result(column = "amount", property = "amount"),
        @Result(column = "discount", property = "discount"),
        @Result(column = "status", property = "status"),
        @Result(column = "ip", property = "ip")
    })
    Order get(int id);

    @Update("UPDATE order SET userid = #{userId}, dealid = #{dealId}, beauticianid = #{beauticianId}, ctime = #{ctime}, utime = #{utime}, paytime = #{paytime}, paytype = #{paytype}, amount = #{amount}, discount = #{discount}, status = #{status}, ip = #{ip} WHERE id = #{id}")
    int update(Order order);
}