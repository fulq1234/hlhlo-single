package com.hlhlo.hlhlocloudframeworkwx.service;

import com.hlhlo.hlhlocloudframeworkwx.entity.WxKfAccount;
import com.hlhlo.hlhlocloudframeworkwx.entity.WxKfSession;

import java.util.List;

public interface WxKfSessionService {

    /**
     * 根据客服的openid,得到客服接待的人员列表
     * @param openid
     * @return
     */
    List<WxKfSession> getUsersByKfOpenid(String openid);

    /**
     * 根据客服openid和用户的openid,得到二者的聊天记录
     * @param kf_openid：客服的openid
     * @param user_openid：用户的openid
     * @return
     */
    List<WxKfSession> getContent(String kf_openid,String user_openid);

    /**
     * 插入聊天记录
     * @param account
     * @return
     */
    int insert(WxKfSession account);
}
