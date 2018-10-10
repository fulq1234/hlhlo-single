package com.lummei.jobapp.service;

import com.lummei.jobapp.entity.HlhloUser;
import com.lummei.jobapp.entity.UserRole;
import com.lummei.jobapp.mapper.PermissionMapper;
import com.lummei.jobapp.mapper.UserMapper;
import com.lummei.jobapp.protocol.CommonConstant;
import com.lummei.jobapp.protocol.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl{
    @Autowired
    private UserMapper userMapper;
//
//    @Autowired
//    private SocialMapper socialMapper;
//
   @Autowired
   private PermissionMapper permissionMapper;



    @Transactional
    public Result<Boolean> regUser(HlhloUser user) {
        String username = user.getUsername();
        String password = user.getPassword();
        boolean checkUser = StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password);
        if (!checkUser) {
            return Result.buildSuccess("注册新用户时，发现用户名或密码为空。", false);
        }

        //使用username检查用户是否已经存在。
        HlhloUser dbUser = this.userMapper.getUserByUsername(username);
        if (dbUser != null) {
            return Result.buildSuccess("注册新用户时，发现用户已经注册。", false);
        }
        HlhloUser dbUser2 = this.userMapper.getUserByMobile(user.getMobile());
        if (dbUser2 != null) {
            return Result.buildSuccess("注册新用户时，发现用户已经注册。", false);
        }

        int result = this.userMapper.regUser(user);
        if (result != 1) {
            return Result.buildSuccess("注册新用户失败。", false);
        }

        Long userId = user.getId();

        user.setId(userId);//把id赋给user

        this.userMapper.addJobSeeker(userId);

        this.userMapper.addHRInfo(userId);

        List<UserRole> userRoles = new ArrayList<UserRole>();
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(CommonConstant.ROLE_USER);
        userRoles.add(userRole);

        userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(CommonConstant.ROLE_JOB);
        userRoles.add(userRole);

        userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(CommonConstant.ROLE_HR_UNAUTHORIZED);
        userRoles.add(userRole);
        this.permissionMapper.insertUserRoles(userRoles);



        return Result.buildSuccess("", true);
    }


}
