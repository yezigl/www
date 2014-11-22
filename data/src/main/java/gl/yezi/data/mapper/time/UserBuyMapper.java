/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.mapper.time;

import java.util.List;

import gl.yezi.data.model.time.UserBuy;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月4日
 */
public interface UserBuyMapper {

    @Insert("INSERT INTO userbuy (sellid, uid, ctime, status, ip) "
            + "VALUES "
            + "(#{sellid}, #{uid}, #{ctime}, #{status}, #{ip})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int create(UserBuy ub);

    @Select("SELECT * FROM userbuy WHERE id = #{id}")
    @Results({ 
        @Result(column = "id", property = "id"), 
        @Result(column = "sellid", property = "sellid"),
        @Result(column = "uid", property = "uid"), 
        @Result(column = "ctime", property = "ctime"),
        @Result(column = "status", property = "status"), 
        @Result(column = "ip", property = "ip")
    })
    UserBuy get(int id);

    @Update("UPDATE userbuy SET"
            + "sellid = #{sellid}, uid = #{uid}, ctime = #{ctime}, "
            + "status = #{status}, ip = #{ip} "
            + "WHERE id = #{id}")
    void update(UserBuy ub);

    @Select("SELECT * FROM userbuy WHERE uid = #{uid} ORDER BY id DESC")
    @Results({ 
        @Result(column = "id", property = "id"), 
        @Result(column = "sellid", property = "sellid"),
        @Result(column = "uid", property = "uid"),
        @Result(column = "ctime", property = "ctime"),
        @Result(column = "status", property = "status"), 
        @Result(column = "ip", property = "ip")
    })
    List<UserBuy> getUserBuys(int uid, RowBounds rowBounds);

    @Select("SELECT * FROM userbuy WHERE sellid = #{sellid} AND status = 0")
    @Results({ 
        @Result(column = "id", property = "id"),
        @Result(column = "sellid", property = "sellid"),
        @Result(column = "uid", property = "uid"), 
        @Result(column = "ctime", property = "ctime"),
        @Result(column = "status", property = "status"), 
        @Result(column = "ip", property = "ip")
    })
    UserBuy getBySell(@Param("sellid") int sellid);
    
    @Select({"<script>",
        "SELECT * FROM userbuy WHERE uid = #{uid}",
        "<if test='status != null'>",
        "AND status IN ",
            "<foreach item='item' collection='status' open='(' separator=',' close=')'>",
            "#{item}",
            "</foreach>",
        "</if>",
        "</script>"})
    @Results({ 
        @Result(column = "id", property = "id"),
        @Result(column = "sellid", property = "sellid"),
        @Result(column = "uid", property = "uid"), 
        @Result(column = "ctime", property = "ctime"),
        @Result(column = "status", property = "status"), 
        @Result(column = "ip", property = "ip")
    })
    List<UserBuy> getUserBuysByStatus(@Param("uid") int uid, @Param("status") int[] status, RowBounds rowBounds);
}
