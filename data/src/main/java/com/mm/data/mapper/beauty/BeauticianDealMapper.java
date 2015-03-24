package com.mm.data.mapper.beauty;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mm.data.model.beauty.BeauticianDeal;

public interface BeauticianDealMapper {

    @Insert("INSERT INTO beauticiandeal (beauticianid, dealid, avgsorce, subscore, status, ctime, utime) VALUES (#{beauticianId}, #{dealId}, #{avgSorce}, #{subScore}, #{status}, #{ctime}, #{utime})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int create(BeauticianDeal beauticiandeal);

    @Select("SELECT * FROM beauticiandeal WHERE id = #{id}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "beauticianid", property = "beauticianId"),
        @Result(column = "dealid", property = "dealId"),
        @Result(column = "avgsorce", property = "avgSorce"),
        @Result(column = "subscore", property = "subScore"),
        @Result(column = "status", property = "status"),
        @Result(column = "ctime", property = "ctime"),
        @Result(column = "utime", property = "utime")
    })
    BeauticianDeal get(int id);

    @Update("UPDATE beauticiandeal SET beauticianid = #{beauticianId}, dealid = #{dealId}, avgsorce = #{avgSorce}, subscore = #{subScore}, status = #{status}, ctime = #{ctime}, utime = #{utime} WHERE id = #{id}")
    int update(BeauticianDeal beauticiandeal);
}