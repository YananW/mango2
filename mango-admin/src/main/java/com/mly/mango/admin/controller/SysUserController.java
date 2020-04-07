package com.mly.mango.admin.controller;

import com.mly.mango.admin.constant.SysConstants;
import com.mly.mango.admin.model.SysUser;
import com.mly.mango.admin.service.SysUserService;
import com.mly.mango.core.http.HttpResult;
import com.mly.mango.core.page.PageRequest;
import com.mly.mango.utils.FileUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

/**
 * @author wyn
 * @Description
 * @date 2020-04-02 12:59
 */
@RestController
@RequestMapping("user")
@Api(tags = "用户管理模块")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;


    @PostMapping("/save")
    @ApiOperation(value = "添加用户信息")
    @PreAuthorize("hasAuthority('sys:user:add') AND hasAuthority('sys:user:edit')")
    public HttpResult save(@RequestBody SysUser records){

        return null;

    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除用户信息")
    @PreAuthorize("hasAuthority('sys:user:delete')")
    public HttpResult delete(@RequestBody List<SysUser> records) {

        for (SysUser record :
                records) {
            SysUser sysUser = sysUserService.findById(record.getId());
            if(sysUser!=null && SysConstants.ADMIN.equalsIgnoreCase(sysUser.getName())){

                return HttpResult.error("超级管理员不允许删除");
            }

        }
        return HttpResult.ok(sysUserService.delete(records));
    }

    @PostMapping("/findPage")
    @ApiOperation(value = "用户信息分页查询")
    @PreAuthorize("hasAuthority('sys:user:view')")
    public HttpResult findPage(PageRequest pageRequest) {

        return HttpResult.ok(sysUserService.findPage(pageRequest));
    }

    @GetMapping(value="/findByName")
    @ApiOperation(value = "用户名查询用户信息")
    @PreAuthorize("hasAuthority('sys:user:view')")
    public HttpResult findByName(@RequestParam String name) {
        return HttpResult.ok(sysUserService.findByName(name));
    }

    @GetMapping(value="/findPermissions")
    @ApiOperation(value = "查找用户的菜单权限")
    @PreAuthorize("hasAuthority('sys:user:view')")
    public HttpResult findPermissions(@RequestParam String name) {
        return HttpResult.ok(sysUserService.findPermissions(name));
    }

    @GetMapping(value="/findUserRoles")
    @ApiOperation(value = "用户ID查询用户角色关系")
    @PreAuthorize("hasAuthority('sys:user:view')")
    public HttpResult findUserRoles(@RequestParam Long userId) {
        return HttpResult.ok(sysUserService.findUserRoles(userId));
    }

    @PostMapping(value="/exportExcelUser")
    @ApiOperation(value = "生成用户信息Excel文件")
    @PreAuthorize("hasAuthority('sys:user:view')")
    public void exportExcelUser(@RequestBody PageRequest pageRequest, HttpServletResponse res) {
        File file = sysUserService.createUserExcelFile(pageRequest);
        FileUtils.downloadFile(res, file, file.getName());
    }
}
