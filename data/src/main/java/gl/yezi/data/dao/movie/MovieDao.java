/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.dao.movie;

import gl.yezi.data.mapper.movie.MovieMapper;
import gl.yezi.data.model.movie.Movie;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * description here
 *
 * @author yezi
 * @since 2014年8月21日
 */
@Repository
public class MovieDao {

    @Resource
    MovieMapper movieMapper;
    
    @Transactional
    public int create(Movie movie) {
        return movieMapper.create(movie);
    }
    
    @Cacheable(value = "movie", key = "#id")
    public Movie get(int id) {
        return movieMapper.get(id);
    }
    
    public void update(Movie movie) {
        movieMapper.update(movie);
    }
    
    public Movie getByDouban(int douban) {
        return movieMapper.getByDouban(douban);
    }
}
