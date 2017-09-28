package facade.vo;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String userCode;
    private String userName;
    private String telephoneNumber;
    private Integer status;
}
