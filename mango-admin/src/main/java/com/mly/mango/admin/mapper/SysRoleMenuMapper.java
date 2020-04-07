package com.mly.mango.admin.mapper;

import com.mly.mango.admin.model.SysRoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleMenu record);

    int insertSelective(SysRoleMenu record);

    SysRoleMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleMenu record);

    int updateByPrimaryKey(SysRoleMenu record);

    /**
     * 根据角色ID查询角色菜单关系的数据
     * @param roleId
     * @return
     */
    List<SysRoleMenu> findRoleMenus(@Param("roleId") Long roleId);

    /**
     * 查询全部
     * @return
     */
    List<SysRoleMenu> findAll();

    /**
     * 根据角色ID删除数据
     * @param roleId
     */
     int deleteByRoleId(Long roleId);
}