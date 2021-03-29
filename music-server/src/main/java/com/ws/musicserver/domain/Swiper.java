package com.ws.musicserver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 无声 <ivestszheng@qq.com>
 * @version 1.0
 * @descripttion 轮播图地址
 * @date 2020/12/7 20:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Swiper implements Serializable {
    /*主键*/
    private Integer id;
    /*轮播图名字*/
    private String name;
    /*轮播图地址*/
    private String url;
}
