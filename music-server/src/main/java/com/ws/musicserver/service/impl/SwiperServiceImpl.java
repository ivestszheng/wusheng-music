package com.ws.musicserver.service.impl;

import com.ws.musicserver.dao.SwiperMapper;
import com.ws.musicserver.domain.Swiper;
import com.ws.musicserver.service.SwiperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 无声 <ivestszheng@qq.com>
 * @version 1.0
 * @descripttion
 * @date 2020/12/7 21:14
 */
@Service
public class SwiperServiceImpl implements SwiperService {

    @Autowired
    private SwiperMapper swiperMapper;

//  增加
    @Override
    public boolean insert(Swiper swiper) {
        return swiperMapper.insert(swiper)>0;
    }

//  修改
    @Override
    public boolean update(Swiper swiper) {
        return swiperMapper.update(swiper)>0;
    }

//  删除
    @Override
    public boolean delete(Integer id) {
        return swiperMapper.delete(id)>0;
    }

//  根据主键查询整个对象
    @Override
    public Swiper selectByPrimaryKey(Integer id) {
        return swiperMapper.selectByPrimaryKey(id);
    }

//  查询所有轮播图
    @Override
    public List<Swiper> allSwiper() {
        return swiperMapper.allSwiper();
    }
}
