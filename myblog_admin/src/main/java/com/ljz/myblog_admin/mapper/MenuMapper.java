package com.ljz.myblog_admin.mapper;

import com.ljz.myblog_admin.dto.MenuDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ljz.myblog_admin.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ljz
 * @since 2022-07-15 16-40-17
 */
@Mapper
public interface MenuMapper extends BaseMapper<com.ljz.myblog_admin.pojo.Menu> {

    /**
     * Gets menus by user id.
     * 根据登录用户id查询菜单
     * @param id the id
     * @return the menus by user id
     */
    List<MenuDTO> getMenusByUserId(Long id);

    /**
     * Gets menus with role.
     * 根据角色查询菜单列表
     * @return the menus with role
     */
    List<MenuDTO> getMenusWithRole();
}
