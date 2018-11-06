package com.hlhlo.hlhlocloudframeworkwx.service;

import com.hlhlo.hlhlocloudframeworkwx.entity.WxKfAccount;
import com.hlhlo.hlhlocloudframeworkwx.entity.WxKfSession;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxKfSessionService {

    /**
     * 根据客服的openid,得到客服接待的人员列表
     * @param kfaccountid
     * @return
     */
    public List<WxKfSession> getUsersByAccountId(Long kfaccountid);

    /**
     * 根据客服openid和用户的openid,得到二者的聊天记录
     * @param kfSession：
     * @return
     */
    List<WxKfSession> getContent(WxKfSession kfSession);

    /**
     * 插入聊天记录
     * @param account
     * @return
     */
    int insert(WxKfSession account);

    /**
     * 根据客服账号更新会话状态：update wx_kfsession set status=0 where kfaccountid=session.id;
     * @param status：当前聊天的客服是否还在接待，1：在接待；0：没再接待。
     * @param accountid
     * @return
     */
    int updateStatusByAccountId(Integer status,Long accountid);
}
