package service.impl;

import facade.inf.IUserService;
import facade.persistence.UserMapper;
import facade.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserSerivceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> queryUsers(String userName) throws Exception {
        if(StringUtils.isEmpty(userName)){
            return null;
        }
        return userMapper.queryUsersByName(userName);
    }

    public int addUser(User user) throws Exception {
        return userMapper.addUser(user);
    }
}
