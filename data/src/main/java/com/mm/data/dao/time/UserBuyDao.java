package com.mm.data.dao.time;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.mm.data.mapper.time.UserBuyMapper;
import com.mm.data.model.time.UserBuy;

@Repository
public class UserBuyDao {

    @Resource
    UserBuyMapper userbuyMapper;

    public int create(UserBuy userbuy) {
        return userbuyMapper.create(userbuy);
    }

    public UserBuy get(int id) {
        return userbuyMapper.get(id);
    }

    public void update(UserBuy userbuy) {
        userbuyMapper.update(userbuy);
    }

    /**
     * @param id
     * @return
     */
    public UserBuy getBySell(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param id
     * @param status
     * @param offset
     * @param limit
     * @return
     */
    public List<UserBuy> getUserBuysByStatus(int id, int[] status, int offset, int limit) {
        // TODO Auto-generated method stub
        return null;
    }
}