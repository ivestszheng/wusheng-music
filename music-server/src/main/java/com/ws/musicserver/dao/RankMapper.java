package com.ws.musicserver.dao;

import com.ws.musicserver.domain.Rank;
import org.springframework.stereotype.Repository;

/**
 * @author 无声 <ivestszheng@qq.com>
 * @version 1.0
 * @descripttion 评价Dao
 * @date 2020/12/16 10:14
 */
@Repository
public interface RankMapper {
    /**
     *增加
     */
    public int insert(Rank rank);

    /**
     * 查总分
     */
    public int selectScoreSum(Integer songListId);

    /**
     * 查总评分人数
     */
    public int selectRankNum(Integer songListId);
}
