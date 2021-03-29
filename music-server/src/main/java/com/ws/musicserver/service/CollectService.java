package com.ws.musicserver.service;

import com.ws.musicserver.domain.Collect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 无声 <ivestszheng@qq.com>
 * @version 1.0
 * @descripttion 收藏service接口
 * @date 2020/12/15 18:48
 */
public interface CollectService {
    /**
     *增加
     */
    public boolean insert(Collect collect);

    /**
     * 删除
     */
    public boolean delete(Integer id);

    /**
     * 根据用户id和歌曲id删除
     */
    public boolean deleteByUserIdSongId(Integer userId, Integer songId);

    /**
     * 查询所有收藏
     */
    public List<Collect> allCollect();

    /**
     * 查询某个用户的收藏列表
     */
    public List<Collect> collectOfUserId(Integer userId);

    /**
     * 查询某个用户是否已经收藏了某个歌曲
     */
    public boolean existSongId(@Param("userId") Integer userId, @Param("songId") Integer songId);
}