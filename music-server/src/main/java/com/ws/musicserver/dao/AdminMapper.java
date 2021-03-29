package com.ws.musicserver.dao;

import org.springframework.stereotype.Repository;

/**
 * @author 无声 <ivestszheng@qq.com>
 * @version 1.0
 * @Descripttion 管理员Dao
 * @date 2020/12/4 15:50
 */
@Repository
//    @Repository用在持久层的接口上，这个注解是将接口的一个实现类交给spring管理。
public interface AdminMapper {
        //    验证密码是否正确
    public int verifyPassword(String username, String password);
}
