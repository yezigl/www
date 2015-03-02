package gl.yezi.data.dao.time;

import gl.yezi.data.mapper.time.TimetableMapper;
import gl.yezi.data.model.time.Timetable;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

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