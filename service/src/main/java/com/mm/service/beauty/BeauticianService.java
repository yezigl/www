/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.service.beauty;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mm.data.dao.beauty.BeauticianDao;
import com.mm.data.model.beauty.Beautician;
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

    public Beautician get(int id) {
        if (id <= 0) {
            return null;
        }
        return beauticianDao.get(id);
    }
    
    public List<Beautician> getList(int offset, int limit) {
        return beauticianDao.getList(offset, limit);
    }
}
