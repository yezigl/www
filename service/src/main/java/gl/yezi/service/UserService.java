/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.service;

import gl.yezi.data.dao.UserDao;
import gl.yezi.data.model.time.User;
import gl.yezi.data.utils.CryptUtils;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

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

    public int register(User user) {
        user.setCtime(new Date());
        user.setSalt(CryptUtils.salt());
        user.setPassword(DigestUtils.sha1Hex(user.getSalt() + user.getPassword()));
        return userDao.create(user);
    }

    public User get(String username) {
        return userDao.get(username);
    }

    public User get(int id) {
        return userDao.get(id);
    }

}