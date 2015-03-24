package com.mm.data.mapper.beauty;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mm.data.model.beauty.Product;

public interface ProductMapper {

    @Insert("INSERT INTO product (name, applicable, efficacy) VALUES (#{name}, #{applicable}, #{efficacy})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int create(Product product);

    @Select("SELECT * FROM product WHERE id = #{id}")
    @Results({ 
        @Result(column = "id", property = "id"), 
        @Result(column = "name", property = "name"),
        @Result(column = "applicable", property = "applicable"),
        @Result(column = "efficacy", property = "efficacy")
    })
    Product get(int id);

    @Update("UPDATE product SET name = #{name}, applicable = #{applicable}, efficacy = #{efficacy} WHERE id = #{id}")
    int update(Product product);

    @Select({ "<script>", "SELECT * FROM product WHERE id IN",
            "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>#{item}</foreach>",
            "</script>" })
    @Results({ 
        @Result(column = "id", property = "id"), 
        @Result(column = "name", property = "name"),
        @Result(column = "applicable", property = "applicable"),
        @Result(column = "efficacy", property = "efficacy")
    })
    List<Product> getList(@Param("ids") int[] ids);
}