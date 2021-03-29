package com.ws.musicserver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 无声 <ivestszheng@qq.com>
 * @version 1.0
 * @descripttion 歌手
 * @date 2020/12/4 23:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Singer implements Serializable {
    /*主键*/
    private Integer id;
    /*账号*/
    private String name;
    /*性别*/
    private Byte sex;
    /*头像*/
    private String pic;
    /*生日*/
    private Date birth;
    /*地区*/
    private String location;
    /*简介*/
    private String introduction;
}
