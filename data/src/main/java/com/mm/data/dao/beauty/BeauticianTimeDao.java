package com.mm.data.dao.beauty;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.mm.data.mapper.beauty.BeauticianTimeMapper;
import com.mm.data.model.beauty.BeauticianTime;

@Repository
public class BeauticianTimeDao {

    @Resource
    BeauticianTimeMapper beauticiantimeMapper;

    public int create(BeauticianTime beauticiantime) {
        return beauticiantimeMapper.create(beauticiantime);
    }

    public BeauticianTime get(int id) {
        return beauticiantimeMapper.get(id);
    }

    public void update(BeauticianTime beauticiantime) {
        beauticiantimeMapper.update(beauticiantime);
    }

    public List<BeauticianTime> getTimesByBeautician(int beauticianId) {
        return beauticiantimeMapper.getTimesByBeautician(beauticianId);
    }
}