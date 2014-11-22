/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.mapper.movie;

import gl.yezi.data.model.movie.MovieTag;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * description here
 *
 * @author yezi
 * @since 2014年8月21日
 */
public interface MovieTagMapper {

    @Insert("INSERT INTO movie_tag (movid, tagid, count) VALUES (#{movid}, #{tagid}, 0)")
    void create(MovieTag mt);
    
    @Update("UPDATE movie_tag SET count = #{count} WHERE movid = #{movid} AND tagid = #{tagid}")
    void update(MovieTag mt);
    
    @Select("SELECT * FROM movie_tag WHERE movid = #{movid}")
    @Results({
        @Result(column = "movid", property = "movid"),
        @Result(column = "tagid", property = "tagid"),
        @Result(column = "count", property = "count")
    })
    List<Integer> getTags(int movid);
    
    @Select("SELECT * FROM movie_tag WHERE tagid = #{tagid}")
    @Results({
        @Result(column = "movid", property = "movid"),
        @Result(column = "tagid", property = "tagid"),
        @Result(column = "count", property = "count")
    })
    List<Integer> getMovies(int tagid);
}
