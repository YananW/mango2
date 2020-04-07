package com.mly.mango.admin.service.impl;

import com.mly.mango.admin.mapper.SysLogMapper;
import com.mly.mango.admin.model.SysLog;
import com.mly.mango.admin.service.SysLogService;
import com.mly.mango.core.page.MyBatisPageHelper;
import com.mly.mango.core.page.PageRequest;
import com.mly.mango.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wyn
 * @Description 日志实现类
 * @date 2020-04-05 22:37
 */
@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    /**
     * 保存数据
     * @param record
     * @return
     */
    @Override
    public int save(SysLog record) {
        if(record.getId()==null || record.getId()==0){
            return sysLogMapper.insertSelective(record);
        }
        return sysLogMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 删除数据 单个
     * @param record
     * @return
     */
    @Override
    public int delete(SysLog record) {
        return sysLogMapper.deleteByPrimaryKey(record.getId());
    }

    /**
     * 批量删除数据
     * @param records
     * @return
     */
    @Override
    public int delete(List<SysLog> records) {
        for (SysLog record :
                records) {
            delete(record);
        }
        return 1;
    }


    @Override
    public SysLog findById(Long id) {
        return sysLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object userName = pageRequest.getParam("userName");
        if(userName!=null){
            return MyBatisPageHelper.findPage(pageRequest,sysLogMapper,"findPageByUserName", userName);
        }
        return MyBatisPageHelper.findPage(pageRequest,sysLogMapper);
    }
}
