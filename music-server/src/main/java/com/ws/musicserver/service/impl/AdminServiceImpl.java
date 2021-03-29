package com.ws.musicserver.service.impl;

import com.ws.musicserver.dao.AdminMapper;
import com.ws.musicserver.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 无声 <ivestszheng@qq.com>
 * @version 1.0
 * @Descripttion  管理员Service实现类
 * @date 2020/12/4 16:04
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public boolean verifyPassword(String username, String password) {
        return adminMapper.verifyPassword(username, password) > 0 ;

    }
}
