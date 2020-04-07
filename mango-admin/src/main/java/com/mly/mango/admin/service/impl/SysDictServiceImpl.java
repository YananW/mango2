package com.mly.mango.admin.service.impl;

import com.mly.mango.admin.mapper.SysDictMapper;
import com.mly.mango.admin.model.SysDict;
import com.mly.mango.admin.service.SysDictService;
import com.mly.mango.core.page.MyBatisPageHelper;
import com.mly.mango.core.page.PageRequest;
import com.mly.mango.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wyn
 * @Description 字典管理实现类
 * @date 2020-04-05 11:13
 */
@Service
public class SysDictServiceImpl implements SysDictService {

    @Autowired
    private SysDictMapper sysDictMapper;

    /**
     * 根据标签名称查询
     * @param label
     * @return
     */
    @Override
    public List<SysDict> findByLabel(String label) {
        return sysDictMapper.findByLabel(label);
    }

    /**
     * 保存数据
     * @param record
     * @return
     */
    @Override
    public int save(SysDict record) {

        if(record.getId() ==null ||record.getId() ==0){
            return sysDictMapper.insertSelective(record);
        }
        return sysDictMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 单个删除数据
     * @param record
     * @return
     */
    @Override
    public int delete(SysDict record) {


        return sysDictMapper.deleteByPrimaryKey(record.getId());
    }

    /**
     * 批量删除操作
     * @param records
     * @return
     */
    @Override
    public int delete(List<SysDict> records) {
        for (SysDict record :
                records) {
            delete(record);
        }
        return 1;
    }

    /**
     * 通过ID查询
     * @param id
     * @return
     */
    @Override
    public SysDict findById(Long id) {
        return sysDictMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页查询操作
     * @param pageRequest 自定义，统一分页查询请求
     * @return
     */
    @Override
    public PageResult findPage(PageRequest pageRequest) {
       Object label =  pageRequest.getParam("label");
       if(label!=null) {
           return MyBatisPageHelper.findPage(pageRequest,sysDictMapper,
                   "findPageByLabel",label);
       }
       return MyBatisPageHelper.findPage(pageRequest,sysDictMapper);
    }


}
