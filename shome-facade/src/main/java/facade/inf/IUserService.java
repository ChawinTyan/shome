package facade.inf;

import facade.vo.User;

import java.util.List;

public interface IUserService {

    public List<User> queryUsers(String userName) throws Exception;

    public int addUser(User user) throws Exception;

}
