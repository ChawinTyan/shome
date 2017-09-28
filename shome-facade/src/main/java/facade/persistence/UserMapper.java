package facade.persistence;

import facade.vo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Options(
            useGeneratedKeys = true,
            keyColumn = "id",
            keyProperty = "id"
    )
    @Insert("insert into t_user(user_code,user_name,telephone_number,status) values (#{userCode},#{userName},#{telephoneNumber},#{status})")
    public int addUser(User user);

    @Results({
            @Result(column = "user_code", property = "userCode"),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "telephone_number", property = "telephoneNumber")
    })
    @Select("select * from t_user")
    public List<User> queryUsers();

    @Results({
            @Result(column = "user_code", property = "userCode"),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "telephone_number", property = "telephoneNumber")
    })
    @Select("select * from t_user where user_name like CONCAT('%',#{userName},'%')")
    public List<User> queryUsersByName(String userName);

}
