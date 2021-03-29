package com.ws.musicserver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 无声 <ivestszheng@qq.com>
 * @version 1.0
 * @descripttion 评论
 * @date 2020/12/18 13:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    /*主键*/
    private Integer id;
    /*用户id*/
    private Integer userId;
    /*评论类型（0歌曲1歌单）*/
    private Byte type;
    /*歌曲id*/
    private Integer songId;
    /*歌单id*/
    private Integer songListId;
    /*评论内容*/
    private String content;
    /*评论时间*/
    private Date createTime;
    /*评论点赞数*/
    private Integer up;
}
