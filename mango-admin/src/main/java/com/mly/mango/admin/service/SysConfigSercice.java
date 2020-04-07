package com.mly.mango.admin.service;

import com.mly.mango.admin.model.SysConfig;
import com.mly.mango.core.service.CurdService;

import java.util.List;

/**
 * @author wyn
 * @Description 系统配置接口类
 * @date 2020-04-05 17:40
 */
public interface SysConfigSercice extends CurdService<SysConfig> {

    /**
     * 根据名称查询
     * @param label
     * @return
     */
    List<SysConfig> findByLabel(String label);
}
