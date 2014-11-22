/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.mapper.movie;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import gl.yezi.data.model.movie.Movie;
import gl.yezi.data.orm.IntArrayTypeHandler;

/**
 * description here
 *
 * @author yezi
 * @since 2014年8月21日
 */
public interface MovieMapper {

    @Insert("INSERT INTO movie "
            + "(title, origin_title, alias, images, "
            + "directors, "
            + "writors, "
            + "casts, "
            + "types, regions, language, pubdate, mainland_pubdate, year, duration, summary, tags, douban, imdb) "
            + "VALUES"
            + "(#{title}, #{originTitle}, #{alias}, #{images}, "
            + "#{directors, typeHandler=gl.yezi.data.orm.IntArrayTypeHandler}, "
            + "#{writors, typeHandler=gl.yezi.data.orm.IntArrayTypeHandler}, "
            + "#{casts, typeHandler=gl.yezi.data.orm.IntArrayTypeHandler}, "
            + "#{types}, #{regions}, #{language}, #{pubdate}, #{mainlandPubdate}, #{year}, #{duration}, #{summary}, #{tags}, #{douban}, #{imdb})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int create(Movie movie);
    
    @Update("UPDATE movie SET"
            + "title = #{title}, origin_title = #{originTitle}, alias = #{alias}, images = #{images}, "
            + "directors = #{directors, typeHandler=gl.yezi.data.orm.IntArrayTypeHandler}, "
            + "writors = #{writors, typeHandler=gl.yezi.data.orm.IntArrayTypeHandler}, "
            + "casts = #{casts, typeHandler=gl.yezi.data.orm.IntArrayTypeHandler}, "
            + "types = #{types}, regions = #{regions},"
            + "language = #{language}, pubdate = #{pubdate}, mainland_pubdate = #{mainlandPubdate}, year = #{year}, duration = #{duration}, summary = #{summary}, tags = #{tags}, douban = #{douban}, imdb = #{imdb}"
            + "WHERE id = #{id}")
    void update(Movie movie);
    
    @Select("SELECT * FROM movie WHERE id = #{id}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "origin_title", property = "originTitle"),
        @Result(column = "alias", property = "alias"),
        @Result(column = "images", property = "images"),
        @Result(column = "directors", property = "directors", typeHandler = IntArrayTypeHandler.class),
        @Result(column = "writors", property = "writors", typeHandler = IntArrayTypeHandler.class),
        @Result(column = "casts", property = "casts", typeHandler = IntArrayTypeHandler.class),
        @Result(column = "types", property = "types"),
        @Result(column = "regions", property = "regions"),
        @Result(column = "language", property = "language"),
        @Result(column = "pubdate", property = "pubdate"),
        @Result(column = "mainland_pubdate", property = "mainlandPubdate"),
        @Result(column = "year", property = "year"),
        @Result(column = "duration", property = "duration"),
        @Result(column = "summary", property = "summary"),
        @Result(column = "tags", property = "tags"),
        @Result(column = "douban", property = "douban"),
        @Result(column = "imdb", property = "imdb")
    })
    Movie get(int id);
    
    @Select("SELECT * FROM movie WHERE douban = #{douban}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "origin_title", property = "originTitle"),
        @Result(column = "alias", property = "alias"),
        @Result(column = "images", property = "images"),
        @Result(column = "directors", property = "directors", typeHandler = IntArrayTypeHandler.class),
        @Result(column = "writors", property = "writors", typeHandler = IntArrayTypeHandler.class),
        @Result(column = "casts", property = "casts", typeHandler = IntArrayTypeHandler.class),
        @Result(column = "types", property = "types"),
        @Result(column = "regions", property = "regions"),
        @Result(column = "language", property = "language"),
        @Result(column = "pubdate", property = "pubdate"),
        @Result(column = "mainland_pubdate", property = "mainlandPubdate"),
        @Result(column = "year", property = "year"),
        @Result(column = "duration", property = "duration"),
        @Result(column = "summary", property = "summary"),
        @Result(column = "tags", property = "tags"),
        @Result(column = "douban", property = "douban"),
        @Result(column = "imdb", property = "imdb")
    })
    Movie getByDouban(int douban);
}
