package gl.yezi.data.mapper.beauty;

import gl.yezi.data.model.beauty.EmployeeDeal;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface EmployeeDealMapper {

    @Insert("INSERT INTO employeedeal (employeeid, dealid, avgsorce, subscore, status, ctime, utime) VALUES (#{employeeId}, #{dealId}, #{avgSorce}, #{subScore}, #{status}, #{ctime}, #{utime})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int create(EmployeeDeal employeedeal);

    @Select("SELECT * FROM employeedeal WHERE id = #{id}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "employeeid", property = "employeeId"),
        @Result(column = "dealid", property = "dealId"),
        @Result(column = "avgsorce", property = "avgSorce"),
        @Result(column = "subscore", property = "subScore"),
        @Result(column = "status", property = "status"),
        @Result(column = "ctime", property = "ctime"),
        @Result(column = "utime", property = "utime")
    })
    EmployeeDeal get(int id);

    @Update("UPDATE employeedeal SET employeeid = #{employeeId}, dealid = #{dealId}, avgsorce = #{avgSorce}, subscore = #{subScore}, status = #{status}, ctime = #{ctime}, utime = #{utime} WHERE id = #{id}")
    int update(EmployeeDeal employeedeal);
}