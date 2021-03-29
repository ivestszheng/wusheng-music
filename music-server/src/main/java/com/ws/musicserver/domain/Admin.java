package com.ws.musicserver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 无声 <ivestszheng@qq.com>
 * @version 1.0
 * @Descripttion 管理员实体类
 * @date 2020/12/4 15:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin implements Serializable {
    /*Serializable是一个对象序列化的接口，一个类只有实现了Serializable接口，它的对象才是可序列化的。
    *因此如果要序列化某些类的对象，这些类就必须实现Serializable接口。
    *而实际上，Serializable是一个空接口，没有什么具体内容，它的目的只是简单的标识一个类的对象可以被序列化。
    */
//    主键
    private Integer id;
//    账号
    private String name;
//    密码
    private String password;
}
