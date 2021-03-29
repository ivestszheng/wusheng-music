package com.ws.musicserver.service;

/**
 * @author 无声 <ivestszheng@qq.com>
 * @version 1.0
 * @descripttion  管理员Service接口
 * @date 2020/12/4 16:02
 */
public interface AdminService {
    //    验证密码是否正确
    public boolean verifyPassword(String username, String password);
}
