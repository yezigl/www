package gl.yezi.data.mapper.beauty;

import gl.yezi.data.model.beauty.Order;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

public interface OrderMapper {

    @Insert("INSERT INTO `order` (userid, dealid, beauticianid, ctime, utime, paytime, paytype, amount, discount, status, ip, addressid, couponid) VALUES (#{userId}, #{dealId}, #{beauticianId}, #{ctime}, #{utime}, #{paytime}, #{paytype}, #{amount}, #{discount}, #{status}, #{ip}, #{addressId}, #{couponId})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int create(Order order);

    @Select("SELECT * FROM `order` WHERE id = #{id}")
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
        @Result(column = "ip", property = "ip"),
        @Result(column = "addressid", property = "addressId"),
        @Result(column = "couponid", property = "couponId")
    })
    Order get(int id);

    @Update("UPDATE `order` SET userid = #{userId}, dealid = #{dealId}, beauticianid = #{beauticianId}, ctime = #{ctime}, utime = #{utime}, paytime = #{paytime}, paytype = #{paytype}, amount = #{amount}, discount = #{discount}, status = #{status}, ip = #{ip}, addressid = #{addressId}, couponid = #{couponId} WHERE id = #{id}")
    int update(Order order);
    
    @Select({"<script>", "SELECT * FROM `order`", 
        "<if test='status != 0'> WHERE status = #{status}</if>", "ORDER BY id DESC", "</script>"})
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
        @Result(column = "ip", property = "ip"),
        @Result(column = "addressid", property = "addressId"),
        @Result(column = "couponid", property = "couponId")
    })
    List<Order> getList(@Param("status") int status, RowBounds rowBounds);
}