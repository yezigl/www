package gl.yezi.data.mapper.beauty;

import gl.yezi.data.model.beauty.EmployeeTime;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface EmployeeTimeMapper {

    @Insert("INSERT INTO employeetime (employeeid, orderid, starttime, endtime, status) VALUES (#{employeeId}, #{orderId}, #{startTime}, #{endTime}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int create(EmployeeTime employeetime);

    @Select("SELECT * FROM employeetime WHERE id = #{id}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "employeeid", property = "employeeId"),
        @Result(column = "orderid", property = "orderId"),
        @Result(column = "starttime", property = "startTime"),
        @Result(column = "endtime", property = "endTime"),
        @Result(column = "status", property = "status")
    })
    EmployeeTime get(int id);

    @Update("UPDATE employeetime SET employeeid = #{employeeId}, orderid = #{orderId}, starttime = #{startTime}, endtime = #{endTime}, status = #{status} WHERE id = #{id}")
    int update(EmployeeTime employeetime);
}