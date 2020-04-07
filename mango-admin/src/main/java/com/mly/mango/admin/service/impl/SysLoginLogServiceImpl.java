package com.mly.mango.admin.service.impl;

import com.mly.mango.admin.mapper.SysLoginLogMapper;
import com.mly.mango.admin.model.SysLoginLog;
import com.mly.mango.admin.service.SysLoginLogService;
import com.mly.mango.core.page.MyBatisPageHelper;
import com.mly.mango.core.page.PageRequest;
import com.mly.mango.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wyn
 * @Description 登录日志实现类
 * @date 2020-04-05 19:17
 */
@Service
public class SysLoginLogServiceImpl implements SysLoginLogService {


    @Autowired
    private SysLoginLogMapper sysLoginLogMapper;


    /**
     * 保存登录日志
     * @param record
     * @return
     */
    @Override
    public int save(SysLoginLog record) {
        if(record.getId()==null || record.getId() ==0){
            return sysLoginLogMapper.insertSelective(record);
        }
        return sysLoginLogMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 删除登录日志
     * @param record
     * @return
     */
    @Override
    public int delete(SysLoginLog record) {
        return sysLoginLogMapper.deleteByPrimaryKey(record.getId());
    }

    /**
     * 批量删除数据
     * @param records
     * @return
     */
    @Override
    public int delete(List<SysLoginLog> records) {
        for (SysLoginLog record :
                records) {
            delete(record);

        }
        return 1;
    }

    @Override
    public SysLoginLog findById(Long id) {
        return sysLoginLogMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页查询
     * @param pageRequest 自定义，统一分页查询请求
     * @return
     */
    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object username = pageRequest.getParam("username");
        if(username!=null){
            return MyBatisPageHelper.findPage(pageRequest,sysLoginLogMapper,"findPageByUserName",username);
        }

        Object status = pageRequest.getParam("status");
        if(status!=null){
            return MyBatisPageHelper.findPage(pageRequest,sysLoginLogMapper,"findPageByStatus",status);
        }
        return MyBatisPageHelper.findPage(pageRequest,sysLoginLogMapper);
    }
}
