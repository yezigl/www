package com.mm.data.dao.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.mm.data.mapper.user.UserAddressMapper;
import com.mm.data.model.user.UserAddress;

@Repository
public class UserAddressDao {

    @Resource
    UserAddressMapper useraddressMapper;

    public int create(UserAddress useraddress) {
        return useraddressMapper.create(useraddress);
    }

    public UserAddress get(int id) {
        return useraddressMapper.get(id);
    }

    public void update(UserAddress useraddress) {
        useraddressMapper.update(useraddress);
    }

    /**
     * @return
     */
    public List<UserAddress> getList(int userId) {
        return useraddressMapper.getList(userId);
    }
}