package com.hlhlo.hlhlocloudframeworkwx.mapper;

import com.hlhlo.hlhlocloudframeworkwx.entity.WxKfAccount;
import com.hlhlo.hlhlocloudframeworkwx.entity.WxKfSession;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 客服对应的会话表
 */
@Mapper
public interface WxKfSessionMapper {

    @Select("select * from wx_kfsession where kf_openid = #{kf_openid} and user_openid = #{user_openid} ")
    List<WxKfSession> getContent(@Param("kf_openid") String kf_openid,@Param("user_openid") String user_openid);

    @Select("select user_openid from wx_kfsession where kf_openid = #{kf_openid} ")
    List<WxKfSession> getUsersByKfOpenid(@Param("kf_openid") String openid);

    @Insert("insert into wx_kfsession(kf_openid,user_openid,opercode,text,time) values(#{kf_openid},#{user_openid},#{opercode},#{text},#{time})")
    int insert(WxKfSession account);


}
