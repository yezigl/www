/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.dao.time;

import gl.yezi.data.mapper.time.UserBuyMapper;
import gl.yezi.data.model.time.UserBuy;

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
public class UserBuyDao {

    @Resource
    UserBuyMapper userBuyMapper;
    
    public int create(UserBuy userBuy) {
        return userBuyMapper.create(userBuy);
    }
    
    public UserBuy get(int id) {
        return userBuyMapper.get(id);
    }
    
    public void update(UserBuy userBuy) {
        userBuyMapper.update(userBuy);
    }
    
    public List<UserBuy> getUserBuys(int uid, int offset, int limit) {
        return userBuyMapper.getUserBuys(uid, new RowBounds(offset, limit));
    }

    public UserBuy getBySell(int sellid) {
        return userBuyMapper.getBySell(sellid);
    }
    
    public List<UserBuy> getUserBuysByStatus(int uid, int[] status, int offset, int limit) {
        return userBuyMapper.getUserBuysByStatus(uid, status, new RowBounds(offset, limit));
    }
}
