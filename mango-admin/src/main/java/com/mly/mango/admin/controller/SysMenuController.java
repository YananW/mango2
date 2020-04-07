package com.mly.mango.admin.controller;

import com.mly.mango.admin.model.SysMenu;
import com.mly.mango.admin.service.SysMenuService;
import com.mly.mango.core.http.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wyn
 * @Description 菜单控制器
 * @date 2020-04-05 15:21
 */
@RestController
@RequestMapping("menu")
@Api(tags = "菜单管理模块")
public class SysMenuController {


    @Autowired
    private SysMenuService sysMenuService;

    @PostMapping("/save")
    @ApiOperation("添加菜单信息")
    @PreAuthorize("hasAuthority('sys:menu:add') AND hasAuthority('sys:menu:edit')")
    public HttpResult save(@RequestBody SysMenu record){


        return HttpResult.ok(sysMenuService.save(record));
    }

    @PostMapping("/delete")
    @ApiOperation("删除菜单信息")
    @PreAuthorize("hasAuthority('sys:menu:delete')")
    public HttpResult delete(@RequestBody List<SysMenu> records){

        return HttpResult.ok(sysMenuService.delete(records));
    }


    @GetMapping("/findNavTree")
    @ApiOperation("查询导航菜单树")
    @PreAuthorize("hasAuthority('sys:menu:view')")
    public HttpResult findNavTree(@RequestParam String userName) {


        return HttpResult.ok(sysMenuService.findTree(userName,1));

    }

    @GetMapping("/findMenuTree")
    @ApiOperation("查询菜单树")
    @PreAuthorize("hasAuthority('sys:menu:view')")
    public HttpResult findMenuTree() {
        return HttpResult.ok(sysMenuService.findTree(null,0));
    }


}
