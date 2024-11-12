package com.mm.data.dao.beauty;

import java.util.List;

import jakarta.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.mm.data.mapper.beauty.BeauticianDealMapper;
import com.mm.data.model.beauty.BeauticianDeal;

@Repository
public class BeauticianDealDao {

    @Resource
    BeauticianDealMapper beauticiandealMapper;

    public int create(BeauticianDeal beauticiandeal) {
        return beauticiandealMapper.create(beauticiandeal);
    }

    public BeauticianDeal get(int id) {
        return beauticiandealMapper.get(id);
    }

    public void update(BeauticianDeal beauticiandeal) {
        beauticiandealMapper.update(beauticiandeal);
    }

    public List<Integer> getDealIdsByBeautician(int beauticianId) {
        return beauticiandealMapper.getListByBeautician(beauticianId);
    }
}