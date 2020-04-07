package com.mly.mango.admin.service.impl;

import com.mly.mango.admin.constant.SysConstants;
import com.mly.mango.admin.mapper.SysMenuMapper;
import com.mly.mango.admin.mapper.SysRoleMapper;
import com.mly.mango.admin.mapper.SysRoleMenuMapper;
import com.mly.mango.admin.model.SysMenu;
import com.mly.mango.admin.model.SysRole;
import com.mly.mango.admin.model.SysRoleMenu;
import com.mly.mango.admin.service.SysRoleService;
import com.mly.mango.core.page.MyBatisPageHelper;
import com.mly.mango.core.page.PageRequest;
import com.mly.mango.core.page.PageResult;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wyn
 * @Description 角色管理实现类
 * @date 2020-04-05 14:45
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;


    public SysRoleMapper getSysRoleMapper() {
        return sysRoleMapper;
    }

    public void setSysRoleMapper(SysRoleMapper sysRoleMapper) {
        this.sysRoleMapper = sysRoleMapper;
    }

    /**
     * 查询全部
     * @return
     */
    @Override
    public List<SysRole> findAll() {
        return sysRoleMapper.findAll();
    }

    /**
     * 查询角色菜单关系数据
     * @param roleId
     * @return
     */
    @Override
    public List<SysMenu> findRoleMenus(Long roleId) {

        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(roleId);
        if(SysConstants.ADMIN.equalsIgnoreCase(sysRole.getName())){
            //如果是超级管理员，返回全部
            return sysMenuMapper.findAll();
        }
        return sysMenuMapper.findRoleMenus(roleId);
    }

    /**
     * 保存角色菜单关系数据
     * @param records
     * @return
     */
    @Transactional
    @Override
    public int saveRoleMenus(List<SysRoleMenu> records) {

        if(records ==null || records.isEmpty()){
            return 1;
        }
        Long roleId = records.get(0).getRoleId();
        sysRoleMenuMapper.deleteByRoleId(roleId);
        for (SysRoleMenu record:
             records) {
            sysRoleMenuMapper.insertSelective(record);

        }

        return 1;
    }

    /**
     * 根据名称查询
     * @param name
     * @return
     */
    @Override
    public List<SysRole> findByName(String name) {
        return sysRoleMapper.findByName(name);
    }

    /**
     * 保存角色数据
     * @param record
     * @return
     */
    @Override
    public int save(SysRole record) {
        if(record.getId() ==null || record.getId()==0){
            return sysRoleMapper.insertSelective(record);
        }
        return sysRoleMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 删除角色数据
     * @param record
     * @return
     */
    @Override
    public int delete(SysRole record) {

        return sysRoleMapper.deleteByPrimaryKey(record.getId());
    }

    /**
     * 批量删除
     * @param records
     * @return
     */
    @Override
    public int delete(List<SysRole> records) {
        for (SysRole record :
                records) {
            delete(record);
        }
        return 1;
    }

    /**
     * 根据ID查询角色
     * @param id
     * @return
     */
    @Override
    public SysRole findById(Long id) {
        return sysRoleMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页查询
     * @param pageRequest 自定义，统一分页查询请求
     * @return
     */
    @Override
    public PageResult findPage(PageRequest pageRequest) {

        Object name = pageRequest.getParam("name");
        if(name != null){

           return MyBatisPageHelper.findPage(pageRequest,sysRoleMapper,"findPageByName",name);
        }
        return MyBatisPageHelper.findPage(pageRequest,sysRoleMapper);
    }
}
