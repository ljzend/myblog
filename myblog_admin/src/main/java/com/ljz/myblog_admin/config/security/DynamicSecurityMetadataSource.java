package com.ljz.myblog_admin.config.security;

import com.ljz.myblog_admin.dto.MenuDTO;
import com.ljz.myblog_admin.pojo.Role;
import com.ljz.myblog_admin.service.MenuService;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @ClassName : DynamicSecurityMetadataSource
 * @Description : 动态权限数据源，用于获取动态权限规则
 * @Author : ljz
 * @Date: 2022/7/16  15:35
 */

public class DynamicSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Resource
    private MenuService menuService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        PathMatcher pathMatcher = new AntPathMatcher();
        //获取当前访问的路径
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        List<MenuDTO> menuDTOWithRoles = menuService.getMenusWithRole();
        for (MenuDTO menuDTOWithRole : menuDTOWithRoles) {
            if (pathMatcher.match(menuDTOWithRole.getUrl(), requestUrl)) {
                String[] str = menuDTOWithRole.getRoles().stream().map(Role::getName).toArray(String[]::new);
                return SecurityConfig.createList(str);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
