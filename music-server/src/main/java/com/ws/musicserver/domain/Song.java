package com.ws.musicserver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 无声 <ivestszheng@qq.com>
 * @version 1.0
 * @descripttion 歌曲
 * @date 2020/12/6 10:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song implements Serializable {
    /*主键*/
    private Integer id;
    /*歌手id*/
    private Integer singerId;
    /*歌名*/
    private String name;
    /*简介*/
    private String introduction;
    /*创建时间*/
    private Date createTime;
    /*更新时间*/
    private Date updateTime;
    /*歌曲图片*/
    private String pic;
    /*歌词*/
    private String lyric;
    /*歌曲地址*/
    private String url;
}
