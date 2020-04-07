package com.mly.mango.admin.service;

import com.mly.mango.admin.model.SysMenu;
import com.mly.mango.admin.model.SysRole;
import com.mly.mango.admin.model.SysRoleMenu;
import com.mly.mango.core.service.CurdService;

import java.util.List;

/**
 * @author wyn
 * @Description 角色管理接口类
 * @date 2020-04-05 14:42
 */
public interface SysRoleService extends CurdService<SysRole> {

    /**
     * 查询全部
     * @return
     */
    List<SysRole> findAll();

    /**
     * 查询角菜单集合
     * @param roleId
     * @return
     */
    List<SysMenu> findRoleMenus(Long roleId);

    /**
     * 保存角色菜单关系
     * @param records
     * @return
     */
    int saveRoleMenus(List<SysRoleMenu> records);

    /**
     * 根据名称查询
     * @param name
     * @return
     */
    List<SysRole> findByName(String name);

}
