package com.mm.data.mapper.beauty;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mm.data.model.beauty.Flow;

public interface FlowMapper {

    @Insert("INSERT INTO flow (dealid, step, name, description, imgurl, time) VALUES (#{dealId}, #{step}, #{name}, #{description}, #{imgUrl}, #{time})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int create(Flow flow);

    @Select("SELECT * FROM flow WHERE id = #{id}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "dealid", property = "dealId"),
        @Result(column = "step", property = "step"),
        @Result(column = "name", property = "name"),
        @Result(column = "description", property = "description"),
        @Result(column = "imgurl", property = "imgUrl"),
        @Result(column = "time", property = "time")
    })
    Flow get(int id);

    @Update("UPDATE flow SET dealid = #{dealId}, step = #{step}, name = #{name}, description = #{description}, imgurl = #{imgUrl}, time = #{time} WHERE id = #{id}")
    int update(Flow flow);
    
    @Select({ "<script>", "SELECT * FROM flow WHERE id IN",
        "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>#{item}</foreach>",
        "ORDER BY step ASC", "</script>" })
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "dealid", property = "dealId"),
        @Result(column = "step", property = "step"),
        @Result(column = "name", property = "name"),
        @Result(column = "description", property = "description"),
        @Result(column = "imgurl", property = "imgUrl"),
        @Result(column = "time", property = "time")
    })
    List<Flow> getList(@Param("ids") int[] ids);
}