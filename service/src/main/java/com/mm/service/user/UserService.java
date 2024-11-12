/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package com.mm.service.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import com.mm.data.dao.user.UserAddressDao;
import com.mm.data.dao.user.UserDao;
import com.mm.data.model.user.User;
import com.mm.data.model.user.UserAddress;
import com.mm.data.utils.CryptUtils;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月5日
 */
@Service
public class UserService {

    @Resource
    UserDao userDao;

    @Resource
    UserAddressDao userAddressDao;

    public int register(User user) {
        user.setCtime(new Date());
        user.setSalt(CryptUtils.salt());
        user.setPassword(DigestUtils.sha1Hex(user.getSalt() + user.getPassword()));
        return userDao.create(user);
    }

    public User getByLogin(String login) {
        return userDao.getByLogin(login);
    }
    
    public User getByMobile(String mobile) {
        return userDao.getByMobile(mobile);
    }

    public User get(int id) {
        return userDao.get(id);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public int addAddress(UserAddress userAddress) {
        return userAddressDao.create(userAddress);
    }

    public List<UserAddress> getAddressList(int userId) {
        List<UserAddress> list = userAddressDao.getList(userId);
        return list == null ? new ArrayList<UserAddress>() : list;
    }

    public void updateAddress(UserAddress userAddress) {
        userAddressDao.update(userAddress);
    }

    public UserAddress getAddress(int id) {
        return userAddressDao.get(id);
    }

}
