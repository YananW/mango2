package com.mly.mango.admin.service.impl;

import com.mly.mango.admin.mapper.SysConfigMapper;
import com.mly.mango.admin.model.SysConfig;
import com.mly.mango.admin.service.SysConfigSercice;
import com.mly.mango.core.page.MyBatisPageHelper;
import com.mly.mango.core.page.PageRequest;
import com.mly.mango.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wyn
 * @Description 系统配置实现类
 * @date 2020-04-05 17:41
 */
@Service
public class SysConfigServiceImpl implements SysConfigSercice {



    @Autowired
    private SysConfigMapper sysConfigMapper;

    /**
     * 保存系统配置信息
     * @param record
     * @return
     */
    @Override
    public int save(SysConfig record) {
        if(record.getId()==null || record.getId()==0){
            return sysConfigMapper.insertSelective(record);
        }
        return sysConfigMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 删除系统配置
     * @param record
     * @return
     */
    @Override
    public int delete(SysConfig record) {
        return sysConfigMapper.deleteByPrimaryKey(record.getId());
    }

    /**
     * 批量删除系统配置
     * @param records
     * @return
     */
    @Override
    public int delete(List<SysConfig> records) {
        for (SysConfig record :
                records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysConfig findById(Long id) {
        return sysConfigMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页查询
     * @param pageRequest 自定义，统一分页查询请求
     * @return
     */
    @Override
    public PageResult findPage(PageRequest pageRequest) {

        Object label = pageRequest.getParam("label");
        if(label!=null){
            return MyBatisPageHelper.findPage(pageRequest,sysConfigMapper,"findPageByLabel",label);
        }
        return MyBatisPageHelper.findPage(pageRequest,sysConfigMapper);
    }


    /**
     * 根据名称查询
     * @param label
     * @return
     */
    @Override
    public List<SysConfig> findByLabel(String label) {
        return sysConfigMapper.findByLabel(label);
    }
}
