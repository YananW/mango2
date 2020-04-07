package com.mly.mango.admin.mapper;

import com.mly.mango.admin.model.SysLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    SysLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKey(SysLog record);

    /**
     * 分页查询
     * @return
     */
    List<SysLog> findPage();

    /**
     * 根据用户名分页查询
     * @param userName
     * @return
     */
    List<SysLog> findPageByUserName(@Param("userName") String userName);
}