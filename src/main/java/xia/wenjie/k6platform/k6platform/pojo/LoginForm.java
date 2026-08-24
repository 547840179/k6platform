package xia.wenjie.k6platform.k6platform.pojo;

import lombok.Data;

/**
 * @project: k6platform
 * @description: 用户登录表单信息
 */
@Data
public class LoginForm {

    private String username;
    private String password;
    private String verifiCode;
    private Integer userType;

}
