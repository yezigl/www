package com.mm.data.dao.time;

import java.util.List;

import jakarta.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.mm.data.mapper.time.UserSellMapper;
import com.mm.data.model.time.UserSell;

@Repository
public class UserSellDao {

    @Resource
    UserSellMapper usersellMapper;

    public int create(UserSell usersell) {
        return usersellMapper.create(usersell);
    }

    public UserSell get(int id) {
        return usersellMapper.get(id);
    }

    public void update(UserSell usersell) {
        usersellMapper.update(usersell);
    }

    /**
     * @param offset
     * @param limit
     * @return
     */
    public List<UserSell> getLastest(int offset, int limit) {
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
    public List<UserSell> getUserSellsByStatus(int id, int[] status, int offset, int limit) {
        // TODO Auto-generated method stub
        return null;
    }
}