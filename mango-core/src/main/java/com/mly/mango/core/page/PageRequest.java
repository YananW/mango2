package com.mly.mango.core.page;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wyn
 * @Description 分页请求的参数进行了统一封装，传入分页查询的页码和数量即可
 * @date 2020-04-04 17:22
 */
@Data
public class PageRequest {

    /**
     * 当前页码
     */
    private int pageNum  =1;

    /**
     * 每页数量
     */
    private int pageSize = 10;

    /**
     * 查询参数
     */
    private Map<String,Object> params = new HashMap<>();

    public Object getParam(String key) {
        return getParams().get(key);
    }
}
