package com.ws.musicserver.dao;

import com.ws.musicserver.domain.Swiper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 无声 <ivestszheng@qq.com>
 * @version 1.0
 * @descripttion 轮播图DAO
 * @date 2020/12/7 20:44
 */
@Repository
public interface SwiperMapper {
    /**
     *增加
     */
    public int insert(Swiper swiper);

    /**
     *修改
     */
    public int update(Swiper swiper);

    /**
     * 删除
     */
    public int delete(Integer id);

    /**
     * 根据主键查询整个对象
     */
    public Swiper selectByPrimaryKey(Integer id);

    /**
     * 查询所有轮播图
     * @return
     */
//  @Select("select * from swiper")
    public List<Swiper> allSwiper();

}

