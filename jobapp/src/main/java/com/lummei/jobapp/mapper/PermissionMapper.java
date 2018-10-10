package com.lummei.jobapp.mapper;

import com.lummei.jobapp.entity.Menu;
import com.lummei.jobapp.entity.Privilege;
import com.lummei.jobapp.entity.UserRole;
import org.apache.ibatis.annotations.*;

import java.util.Collection;
import java.util.List;

@Mapper
public interface PermissionMapper {
    @Select("SELECT m.`id`,m.`serviceId`,m.`code`,m.`p_code`,m.`p_id`,m.`name`,m.`url`,m.`is_menu`,m.`level`,m.`sort`,m.`status`,m.`icon`,m.`create_time`,m.`update_time` "
            + " FROM `sys_menu` m,`sys_privilege` p where m.id=p.menu_id and p.role_id= #{roleId}")
    List<Menu> getPermissionsByRoleId(@Param("roleId") Long roleId);

    @Select({
            "<script>" +
                    "select" +
                    " m.`id`,m.`serviceId`,m.`code`,m.`p_code`,m.`p_id`,m.`name`,m.`url`,m.`is_menu`,m.`level`,m.`sort`,m.`status`,m.`icon`,m.`create_time`,m.`update_time`" +
                    "FROM `sys_menu` m left join `sys_privilege` p  on  m.id=p.menu_id " +
                    "where p.role_id in " +
                    "<foreach collection='roleIds' item='id' open='(' separator=',' close=')'>" +
                    "#{id}" +
                    "</foreach>" +
                    "</script>"
    })
    List<Menu> getPermissionsByRoleIds(@Param("roleIds") Collection<Long> roleIds);



    @Select("select role_id, menu_id from sys_privilege")
    @Results({
            @Result(property = "roleId", column = "role_Id"),
            @Result(property = "menuId", column = "menu_id")
    })
    List<Privilege> getAllPrivilege();

    @Delete("delete from sys_privilege where menu_id = #{menuId}")
    int deletePrivilege(Long menuId);

    @Insert({"<script>" +
            "insert into sys_user_role(user_id, role_id, create_time, create_by) values"+
            "<foreach collection='userRoles' item='item'  separator=','>" +
            "(#{item.userId},#{item.roleId},#{item.createTime},#{item.createBy})" +
            "</foreach>" +
            "</script>"
    })
    int insertUserRoles(@Param("userRoles") List<UserRole> userRoles);

}
