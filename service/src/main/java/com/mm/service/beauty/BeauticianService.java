/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.service.beauty;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mm.data.dao.beauty.BeauticianDao;
import com.mm.data.dao.beauty.BeauticianDealDao;
import com.mm.data.dao.beauty.BeauticianTimeDao;
import com.mm.data.model.beauty.Beautician;
import com.mm.data.model.beauty.BeauticianTime;
import com.mm.service.BaseService;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月7日
 */
@Service
public class BeauticianService extends BaseService {
    
    @Resource
    BeauticianDao beauticianDao;
    
    @Resource
    BeauticianDealDao beauticianDealDao;
    
    @Resource
    BeauticianTimeDao beauticianTimeDao;

    public Beautician get(int id) {
        if (id <= 0) {
            return null;
        }
        return beauticianDao.get(id);
    }

    public int update(Beautician beautician) {
        Beautician old = get(beautician.getId());
        old.setName(beautician.getName());
        old.setAge(beautician.getAge());
        old.setAvatar(beautician.getAvatar());
        old.setIntroduction(beautician.getIntroduction());
        return beauticianDao.update(beautician);
    }

    public int create(Beautician beautician) {
        return beauticianDao.create(beautician);
    }
    
    public List<Beautician> getList(int offset, int limit) {
        return beauticianDao.getList(offset, limit);
    }
    
    public List<Integer> getDealIds(int beauticianId) {
        return beauticianDealDao.getDealIdsByBeautician(beauticianId);
    }
    
    public List<BeauticianTime> getTimes(int beauticianId) {
        return beauticianTimeDao.getTimesByBeautician(beauticianId);
    }

}
