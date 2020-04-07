package com.mly.mango.admin.controller;

import com.mly.mango.admin.model.SysDept;
import com.mly.mango.admin.service.SysDeptService;
import com.mly.mango.core.http.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wyn
 * @Description 机构管理控制器
 * @date 2020-04-05 17:19
 */
@RestController
@RequestMapping("dept")
@Api(tags = "机构管理模块")
public class SysDeptController {

    @Autowired
    private SysDeptService sysDeptService;

    @PostMapping("/save")
    @ApiOperation("添加机构信息")
    @PreAuthorize("hasAuthority('sys:dept:add') AND hasAuthority('sys:dept:edit')")
    public HttpResult save(@RequestBody SysDept record){

        return HttpResult.ok(sysDeptService.save(record));
    }

    @PostMapping("/delete")
    @ApiOperation("删除机构信息")
    @PreAuthorize("hasAuthority('sys:dept:delete')")
    public HttpResult delete(@RequestBody List<SysDept> records){

        return HttpResult.ok(sysDeptService.delete(records));
    }

    @GetMapping("/findTree")
    @ApiOperation("查询机构树")
    @PreAuthorize("hasAuthority('sys:dept:view')")
    public HttpResult findTree(){

        return HttpResult.ok(sysDeptService.findTree());
    }

}
