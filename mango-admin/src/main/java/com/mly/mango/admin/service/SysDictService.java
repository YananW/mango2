package com.mly.mango.admin.service;

import com.mly.mango.admin.model.SysDict;
import com.mly.mango.core.service.CurdService;

import java.util.List;

/**
 * @author wyn
 * @Description 字典管理 实现接口
 * @date 2020-04-05 11:11
 */
public interface SysDictService extends CurdService<SysDict> {


    /**
     * 根据名称查询
     * @param label
     * @return
     */
    List<SysDict> findByLabel(String label);
}
