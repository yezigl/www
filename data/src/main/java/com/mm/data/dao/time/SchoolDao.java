package com.mm.data.dao.time;

import jakarta.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.mm.data.mapper.time.SchoolMapper;
import com.mm.data.model.time.School;

@Repository
public class SchoolDao {

    @Resource
    SchoolMapper schoolMapper;

    public int create(School school) {
        return schoolMapper.create(school);
    }

    public School get(int id) {
        return schoolMapper.get(id);
    }

    public void update(School school) {
        schoolMapper.update(school);
    }
}