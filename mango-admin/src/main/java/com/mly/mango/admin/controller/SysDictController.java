package com.mly.mango.admin.controller;

import com.mly.mango.admin.model.SysDict;
import com.mly.mango.admin.service.SysDictService;
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
 * @Description 字典管理控制器
 * @date 2020-04-05 11:24
 */
@RestController
@RequestMapping("dict")
@Api(tags = "字典管理模块")
public class SysDictController {

    @Autowired
    private SysDictService sysDictService;


    @PostMapping("/save")
    @ApiOperation(value = "保存字典数据")
    @PreAuthorize("hasAnyAuthority('sys:dict:add') and hasAnyAuthority('sys:dict:edit')")
    public HttpResult save(@RequestBody SysDict record) {

        return HttpResult.ok(sysDictService.save(record));
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "批量删除字典数据")
    @PreAuthorize("hasAnyAuthority('sys:dict:delete')")
    public HttpResult delete(@RequestBody List<SysDict> record) {

        return HttpResult.ok(sysDictService.delete(record));
    }

    @PostMapping("/findPage")
    @ApiOperation(value = "分页查询字典数据")
    @PreAuthorize("hasAnyAuthority('sys:dict:view')")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {

        return HttpResult.ok(sysDictService.findPage(pageRequest));

    }

    @GetMapping("/findByLabel")
    @ApiOperation(value = "根据标签名称查询")
    @PreAuthorize("hasAuthority('sys:dict:view')")
    public HttpResult findByLabel(@RequestBody String label) {

        return HttpResult.ok(sysDictService.findByLabel(label));

    }


}
