package gl.yezi.data.mapper.beauty;

import gl.yezi.data.model.beauty.Deal;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface DealMapper {

    @Insert("INSERT INTO deal (title, description, price, value, status, type, imgurl, gallery, ctime, utime, content, costtime, efficacy, component, flow, special) VALUES (#{title}, #{description}, #{price}, #{value}, #{status}, #{type}, #{imgUrl}, #{gallery}, #{ctime}, #{utime}, #{content}, #{costtime}, #{efficacy}, #{component}, #{flow}, #{special})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int create(Deal deal);

    @Select("SELECT * FROM deal WHERE id = #{id}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "title", property = "title"),
        @Result(column = "description", property = "description"),
        @Result(column = "price", property = "price"),
        @Result(column = "value", property = "value"),
        @Result(column = "status", property = "status"),
        @Result(column = "type", property = "type"),
        @Result(column = "imgurl", property = "imgUrl"),
        @Result(column = "gallery", property = "gallery"),
        @Result(column = "ctime", property = "ctime"),
        @Result(column = "utime", property = "utime"),
        @Result(column = "content", property = "content"),
        @Result(column = "costtime", property = "costtime"),
        @Result(column = "efficacy", property = "efficacy"),
        @Result(column = "component", property = "component"),
        @Result(column = "flow", property = "flow"),
        @Result(column = "special", property = "special")
    })
    Deal get(int id);

    @Update("UPDATE deal SET title = #{title}, description = #{description}, price = #{price}, value = #{value}, status = #{status}, type = #{type}, imgurl = #{imgUrl}, gallery = #{gallery}, ctime = #{ctime}, utime = #{utime}, content = #{content}, costtime = #{costtime}, efficacy = #{efficacy}, component = #{component}, flow = #{flow}, special = #{special} WHERE id = #{id}")
    int update(Deal deal);
}