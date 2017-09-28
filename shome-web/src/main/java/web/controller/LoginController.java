package web.controller;

import facade.inf.IUserService;
import facade.vo.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("login")
public class LoginController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "获取用户信息", notes = "用来获取全部用户信息")
    @RequestMapping(value = "queryUsers", method = RequestMethod.GET)
    public List<User> queryUsers(@RequestParam("userName") String userName) throws Exception {
        LOG.info("【请求用户名.{}】", userName);
        return userService.queryUsers(userName);
    }

    @ApiOperation(value = "新增用户", notes = "添加用户信息")
    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    public User addUser(HttpServletRequest request, @RequestBody User user) throws Exception {
        LOG.info("【请求用户信息.{}】", user.toString());
        userService.addUser(user);
        return user;
    }

}