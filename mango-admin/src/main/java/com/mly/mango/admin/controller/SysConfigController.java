package com.mly.mango.admin.controller;

import com.mly.mango.admin.model.SysConfig;
import com.mly.mango.admin.service.SysConfigSercice;
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
 * @Description
 * @date 2020-04-05 17:38
 */
@RestController
@RequestMapping("config")
@Api(tags = "系统配置模块")
public class SysConfigController {


    @Autowired
    private SysConfigSercice sysConfigSercice;

    @PostMapping("/save")
    @ApiOperation("保存系统配置")
    @PreAuthorize("hasAuthority('sys:config:add') AND hasAuthority('sys:config:edit')")
    public HttpResult save(@RequestBody SysConfig record){



        return HttpResult.ok(sysConfigSercice.save(record));
    }

    @PostMapping("/delete")
    @ApiOperation("删除系统配置")
    @PreAuthorize("hasAuthority('sys:config:delete')")
    public HttpResult delete(List<SysConfig> records){

        return HttpResult.ok(sysConfigSercice.delete(records));
    }

    @PostMapping("/findPage")
    @ApiOperation("分页查询")
    @PreAuthorize("hasAuthority('sys:config:view')")
    public HttpResult findPage(@RequestBody PageRequest pageRequest){
        return HttpResult.ok(sysConfigSercice.findPage(pageRequest));

    }
//    @PreAuthorize("hasAuthority('sys:config:view')")
//    @GetMapping(value="/findByLable")
//    public HttpResult findByLable(@RequestParam String lable) {
////        return HttpResult.ok(sysConfigSercice.findByLable(lable));
//    }

}
