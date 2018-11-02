package com.hlhlo.hlhlocloudframeworkwx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class WxKfSession {
    private Long id;

    private String kf_openid;

    private String user_openid;

    //操作码，2002（客服发送信息），2003（客服接收消息）
    private String opercode;

    //聊天记录
    private String text;

    //操作时间，unix时间戳
    private Date time;
}
