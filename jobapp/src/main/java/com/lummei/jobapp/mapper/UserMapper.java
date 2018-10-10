package com.lummei.jobapp.mapper;

import com.lummei.jobapp.entity.HlhloUser;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    static final String SQL_SELECT_FIELDS = "id, username, password, salt, nickName, avatarUrl, openId, unionId, realName, birthday, sex, email, mobile, wxid, status, createTime, updateTime";

   /* @Insert("insert into sys_user (username, password, salt, nickName, avatarUrl, openId, unionId, realName, birthday, sex, email, mobile, wxid, status, createTime, updateTime) "
            + " values(#{username}, #{password}, #{salt}, #{nickName}, #{avatarUrl}, #{openId}, #{unionId}, #{realName}, #{birthday}, #{sex}, #{email}, #{mobile}, #{wxid}, #{status}, #{createTime}, #{updateTime}")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addUser(HlhloUser user);*/

    @Insert("insert into sys_user (username,password,salt,mobile,status,createTime,updateTime,nickName,realName,birthday,sex,email) "
            + " values(#{username},#{password},#{salt},#{mobile},#{status},#{createTime},#{updateTime},#{nickName},#{realName},#{birthday},#{sex},#{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int regUser(HlhloUser user);

    @Update("update sys_user set password = #{password} where id = #{userId}")
    int changePassword(@Param("userId") Long userId, @Param("password") String password);

    @Select("SELECT " + SQL_SELECT_FIELDS + " FROM `sys_user` where id = #{id}")
    HlhloUser getUserById(@Param("id") Long id);

    @Select("SELECT " + SQL_SELECT_FIELDS + " FROM `sys_user` where username = #{username}")
    HlhloUser getUserByUsername(@Param("username") String username);

    @Select("SELECT " + SQL_SELECT_FIELDS + " FROM `sys_user` where mobile = #{mobile}")
    HlhloUser getUserByMobile(@Param("mobile") String mobile);

    @Insert(value = "insert into jobseeker (id) values(#{userId})")
    int addJobSeeker(@Param("userId") Long userId);

    @Insert(value = "insert into hrinfo (id) values(#{id})")
    int addHRInfo(@Param("id") Long id);

    @Update(value = "update sys_user set avatarUrl = #{avatarUrl}, realName = #{realName},sex = #{sex},birthday = #{birthday},email = #{email},mobile = #{mobile}, wxid = #{wxid} where id = #{id}")
    int updateUserInfo(HlhloUser hlhloUser);

}
