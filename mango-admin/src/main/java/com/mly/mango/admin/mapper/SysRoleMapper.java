package com.mly.mango.admin.mapper;

import com.mly.mango.admin.model.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    /**
     * 分页查询
     * @return
     */
    List<SysRole> findPage();

    /**
     * 查询所有
     * @return
     */
    List<SysRole> findAll();

    /**
     * 根据角色名分页查询
     * @param name
     * @return
     */
    List<SysRole> findPageByName(@Param("name") String name);

    /**
     * 根据角色名查询
     * @param name
     * @return
     */
    List<SysRole> findByName(@Param("name") String name);
}