package com.ws.musicserver.dao;

import com.ws.musicserver.domain.Singer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 无声 <ivestszheng@qq.com>
 * @version 1.0
 * @descripttion 歌手DAO
 * @date 2020/12/4 23:12
 */
@Repository
public interface SingerMapper {
    /**
     *增加
     */
    public int insert(Singer singer);

    /**
     *修改
     */
    public int update(Singer singer);

    /**
     * 删除
     */
    public int delete(Integer id);

    /**
     * 根据主键查询整个对象
     */
    public Singer selectByPrimaryKey(Integer id);

    /**
     * 查询所有歌手
     */
    public List<Singer> allSinger();

    /**
     * 根据歌手名字模糊查询列表
     */
    public List<Singer> singerOfName(String name);

    /**
     * 根据性别查询
     */
    public List<Singer> singerOfSex(Integer sex);
}




