package com.ws.musicserver.controller;

import com.ws.musicserver.service.SwiperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 无声 <ivestszheng@qq.com>
 * @version 1.0
 * @descripttion
 * @date 2020/12/7 21:18
 */
@RestController
@RequestMapping("/swiper")
public class SwiperController {

    @Autowired
    private SwiperService swiperService;

    /**
     * 查询所有歌曲
     */
    @RequestMapping(value = "/allSwiper",method = RequestMethod.GET)
    public Object allSwiper(HttpServletRequest request){
        return swiperService.allSwiper();
    }
}
