package com.mly.mango.admin.model;

import lombok.Data;

import java.util.Date;

/**
 * @author wyn
 * @Description
 * @date 2020-04-05 15:49
 */
@Data
public class BaseModel {
    private Long id;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;
}
