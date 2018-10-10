package com.lummei.jobapp.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class HlhloUser implements Serializable {
    private static final long serialVersionUID = -1590823625522943468L;
    private Long id;
    private String username;
    private String password;
    private String salt;
    private String nickName;
    private String avatarUrl;
    private String openId;
    private String unionId;
    private String realName;
    private Date birthday;
    private String sex;
    private String email;
    private String mobile;
    private String wxid;
    private String status;
    private Date createTime;
    private Date updateTime;



}
