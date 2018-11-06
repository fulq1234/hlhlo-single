package com.hlhlo.hlhlocloudframeworkwx.entity;

import lombok.Data;

import java.util.Date;

/**
 * 聊天记录
 */
@Data
public class WxKfSession {
    private Long id;

    //表wx_kfaccount的id
    private Long kfaccountid;

    private String user_openid;

    //操作码，2002（客服发送信息），2003（客服接收消息）
    private String opercode;

    //聊天记录
    private String text;

    //操作时间，unix时间戳
    private Date time;

    //当前聊天的客服是否还在接待，1：在接待；0：没再接待。
    private Integer status;
}
