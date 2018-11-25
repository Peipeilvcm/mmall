package com.mmall.common;/**
 * Created by Administrator on 2018/11/25.
 */

/**
 * @program: mmall
 * @description: 常量类
 * @author: peipeizx
 * @create: 2018-11-25-16-10
 **/
public class Const {
    public static final String CURRENT_USER = "currentUser";
    public static final String EMAIL = "email";
    public static final String USERNAME = "username";

    public interface Role{
        int ROLE_CUSTOM = 0; // 普通用户
        int ROLE_ADMIN = 1; // 管理员
    }

}
