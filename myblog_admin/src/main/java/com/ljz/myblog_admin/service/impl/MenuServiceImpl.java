package com.ljz.myblog_admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljz.myblog_admin.dto.MenuDTO;
import com.ljz.myblog_admin.mapper.MenuMapper;
import com.ljz.myblog_admin.pojo.User;
import com.ljz.myblog_admin.service.MenuService;
import com.ljz.myblog_admin.vo.ReturnCode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ljz
 * @since 2022-07-15 16-40-17
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, com.ljz.myblog_admin.pojo.Menu> implements MenuService {
    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<MenuDTO> getMenusByUserId() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (ObjectUtils.isEmpty(principal)) {
            throw new RuntimeException(ReturnCode.RC205.getMessage());
        }
        User user = (User) principal;
        List<MenuDTO> menus = menuMapper.getMenusByUserId(user.getId());
        return formatTree(menus);
    }

    /**
     * 将查询出来的菜单转出树状
     * @param menus
     * @return
     */
    private List<MenuDTO> formatTree(List<MenuDTO> menus) {
        List<MenuDTO> rootMenuDTOs = new ArrayList<>();
        menus.forEach(menu -> {
            if (menu.getParentId() == 0) {
                rootMenuDTOs.add(menu);
            }
        });
        for (MenuDTO rootMenuDTO : rootMenuDTOs) {
            rootMenuDTO.setChildren(getChildren(rootMenuDTO.getId(), menus));
        }
        return rootMenuDTOs;
    }

    /**
     * 遍历设置子菜单
     * @param id
     * @param menus
     * @return
     */
    private List<MenuDTO> getChildren(Long id, List<MenuDTO> menus) {
        List<MenuDTO> childrenMenuDTOs = new ArrayList<>();
        menus.forEach(menu -> {
            if(menu.getParentId() == id){
                childrenMenuDTOs.add(menu);
            }
        });
        for (MenuDTO childrenMenuDTO : childrenMenuDTOs){
            childrenMenuDTO.setChildren(getChildren(childrenMenuDTO.getId(), menus));
        }
        return childrenMenuDTOs;
    }

}
