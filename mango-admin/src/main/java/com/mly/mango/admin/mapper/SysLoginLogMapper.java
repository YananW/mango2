package com.mly.mango.admin.mapper;

import com.mly.mango.admin.model.SysLoginLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysLoginLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysLoginLog record);

    int insertSelective(SysLoginLog record);

    SysLoginLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysLoginLog record);

    int updateByPrimaryKey(SysLoginLog record);

    /**
     * 分页查询
     * @return
     */
    List<SysLoginLog> findPage();

    /**
     * 根据用户名分页查询
     * @param userName
     * @return
     */
    List<SysLoginLog> findPageByUserName(@Param("userName") String userName);

    /**
     * 根据状态分页查询
     * @param status
     * @return
     */
    List<SysLoginLog> findPageByStatus(@Param("status") String status);
}