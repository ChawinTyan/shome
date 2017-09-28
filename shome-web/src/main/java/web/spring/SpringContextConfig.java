package web.spring;

import facade.inf.IUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import service.impl.UserSerivceImpl;

@Configuration
@ComponentScan({"web.controller"})
public class SpringContextConfig {

    @Bean(name = "userService")
    public IUserService userService() {
        return new UserSerivceImpl();
    }

}
