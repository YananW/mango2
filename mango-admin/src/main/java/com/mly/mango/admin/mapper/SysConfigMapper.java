package com.mly.mango.admin.mapper;

import com.mly.mango.admin.model.SysConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysConfigMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysConfig record);

    int insertSelective(SysConfig record);

    SysConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysConfig record);

    int updateByPrimaryKey(SysConfig record);

    /**
     * 分页查询
     * @return
     */
    List<SysConfig> findPage();

    /**
     * 根据名称查询数据
     * @param label
     * @return
     */
    List<SysConfig> findByLabel(@Param("label") String label);

    /**
     * 根据名称分页查询
     * @param label
     * @return
     */
    List<SysConfig> findPageByLabel(@Param("label") String label);
}