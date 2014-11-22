/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.dao.time;

import gl.yezi.data.mapper.time.UserBuyMapper;
import gl.yezi.data.mapper.time.UserMapper;
import gl.yezi.data.mapper.time.UserSellMapper;
import gl.yezi.data.model.time.User;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月5日
 */
@Repository
public class UserDao {

    @Resource
    UserMapper userMapper;

    @Resource
    UserBuyMapper userBuyMapper;

    @Resource
    UserSellMapper userSellMapper;

    public int create(User user) {
        return userMapper.create(user);
    }

    public User get(int id) {
        return userMapper.get(id);
    }

    public void update(User user) {
        userMapper.update(user);
    }

    public User get(String username) {
        return userMapper.getByUsername(username);
    }
}
