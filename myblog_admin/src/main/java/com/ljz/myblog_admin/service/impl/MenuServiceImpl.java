package com.ljz.myblog_admin.service.impl;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljz.myblog_admin.dto.MenuDTO;
import com.ljz.myblog_admin.mapper.MenuMapper;
import com.ljz.myblog_admin.pojo.Menu;
import com.ljz.myblog_admin.pojo.User;
import com.ljz.myblog_admin.service.MenuService;
import com.ljz.myblog_admin.vo.ReturnCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import static com.ljz.myblog_admin.common.SystemCommon.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ljz
 * @since 2022-07-15 16-40-17
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuServiceImpl.class);
    @Resource
    private MenuMapper menuMapper;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public List<MenuDTO> getMenusByUserId() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LOGGER.info("当前请求菜单的用户是 ==> {}", principal);
        if (ObjectUtils.isEmpty(principal)) {
            throw new RuntimeException(ReturnCode.RC205.getMessage());
        }
        User user = (User) principal;
        Object object = redisTemplate.opsForValue().get(REDIS_MENU_PREFIX + user.getId());
        LOGGER.info("从redis中获取的缓存的对应用户的菜单 ==> {}", object);
        // 如果从 redis 中获取缓存 成功
        if(!ObjectUtils.isEmpty(object)){
            redisTemplate.expire(REDIS_MENU_PREFIX + user.getId(), 1, TimeUnit.HOURS);
            JSONArray objects = JSONUtil.parseArray(JSONUtil.toJsonStr(object));
            return formatTree(JSONUtil.toList(objects, MenuDTO.class));
        }
        List<MenuDTO> menus = menuMapper.getMenusByUserId(user.getId());
        // 将用户菜单存储到 redis 中
        redisTemplate.opsForValue().set(REDIS_MENU_PREFIX + user.getId(),
                JSONUtil.toJsonStr(menus), 1, TimeUnit.HOURS);
        return formatTree(menus);
    }

    @Override
    public List<MenuDTO> getMenusWithRole() {
        return menuMapper.getMenusWithRole();
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
