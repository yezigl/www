package com.mm.data.dao.time;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.mm.data.mapper.time.TimetableMapper;
import com.mm.data.model.time.Timetable;

@Repository
public class TimetableDao {

    @Resource
    TimetableMapper timetableMapper;

    public int create(Timetable timetable) {
        return timetableMapper.create(timetable);
    }

    public Timetable get(int id) {
        return timetableMapper.get(id);
    }

    public void update(Timetable timetable) {
        timetableMapper.update(timetable);
    }
}