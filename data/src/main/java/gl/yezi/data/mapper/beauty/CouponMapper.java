package gl.yezi.data.mapper.beauty;

import gl.yezi.data.model.beauty.Coupon;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CouponMapper {

    @Insert("INSERT INTO coupon (type, description, price, value) VALUES (#{type}, #{description}, #{price}, #{value})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int create(Coupon coupon);

    @Select("SELECT * FROM coupon WHERE id = #{id}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "type", property = "type"),
        @Result(column = "description", property = "description"),
        @Result(column = "price", property = "price"),
        @Result(column = "value", property = "value")
    })
    Coupon get(int id);

    @Update("UPDATE coupon SET type = #{type}, description = #{description}, price = #{price}, value = #{value} WHERE id = #{id}")
    int update(Coupon coupon);
}