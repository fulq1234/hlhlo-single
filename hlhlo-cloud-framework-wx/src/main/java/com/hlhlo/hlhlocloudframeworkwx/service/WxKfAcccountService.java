package com.hlhlo.hlhlocloudframeworkwx.service;

import com.hlhlo.hlhlocloudframeworkwx.entity.WxKfAccount;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WxKfAcccountService {
    /**
     *
     * @param kf_wx
     * @return
     */
    int updateOpenIdByKfwx(String openid,String kf_wx);

    /**
     *
     * @param openid
     * @return
     */
    WxKfAccount queryInfoByOpenid(String openid);

    /**
     * 查看客服列表
     * @param kf_openid
     * @param status：客服在线状态，目前为：1、web 在线
     * @return
     */
    List<WxKfAccount> queryKfList(String kf_openid, Integer status);

    /**
     * 根据客服的账号查询详细信息
     * @param kf_account
     * @return
     */
    WxKfAccount queryInfoByAccount(String kf_account);
}
