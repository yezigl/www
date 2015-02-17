package gl.yezi.data.mapper.home;

import gl.yezi.data.model.home.Employee;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface EmployeeMapper {

    @Insert("INSERT INTO employee (name, gender, age, birthday, avatar, introduction) VALUES (#{name}, #{gender}, #{age}, #{birthday}, #{avatar}, #{introduction})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int create(Employee employee);

    @Select("SELECT * FROM employee WHERE id = #{id}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "name", property = "name"),
        @Result(column = "gender", property = "gender"),
        @Result(column = "age", property = "age"),
        @Result(column = "birthday", property = "birthday"),
        @Result(column = "avatar", property = "avatar"),
        @Result(column = "introduction", property = "introduction")
    })
    Employee get(int id);

    @Update("UPDATE employee SET name = #{name}, gender = #{gender}, age = #{age}, birthday = #{birthday}, avatar = #{avatar}, introduction = #{introduction} WHERE id = #{id}")
    int update(Employee employee);
}