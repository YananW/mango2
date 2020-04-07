package com.mly.mango.admin.mapper;

import com.mly.mango.admin.model.SysDept;

import java.util.List;

public interface SysDeptMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysDept record);

    int insertSelective(SysDept record);

    SysDept selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysDept record);

    int updateByPrimaryKey(SysDept record);

    /**
     * 查询全部数据
     * @return
     */
    List<SysDept> finAll();

    List<SysDept> findPage();


}