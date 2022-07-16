package com.ljz.myblog_admin.service;

import com.ljz.myblog_admin.pojo.Role;
import com.ljz.myblog_admin.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ljz
 * @since 2022 -07-15 16-40-17
 */
public interface UserService extends IService<User> {

    /**
     * Login map.
     * 用户登录后返回token
     * @param username the username
     * @param password the password
     * @return the map
     */
    Map<String, Object> login(String username, String password);

    /**
     * Load user by username user.
     * 重写 userDetailsService 中的 loadUserByUsername 方法
     * @param username the username
     * @return the user
     */
    User loadUserByUsername(String username);

    /**
     * Gets roles.
     * 根据用户 id 获取角色
     * @param id the id
     * @return the roles
     */
    List<Role> getRoles(Long id);
}
