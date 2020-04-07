package com.mly.mango.core.page;

import lombok.Data;

import java.util.List;

/**
 * @author wyn
 * @Description 分页查询的结果统一封装，结果返回业务数据和分页数据
 * @date 2020-04-04 17:22
 */
@Data
public class PageResult {

    /**
     * 当前页面
     */
    private int pageNum;

    /**
     * 每页数量
     */
    private int pageSize;

    /**
     * 记录总数
     */
    private long totalSize;

    /**
     * 页码总数
     */
    private int totalPages;

    /**
     * 分页数据
     */
    private List<?> content;


}
