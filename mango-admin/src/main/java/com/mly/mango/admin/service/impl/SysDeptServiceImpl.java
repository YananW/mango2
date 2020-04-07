package com.mly.mango.admin.service.impl;

import com.mly.mango.admin.mapper.SysDeptMapper;
import com.mly.mango.admin.mapper.SysDictMapper;
import com.mly.mango.admin.model.SysDept;
import com.mly.mango.admin.service.SysDeptService;
import com.mly.mango.core.page.MyBatisPageHelper;
import com.mly.mango.core.page.PageRequest;
import com.mly.mango.core.page.PageResult;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wyn
 * @Description 机构管理实现类
 * @date 2020-04-05 17:21
 */
@Service
public class SysDeptServiceImpl implements SysDeptService {

    @Autowired
    private SysDeptMapper sysDeptMapper;

    /**
     * 保存机构信息
     * @param record
     * @return
     */
    @Override
    public int save(SysDept record) {

    if(record.getId() ==null || record.getId() ==0){
        return sysDeptMapper.insertSelective(record);
    }
        return sysDeptMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 单个删除机构信息
     * @param record
     * @return
     */
    @Override
    public int delete(SysDept record) {
        return sysDeptMapper.deleteByPrimaryKey(record.getId());
    }

    /**
     * 批量删除机构信息
     * @param records
     * @return
     */
    @Override
    public int delete(List<SysDept> records) {
        for (SysDept record :
                records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysDept findById(Long id) {
        return sysDeptMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MyBatisPageHelper.findPage(pageRequest,sysDeptMapper);
    }

    /**
     * 查询机构树
     * @return
     */
    @Override
    public List<SysDept> findTree() {
        List<SysDept> sysDepts = new ArrayList<>();
        List<SysDept> depts = sysDeptMapper.finAll();
        for (SysDept dept : depts) {
            if (dept.getParentId() == null || dept.getParentId() == 0) {
                dept.setLevel(0);
                sysDepts.add(dept);
            }
        }
        findChildren(sysDepts, depts);

        return sysDepts;
    }

    private void findChildren(List<SysDept> sysDepts, List<SysDept> depts) {
        for (SysDept sysDept : sysDepts) {
            List<SysDept> children = new ArrayList<>();
            for (SysDept dept : depts) {
                if (sysDept.getId() != null && sysDept.getId().equals(dept.getParentId())) {
                    dept.setParentName(dept.getName());
                    dept.setLevel(sysDept.getLevel() + 1);
                    children.add(dept);
                }
            }
            sysDept.setChildren(children);
            findChildren(children, depts);
        }
    }
}
