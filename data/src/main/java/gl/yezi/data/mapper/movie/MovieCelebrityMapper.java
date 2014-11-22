/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.mapper.movie;

import gl.yezi.data.model.movie.MovieCelebrity;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * description here
 *
 * @author yezi
 * @since 2014年8月21日
 */
public interface MovieCelebrityMapper {

    @Insert("INSERT INTO movie_celebrity (movid, celeid, type) "
            + "VALUES (#{movid}, #{celeid}, #{type})")
    void create(MovieCelebrity mc);
    
    @Update("UPDATE movie_celebrity SET"
            + "movid = #{movid}, celeid = #{celeid}, type = #{type}"
            + "WHERE movid = #{movid} AND celeid = #{celeid}")
    void update(MovieCelebrity mc);
    
    @Select("SELECT celeid FROM movie_celebrity WHERE movid = #{movid} AND type = #{type}")
    @ResultType(Integer.class)
    List<Integer> getMovies(@Param("movid") int movid, @Param("type") int type);
    
    @Select("SELECT movid FROM movie_celebrity WHERE celeid = #{celeid} AND type = #{type}")
    @ResultType(Integer.class)
    List<Integer> getCelebrities(@Param("celeid") int celeid, @Param("type") int type);
}
