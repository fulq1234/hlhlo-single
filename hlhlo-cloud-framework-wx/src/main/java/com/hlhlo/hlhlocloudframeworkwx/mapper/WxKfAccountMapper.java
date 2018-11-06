package com.hlhlo.hlhlocloudframeworkwx.mapper;

import com.hlhlo.hlhlocloudframeworkwx.entity.WxKfAccount;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 客服表
 */
@Mapper
public interface WxKfAccountMapper {

    /**
     * 根据当前登录的客服的微信号，更新openid
     * @param openid
     * @param kf_wx
     * @return
     */
    @Update("update wx_kfaccount set openid = #{openid} where kf_wx=#{kf_wx}")
    int updateOpenIdByKfwx(@Param(value="openid")String openid, @Param("kf_wx") String kf_wx);

    /**
     * 根据openid,得到客服的详细信息。
     * @param openid
     * @return
     */
    @Select("select * from wx_kfaccount where openid = #{openid}")
    WxKfAccount queryInfoByOpenid(String openid);

    /**
     * 查找所有在线客服,排除自身
     * @param openid
     * @param status：客服在线状态，目前为：1、web 在线
     * @return
     */
    @Select("<script>select * from wx_kfaccount where openid !=#{openid} <if test='status != null'>and status=#{status}</if></script>")
    List<WxKfAccount> queryKfList(@Param("openid") String openid, @Param("status") Integer status);


    //update wx_kfsession set status=0 where kfaccountid=session.id;
    //Wx_kfaacount a = queryByAccount(account);//新客服
    //insert into wx_kfsession(kfaccountid,user_openid,opercode,text,time) values(a.id,user_openid,'2002','您好，新客服为您服务',new Date());

    /**
     * 根据客服账号得到客服的详细信息
     * @param kf_account
     * @return
     */
    @Select("select * from wx_kfaccount where kf_account=#{kf_account}")
    WxKfAccount queryInfoByAccount(String kf_account);


}
