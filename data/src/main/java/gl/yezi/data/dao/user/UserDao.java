package gl.yezi.data.dao.user;

import gl.yezi.data.mapper.user.UserMapper;
import gl.yezi.data.model.user.User;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

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

    public User get(String login) {
        return userMapper.getByLogin(login);
    }
}