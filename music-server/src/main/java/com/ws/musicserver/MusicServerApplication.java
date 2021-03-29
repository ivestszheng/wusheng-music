package com.ws.musicserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
* 热更新、热加载
* 1、Ctrl+Shift+A --> 搜索registry  allow.when.app.running
* 2、执行快捷键 Ctrl + F9 才执行热加载
*/
@SpringBootApplication
@MapperScan("com.ws.musicserver.dao")
public class MusicServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicServerApplication.class, args);
    }

}
