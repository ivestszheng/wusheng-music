package com.ws.musicserver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 无声 <ivestszheng@qq.com>
 * @version 1.0
 * @descripttion 前端用户
 * @date 2020/12/6 16:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consumer implements Serializable {
    /*主键*/
    private Integer id;
    /*账号*/
    private String username;
    /*密码*/
    private String password;
    /*性别*/
    private Byte sex;
    /*手机号*/
    private String phoneNum;
    /*电子邮箱*/
    private String email;
    /*生日*/
    private Date birth;
    /*签名*/
    private String introduction;
    /*地区*/
    private String location;
    /*头像*/
    private String avator;
    /*创建时间*/
    private Date createTime;
    /*更新时间*/
    private Date updateTime;
}
