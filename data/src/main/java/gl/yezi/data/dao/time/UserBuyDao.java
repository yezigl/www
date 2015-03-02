package gl.yezi.data.dao.time;

import java.util.List;

import gl.yezi.data.mapper.time.UserBuyMapper;
import gl.yezi.data.model.time.UserBuy;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

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