package com.ljz.myblog_admin.service;

import com.ljz.myblog_admin.dto.MenuDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ljz.myblog_admin.pojo.Menu;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ljz
 * @since 2022-07-15 16-40-17
 */
public interface MenuService extends IService<Menu> {

    /**
     * Gets menus by user id.
     * 根据登录用户id查询菜单
     * @return the menus by user id
     */
    List<MenuDTO> getMenusByUserId();

    /**
     * Gets menus with role.
     * 根据角色查询菜单列表
     * @return the menus with role
     */
    List<MenuDTO> getMenusWithRole();
}
