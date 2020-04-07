package com.mly.mango.admin.mapper;

import com.mly.mango.admin.model.SysDict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysDictMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysDict record);

    int insertSelective(SysDict record);

    SysDict selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysDict record);

    int updateByPrimaryKey(SysDict record);


    /**
     * 分页查询
     * @return
     */
    List<SysDict> findPage();

    /**
     * 根据标签名称查询
     * @param label
     * @return
     */
    List<SysDict> findByLabel(@Param("label") String label);

    /**
     * 根据标签名称分页查询
     * @param label
     * @return
     */
    List<SysDict> findPageByLabel(@Param("label")String label);
}