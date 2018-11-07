package com.hlhlo.hlhlocloudframeworkwx.mapper;

import com.hlhlo.hlhlocloudframeworkwx.entity.WxKfSession;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 客服对应的会话表
 */
@Mapper
public interface WxKfSessionMapper {

    /**
     * 聊天记录
     * @return
     */
    @Select("<script>select * from wx_kfsession where 1=1 <if test='kfaccountid != null '>and kfaccountid = #{kfaccountid} </if> <if test='user_openid!= null'>and user_openid = #{user_openid}</if><if test='status!= null'> and status = #{status}</if></script>")
    List<WxKfSession> getContent(WxKfSession kfSession);

    /**
     * 得到最后的一条信息
     * @param kfSession
     * @return
     */
    @Select("<script>select * from wx_kfsession where 1=1 <if test='kfaccountid != null '>and kfaccountid = #{kfaccountid} </if> <if test='user_openid!= null'>and user_openid = #{user_openid}</if><if test='status!= null'> and status = #{status}</if> order by time desc,id desc limit 1</script>")
    WxKfSession getLatelyContent(WxKfSession kfSession);

    /**
     * 得到在接待的客服的聊天人员列表
     * @param kfaccountid：客服表(wx_kfaccount)的主键id
     * @return
     */
    @Select("select distinct user_openid from wx_kfsession where kfaccountid = #{kfaccountid} order by time desc,id desc")
    List<WxKfSession> getUsersByAccountId(Long kfaccountid);

    /**
     * 新增聊天记录
     * @param account
     * @return
     */
    @Insert("insert into wx_kfsession(kfaccountid,user_openid,opercode,text) values(#{kfaccountid},#{user_openid},#{opercode},#{text})")
    int insert(WxKfSession account);


    /**
     * 根据客服账号更新会话状态：update wx_kfsession set status=0 where kfaccountid=session.id;
     * @param status：当前聊天的客服是否还在接待，1：在接待；0：没再接待。
     * @param accountid
     * @return
     */
    @Update("update wx_kfsession set status=#{status} where kfaccountid=#{accountid}")
    int updateStatusByAccountId(@Param(value="status") Integer status,@Param(value="accountid") Long accountid);


}
