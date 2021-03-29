package com.ws.musicserver.service;

import com.ws.musicserver.dao.SwiperMapper;
import com.ws.musicserver.domain.Swiper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 无声 <ivestszheng@qq.com>
 * @version 1.0
 * @descripttion 轮播图Service接口
 * @date 2020/12/7 21:09
 */
public interface SwiperService {


    /**
     *增加
     */
    public boolean insert(Swiper swiper);

    /**
     *修改
     */
    public boolean update(Swiper swiper);

    /**
     * 删除
     */
    public boolean delete(Integer id);

    /**
     * 根据主键查询整个对象
     */
    public Swiper selectByPrimaryKey(Integer id);

    /**
     * 查询所有轮播图
     */
    public List<Swiper> allSwiper();
}
