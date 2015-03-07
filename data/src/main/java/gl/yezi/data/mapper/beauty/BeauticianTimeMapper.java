package gl.yezi.data.mapper.beauty;

import gl.yezi.data.model.beauty.BeauticianTime;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BeauticianTimeMapper {

    @Insert("INSERT INTO beauticiantime (beauticianid, orderid, starttime, endtime, status) VALUES (#{beauticianId}, #{orderId}, #{startTime}, #{endTime}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int create(BeauticianTime beauticiantime);

    @Select("SELECT * FROM beauticiantime WHERE id = #{id}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "beauticianid", property = "beauticianId"),
        @Result(column = "orderid", property = "orderId"),
        @Result(column = "starttime", property = "startTime"),
        @Result(column = "endtime", property = "endTime"),
        @Result(column = "status", property = "status")
    })
    BeauticianTime get(int id);

    @Update("UPDATE beauticiantime SET beauticianid = #{beauticianId}, orderid = #{orderId}, starttime = #{startTime}, endtime = #{endTime}, status = #{status} WHERE id = #{id}")
    int update(BeauticianTime beauticiantime);
}