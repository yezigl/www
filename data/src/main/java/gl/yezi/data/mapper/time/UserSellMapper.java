/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.mapper.time;

import java.util.List;

import gl.yezi.data.model.time.UserSell;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
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
public interface UserSellMapper {

    @Insert("INSERT INTO usersell (uid, ttid, ctime, utime, ip, price, status, remark) "
            + "VALUES "
            + "(#{uid}, #{ttid}, #{ctime}, #{utime}, #{ip}, #{price}, #{status}, #{remark})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int create(UserSell us);

    @Select("SELECT * FROM usersell WHERE id = #{id}")
    @Results({ 
        @Result(column = "id", property = "id"), 
        @Result(column = "uid", property = "uid"),
        @Result(column = "ttid", property = "ttid"), 
        @Result(column = "ctime", property = "ctime"),
        @Result(column = "utime", property = "utime"), 
        @Result(column = "ip", property = "ip"),
        @Result(column = "price", property = "price"),
        @Result(column = "status", property = "status"),
        @Result(column = "remark", property = "remark")
    })
    UserSell get(int id);

    @Update("UPDATE usersell SET"
            + "uid = #{uid}, ttid = #{ttid}, ctime = #{ctime}, "
            + "utime = #{utime}, ip = #{ip}, price = #{price}, "
            + "status = #{status}, remark = #{remark} "
            + "WHERE id = #{id}")
    void update(UserSell us);

    @Select("SELECT * FROM usersell WHERE uid = #{uid} ORDER BY id DESC")
    @Results({ 
        @Result(column = "id", property = "id"), 
        @Result(column = "uid", property = "uid"),
        @Result(column = "ttid", property = "ttid"), 
        @Result(column = "ctime", property = "ctime"),
        @Result(column = "utime", property = "utime"), 
        @Result(column = "ip", property = "ip"),
        @Result(column = "price", property = "price"),
        @Result(column = "status", property = "status"),
        @Result(column = "remark", property = "remark")
    })
    List<UserSell> getUserSells(int uid, RowBounds rowBounds);

    @Select("SELECT * FROM usersell WHERE status in (0, 5) ORDER BY id DESC")
    @Results({ 
        @Result(column = "id", property = "id"), 
        @Result(column = "uid", property = "uid"),
        @Result(column = "ttid", property = "ttid"), 
        @Result(column = "ctime", property = "ctime"),
        @Result(column = "utime", property = "utime"), 
        @Result(column = "ip", property = "ip"),
        @Result(column = "price", property = "price"),
        @Result(column = "status", property = "status"),
        @Result(column = "remark", property = "remark")
    })
    List<UserSell> getLastest(RowBounds rowBounds);
    
    //TODO
    List<UserSell> getUserSellsByStatus(int uid, int[] status, RowBounds rowBounds);
}
