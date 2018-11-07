package com.hlhlo.hlhlocloudframeworkwx.entity;

import lombok.Data;

import java.util.Date;

@Data
public class WxKfAccount {

    private Long id;
    private String openid;

    private String kf_account;

    private String kf_nick;

    private String kf_id;

    private String kf_headimgurl;

    private String kf_wx;

    private Integer status;

    private Integer accepted_case;

    private Date create_time;

}
