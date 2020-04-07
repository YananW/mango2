package com.mly.mango.admin.model;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@ToString
public class SysUser extends BaseModel {

    private String name;

    private String nickName;

    private String avatar;

    private String password;

    private String salt;

    private String email;

    private String mobile;

    private Byte status;

    private Long deptId;

    private Byte delFlag;

    // 非数据库字段
    private String deptName;
    // 非数据库字段
    private String roleNames;
    // 非数据库字段
    private List<SysUserRole> userRoles = new ArrayList<>();
}