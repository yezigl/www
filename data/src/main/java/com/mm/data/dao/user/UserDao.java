package com.mm.data.dao.user;

import jakarta.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.mm.data.mapper.user.UserMapper;
import com.mm.data.model.user.User;

@Repository
public class UserDao {

    @Resource
    UserMapper userMapper;

    public int create(User user) {
        return userMapper.create(user);
    }

    public User get(int id) {
        return userMapper.get(id);
    }

    public void update(User user) {
        userMapper.update(user);
    }

    public User getByLogin(String login) {
        return userMapper.getByLogin(login);
    }

    public User getByMobile(String mobile) {
        return userMapper.getByMobile(mobile);
    }
}