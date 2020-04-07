package com.mly.mango.admin.controller;

import com.mly.mango.admin.constant.SysConstants;
import com.mly.mango.admin.mapper.SysRoleMapper;
import com.mly.mango.admin.model.SysRole;
import com.mly.mango.admin.model.SysRoleMenu;
import com.mly.mango.admin.service.SysRoleService;
import com.mly.mango.core.http.HttpResult;
import com.mly.mango.core.page.PageRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wyn
 * @Description 角色管理器
 * @date 2020-04-05 15:21
 */
@RestController
@RequestMapping("role")
@Api(tags = "角色管理模块")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @PostMapping("/save")
    @ApiOperation("添加角色信息")
    @PreAuthorize("hasAuthority('sys:role:add') AND hasAuthority('sys:role:edit')")
    public HttpResult save(@RequestBody SysRole record){
        SysRole sysRole = sysRoleService.findById(record.getId());

        if(sysRole!=null){
            if(SysConstants.ADMIN.equalsIgnoreCase(sysRole.getName())){
                return HttpResult.error("超级管理员不允许修改");
            }
        }
        if((record.getId() ==null || record.getId() ==0)&& sysRoleService.findByName(record.getName()).isEmpty()){

            return HttpResult.error("角色名已存在");
        }
        return HttpResult.ok(sysRoleService.save(record));


    }


    /**
     * 批量删除
     * @param records
     * @return
     */
    @PostMapping("/delete")
    @ApiOperation("删除角色信息")
    @PreAuthorize("hasAuthority('sys:role:delete')")
    public HttpResult delete(@RequestBody List<SysRole> records){

        return HttpResult.ok(sysRoleService.delete(records));
    }


    /**
     * 分页查询
     * @param pageRequest
     * @return
     */
    @PostMapping("/findPage")
    @ApiOperation("分页查询角色信息")
    @PreAuthorize("hasAuthority('sys:role:view')")
    public HttpResult findPage(@RequestBody PageRequest pageRequest){
        return HttpResult.ok(sysRoleService.findPage(pageRequest));
    }


    /**
     * 查询全部
     * @return
     */
    @GetMapping("/findAll")
    @ApiOperation("查询全部角色信息")
    @PreAuthorize("hasAuthority('sys:role:view')")
    public HttpResult findAll(){

        return HttpResult.ok(sysRoleService.findAll());
    }

    /**
     * 根据角色ID获取角色菜单关系数据
     * @param roleId
     * @return
     */
    @GetMapping("/findRoleMenus")
    @ApiOperation("角色ID查询角色菜单关系")
    @PreAuthorize("hasAuthority('sys:role:view')")
    public HttpResult findRoleMenus(@RequestParam Long roleId){

        return HttpResult.ok(sysRoleService.findRoleMenus(roleId));

    }

    /**
     * 保存角色菜单关系数据
     * @param records
     * @return
     */
    @PostMapping("/saveRoleMenus")
    @ApiOperation("保存角色菜单关系数据")
    @PreAuthorize("hasAuthority('sys:role:view')")
    public HttpResult saveRoleMenus(List<SysRoleMenu> records){

        for (SysRoleMenu record :
                records) {
            SysRole sysRole = sysRoleMapper.selectByPrimaryKey(record.getRoleId());
            if(SysConstants.ADMIN.equalsIgnoreCase(sysRole.getName())){
                return HttpResult.error("超级管理员拥有所有的菜单权限，不允许修改！");
            }
        }

        return HttpResult.ok(sysRoleService.saveRoleMenus(records));

    }




}
