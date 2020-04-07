package com.mly.mango.admin.service;


import com.mly.mango.admin.model.SysUser;
import com.mly.mango.admin.model.SysUserRole;
import com.mly.mango.core.page.PageRequest;
import com.mly.mango.core.service.CurdService;

import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * @author wyn
 * @Description 用户管理接口
 * @date 2020-04-02 12:56
 */
public interface SysUserService extends CurdService<SysUser> {




    /**
     * 根据用户查询用户信息
     * @param username
     * @return
     */
    SysUser findByName(String username);


    /**
     * 根据用户ID查询用户角色关系数据
     * @param userId
     * @return
     */
    List<SysUserRole> findUserRoles(Long userId);

    /**
     * 生成用户信息Excel文件
     * @param pageRequest 要导出的分页查询参数
     * @return
     */
    File createUserExcelFile(PageRequest pageRequest);

    /**
     * 查找用户的菜单权限标识集合
     * @param userName
     * @return
     */
    Set<String> findPermissions(String userName);

}
