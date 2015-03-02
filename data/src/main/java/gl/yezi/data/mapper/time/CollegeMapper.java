package gl.yezi.data.mapper.time;

import gl.yezi.data.model.time.College;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CollegeMapper {

    @Insert("INSERT INTO college (schid, name) VALUES (#{schid}, #{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int create(College college);

    @Select("SELECT * FROM college WHERE id = #{id}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "schid", property = "schid"),
        @Result(column = "name", property = "name")
    })
    College get(int id);

    @Update("UPDATE college SET schid = #{schid}, name = #{name} WHERE id = #{id}")
    int update(College college);
}