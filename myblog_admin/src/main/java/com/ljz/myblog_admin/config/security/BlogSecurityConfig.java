package com.ljz.myblog_admin.config.security;

import com.ljz.myblog_admin.pojo.User;
import com.ljz.myblog_admin.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * @ClassName : BlogSecurityConfig
 * @Description :
 * @Author : ljz
 * @Date: 2022/7/15  19:57
 */
@Configuration
public class BlogSecurityConfig {
    @Resource
    private UserService userService;

    @Bean("userDetailsService")
    public UserDetailsService userDetailsService(){
        return username -> {
            User user = userService.loadUserByUsername(username);
            if(!ObjectUtils.isEmpty(user)){
                return user;
            }
            throw new UsernameNotFoundException("用户名或密码错误");
        };
    }
}
