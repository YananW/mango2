package com.mly.mango.core.page;

import com.github.pagehelper.PageInfo;
import com.mly.mango.utils.ReflectionUtils;

import java.util.List;

/**
 * @author wyn
 * @Description 分页查询助手
 * @date 2020-04-04 17:22
 */
public class MyBatisPageHelper {

    private static final String findPage = "findPage";

    /**
     * 分页查询，约定查询方法名为“findPage”
     * @param pageRequest 分页请求的参数
     * @param mapper DAO对象，Mybatis的mapper
     * @return
     */
    public static PageResult findPage(PageRequest pageRequest,Object mapper) {
        return findPage(pageRequest,mapper,findPage);
    }

    /**
     * 调用分页插件进行分页查询
     * @param pageRequest 分页请求的参数
     * @param mapper DAO对象，Mybatis的mapper
     * @param queryMethodName 要分页的查询方法名
     * @param args 方法参数
     * @return
     */
    @SuppressWarnings({"uncheched","rawtypes"})
    public static PageResult findPage(PageRequest pageRequest,Object mapper,
                                      String queryMethodName,Object... args){

        //设置分页参数
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        
        //利用反射调用查询方法
        Object result = ReflectionUtils.invoke(mapper, queryMethodName, args);

        return getPageResult(pageRequest,new PageInfo<>((List) result));

    }

    private static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {


        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return  pageResult;
    }
}
