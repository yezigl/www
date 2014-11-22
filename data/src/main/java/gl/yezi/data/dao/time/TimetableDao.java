/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.dao.time;

import java.util.List;

import gl.yezi.data.mapper.time.TimetableMapper;
import gl.yezi.data.model.time.Timetable;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月5日
 */
@Repository
public class TimetableDao {

    @Resource
    TimetableMapper timetableMapper;
    
    public int create(Timetable timetable) {
        return timetableMapper.create(timetable);
    }
    
    @Cacheable(value = { "timetable" }, key = "#id")
    public Timetable getTimetable(int id) {
        return timetableMapper.get(id);
    }
    
    public List<Timetable> getTimetableBySchool(int schid) {
        return timetableMapper.getList(schid, 0, null);
    }
    
    public List<Timetable> getTimetableByCollege(int collid) {
        return timetableMapper.getList(0, collid, null);
    }
    
    public List<Timetable> getTimetableByDate(String date) {
        return timetableMapper.getList(0, 0, date);
    }
    
    public List<Timetable> getTimetable(int schid, int collid, String date) {
        return timetableMapper.getList(schid, collid, date);
    }
}
