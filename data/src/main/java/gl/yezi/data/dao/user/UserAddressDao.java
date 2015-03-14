package gl.yezi.data.dao.user;

import gl.yezi.data.mapper.user.UserAddressMapper;
import gl.yezi.data.model.user.UserAddress;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

@Repository
public class UserAddressDao {

    @Resource
    UserAddressMapper useraddressMapper;

    public int create(UserAddress userAddress) {
        return useraddressMapper.create(userAddress);
    }

    public UserAddress get(int id) {
        return useraddressMapper.get(id);
    }

    public void update(UserAddress userAddress) {
        useraddressMapper.update(userAddress);
    }

    public List<UserAddress> getList() {
        return useraddressMapper.getList();
    }
}