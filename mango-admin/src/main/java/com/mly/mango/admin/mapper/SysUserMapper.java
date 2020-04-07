package com.mly.mango.admin.mapper;

import com.mly.mango.admin.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);



    /**
     * 分页查询
     * @return
     */
    List<SysUser> findPage();

    /**
     * 根据用户名查询用户信息
     * @param name
     * @return
     */
    SysUser findByName(@Param("name") String name);

    /**
     * 根据用户名分页查询
     * @param name
     * @return
     */
    List<SysUser> findPageByName(@Param("name") String name);

    /**
     * 根据用户名和邮件分页查询
     * @param name
     * @param email
     * @return
     */
    List<SysUser> findPageByNameAndEmail(@Param("name") String name, @Param("email") String email);
}