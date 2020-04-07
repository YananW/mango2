package com.mly.mango.admin.mapper;

import com.mly.mango.admin.model.SysMenu;
import com.mly.mango.admin.model.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    /**
     * 分页查询
     * @return
     */
    List<SysMenu> findPage();

    /**
     * 根据菜单名分页查询
     * @param name
     * @return
     */
    List<SysMenu> findPageByName(@Param("name") String name);

    /**
     * 查询全部
     * @return
     */
    List<SysMenu> findAll();

    /**
     * 根据角色ID查询角色菜单关系数据
     * @param roleId
     * @return
     */
    List<SysMenu> findRoleMenus(Long roleId);

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    List<SysMenu> findByUserName(@Param("username") String username);
}