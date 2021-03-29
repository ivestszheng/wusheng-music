package com.ws.musicserver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 无声 <ivestszheng@qq.com>
 * @version 1.0
 * @descripttion 收藏
 * @date 2020/12/15 16:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Collect implements Serializable {
    /*主键*/
    private Integer id;
    /*用户id*/
    private Integer userId;
    /*收藏类型（0歌曲1歌单）*/
    private Byte type;
    /*歌曲id*/
    private Integer songId;
    /*歌单id*/
    private Integer songListId;
    /*收藏时间*/
    private Date createTime;
}
