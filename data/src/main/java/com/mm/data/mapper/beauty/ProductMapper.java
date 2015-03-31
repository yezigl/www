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

    @Insert("INSERT INTO product (name, applicable, efficacy, brand, imgurl, status) VALUES (#{name}, #{applicable}, #{efficacy}, #{brand}, #{imgUrl}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int create(Product product);

    @Select("SELECT * FROM product WHERE id = #{id}")
    @Results({ 
        @Result(column = "id", property = "id"), 
        @Result(column = "name", property = "name"),
        @Result(column = "applicable", property = "applicable"),
        @Result(column = "efficacy", property = "efficacy"),
        @Result(column = "brand", property = "brand"),
        @Result(column = "imgurl", property = "imgUrl"),
        @Result(column = "status", property = "status"),
    })
    Product get(int id);

    @Update("UPDATE product SET name = #{name}, applicable = #{applicable}, efficacy = #{efficacy}, brand = #{brand}, imgurl = #{imgUrl}, status = #{status} WHERE id = #{id}")
    int update(Product product);

    @Select({ "<script>", "SELECT * FROM product WHERE id IN",
            "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>#{item}</foreach>",
            "</script>" })
    @Results({ 
        @Result(column = "id", property = "id"), 
        @Result(column = "name", property = "name"),
        @Result(column = "applicable", property = "applicable"),
        @Result(column = "efficacy", property = "efficacy"),
        @Result(column = "brand", property = "brand"),
        @Result(column = "imgurl", property = "imgUrl"),
        @Result(column = "status", property = "status"),
    })
    List<Product> getList(@Param("ids") int[] ids);

    @Select("SELECT * FROM product")
    @Results({ 
        @Result(column = "id", property = "id"), 
        @Result(column = "name", property = "name"),
        @Result(column = "applicable", property = "applicable"),
        @Result(column = "efficacy", property = "efficacy"),
        @Result(column = "brand", property = "brand"),
        @Result(column = "imgurl", property = "imgUrl"),
        @Result(column = "status", property = "status"),
    })
    List<Product> getAll();
}