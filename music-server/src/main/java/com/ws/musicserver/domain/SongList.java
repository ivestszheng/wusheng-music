package com.ws.musicserver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 无声 <ivestszheng@qq.com>
 * @version 1.0
 * @descripttion 歌单
 * @date 2020/12/6 14:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongList implements Serializable {
    /*主键*/
    private Integer id;
    /*歌单标题*/
    private String title;
    /*歌单图片*/
    private String pic;
    /*简介*/
    private String introduction;
    /*风格*/
    private String style;
}
