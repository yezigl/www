/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.dao.time;

import gl.yezi.data.mapper.time.UserSellMapper;
import gl.yezi.data.model.time.UserSell;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月5日
 */
@Repository
public class UserSellDao {

    @Resource
    UserSellMapper userSellMapper;

    public int create(UserSell userSell) {
        return userSellMapper.create(userSell);
    }

    public UserSell get(int id) {
        return userSellMapper.get(id);
    }

    public void update(UserSell userSell) {
        userSellMapper.update(userSell);
    }

    public List<UserSell> getUserSells(int uid, int offset, int limit) {
        return userSellMapper.getUserSells(uid, new RowBounds(offset, limit));
    }

    public List<UserSell> getLastest(int offset, int limit) {
        return userSellMapper.getLastest(new RowBounds(offset, limit));
    }

    public List<UserSell> getUserSellsByStatus(int uid, int[] status, int offset, int limit) {
        return userSellMapper.getUserSellsByStatus(uid, status, new RowBounds(offset, limit));
    }
}
