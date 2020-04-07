package com.mly.mango.admin.controller;

import com.mly.mango.admin.model.SysLog;
import com.mly.mango.admin.model.SysLoginLog;
import com.mly.mango.admin.service.SysLogService;
import com.mly.mango.admin.service.SysLoginLogService;
import com.mly.mango.core.http.HttpResult;
import com.mly.mango.core.page.PageRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wyn
 * @Description 日志控制类
 * @date 2020-04-05 22:24
 */
@RestController
@RequestMapping("log")
@Api(tags = "日志管理模块")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @PostMapping("/findPage")
    @ApiOperation("分页查询")
    @PreAuthorize("hasAuthority('sys:log:view')")
    public HttpResult findPage(@RequestBody PageRequest pageRequest){
        return HttpResult.ok(sysLogService.findPage(pageRequest));

    }

    @PostMapping("/delete")
    @ApiOperation("删除登录日志")
    @PreAuthorize("hasAuthority('sys:log:delete')")
    public HttpResult delete(List<SysLog> records){
        return HttpResult.ok(sysLogService.delete(records));

    }
}
