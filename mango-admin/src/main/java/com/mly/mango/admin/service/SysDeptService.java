package com.mly.mango.admin.service;

import com.mly.mango.admin.model.SysDept;
import com.mly.mango.core.service.CurdService;

import java.util.List;

/**
 * @author wyn
 * @Description 机构管理接口
 * @date 2020-04-05 17:20
 */
public interface SysDeptService extends CurdService<SysDept> {
    /**
     * 查询机构树
     * @return
     */
    List<SysDept> findTree();
}
