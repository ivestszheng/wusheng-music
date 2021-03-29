package com.ws.musicserver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 无声 <ivestszheng@qq.com>
 * @version 1.0
 * @descripttion 评价
 * @date 2020/12/16 10:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rank {
    /*主键*/
    private Integer id;
    /*歌单id*/
    private Integer songListId;
    /*用户id*/
    private Integer consumerId;
    /*评分*/
    private Integer score;
}
