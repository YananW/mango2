package com.mly.mango.admin.mapper;

import com.mly.mango.admin.model.SysUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);

    /**
     * 根据用户ID删除
     * @param id
     */
    int deleteByUserId(Long id);

    /**
     * 根据用户Id查询用户角色关系数据
     * @param userId
     * @return
     */
    List<SysUserRole> findUserRoles(@Param("userId") Long userId);
}