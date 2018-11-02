package com.hlhlo.hlhlocloudframeworkwx.mapper;

import com.hlhlo.hlhlocloudframeworkwx.entity.WxKfAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 客服表
 */
@Mapper
public interface WxKfAccountMapper {

    /**
     * 根据当前登录的客服的微信号，更新openid
     * @param account
     * @return
     */
    @Update("update wx_kfaccount set openid = #{openid} where kf_wx=#{kf_wx}")
    int updateKfAccount(WxKfAccount account);

    /**
     * 根据openid,得到客服的详细信息。
     * @param openid
     * @return
     */
    @Select("select * from wx_kfaccount where openid = #{openid}")
    WxKfAccount queryInfoByOpenid(String openid);


}
