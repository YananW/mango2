package com.mly.mango.admin.service.impl;

import com.mly.mango.admin.constant.SysConstants;
import com.mly.mango.admin.mapper.SysMenuMapper;
import com.mly.mango.admin.model.SysMenu;
import com.mly.mango.admin.service.SysMenuService;
import com.mly.mango.core.page.PageRequest;
import com.mly.mango.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wyn
 * @Description 菜单管理实现类
 * @date 2020-04-05 16:52
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    /**
     * 保存菜单信息
     * @param record
     * @return
     */
    @Override
    public int save(SysMenu record) {
        if(record.getId() ==null || record.getId() ==0){
            return sysMenuMapper.insertSelective(record);
        }
        if(record.getParentId()==null) {
            record.setParentId(0L);
        }
        return sysMenuMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 单个删除菜单信息
     * @param record
     * @return
     */
    @Override
    public int delete(SysMenu record) {
        return sysMenuMapper.deleteByPrimaryKey(record.getId());
    }

    /**
     * 批量删除菜单信息
     * @param records
     * @return
     */
    @Override
    public int delete(List<SysMenu> records) {

        for (SysMenu record :
                records) {
            delete(record);
        }

        return 1;
    }

    @Override
    public SysMenu findById(Long id) {
        return null;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return null;
    }

    /**
     * 查询菜单树,用户ID和用户名为空则查询全部
     * @param userName
     * @param menuType  获取菜单类型，0：获取所有菜单，包含按钮，1：获取所有菜单，不包含按钮
     * @return
     */
    @Override
    public List<SysMenu> findTree(String userName, int menuType) {
        List<SysMenu> sysMenus = new ArrayList<>();
        List<SysMenu> menus = findByUser(userName);
        for (SysMenu menu:
             menus) {
            if(menu.getParentId() == null || menu.getParentId() ==0){
                menu.setLevel(0);
                if(!exists(sysMenus,menu)){
                    sysMenus.add(menu);
                }
            }

        }
        sysMenus.sort((o1,o2)->o1.getOrderNum().compareTo(o2.getOrderNum()));

        findChildren(sysMenus, menus, menuType);
        return sysMenus;
    }

    private void findChildren(List<SysMenu> sysMenus, List<SysMenu> menus, int menuType) {
        for (SysMenu SysMenu : sysMenus) {
            List<SysMenu> children = new ArrayList<>();
            for (SysMenu menu : menus) {
                if (menuType == 1 && menu.getType() == 2) {
                    // 如果是获取类型不需要按钮，且菜单类型是按钮的，直接过滤掉
                    continue;
                }
                if (SysMenu.getId() != null && SysMenu.getId().equals(menu.getParentId())) {
                    menu.setParentName(SysMenu.getName());
                    menu.setLevel(SysMenu.getLevel() + 1);
                    if (!exists(children, menu)) {
                        children.add(menu);
                    }
                }
            }
            SysMenu.setChildren(children);
            children.sort((o1, o2) -> o1.getOrderNum().compareTo(o2.getOrderNum()));
            findChildren(children, menus, menuType);
        }
    }

    /**
     *通过用户名查询菜单信息
     * @param userName
     * @return
     */
    @Override
    public List<SysMenu> findByUser(String userName) {
        if(userName == null || "".equals(userName) || SysConstants.ADMIN.equalsIgnoreCase(userName)){

            return sysMenuMapper.findAll();
        }

        return sysMenuMapper.findByUserName(userName);
    }

    private boolean exists(List<SysMenu> sysMenus, SysMenu sysMenu) {
        boolean exist = false;
        for(SysMenu menu:sysMenus) {
            if(menu.getId().equals(sysMenu.getId())) {
                exist = true;
            }
        }
        return exist;
    }
}
