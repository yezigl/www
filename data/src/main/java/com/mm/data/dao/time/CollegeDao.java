package com.mm.data.dao.time;

import jakarta.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.mm.data.mapper.time.CollegeMapper;
import com.mm.data.model.time.College;

@Repository
public class CollegeDao {

    @Resource
    CollegeMapper collegeMapper;

    public int create(College college) {
        return collegeMapper.create(college);
    }

    public College get(int id) {
        return collegeMapper.get(id);
    }

    public void update(College college) {
        collegeMapper.update(college);
    }
}