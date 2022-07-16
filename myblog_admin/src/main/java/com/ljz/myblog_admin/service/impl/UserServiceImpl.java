package com.ljz.myblog_admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljz.myblog_admin.mapper.UserMapper;
import com.ljz.myblog_admin.pojo.Role;
import com.ljz.myblog_admin.pojo.User;
import com.ljz.myblog_admin.service.UserService;
import com.ljz.myblog_admin.utils.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ljz.myblog_admin.common.SystemCommon.TOKEN;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ljz
 * @since 2022-07-15 16-40-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Resource
    private UserMapper userMapper;
    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public Map<String, Object> login(String username, String password) {
        Map<String, Object> map = new HashMap<>();
        try {
            // 根据用户名查询用户信息
            UserDetails userDetails = loadUserByUsername(username);
            if (ObjectUtils.isEmpty(userDetails)) {
                map.put(TOKEN, "");
                return map;
            }
            // 校验密码
            if (!bCryptPasswordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            // 生成 authentication 更新 SecurityContextHolder 中的用户信息
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtTokenUtil.generateToken(userDetails);
            map.put(TOKEN, tokenHead + "_" + token);
        } catch (BadCredentialsException e) {
            LOGGER.warn(e.getMessage());
        }
        return map;
    }

    @Override
    public User loadUserByUsername(String username) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username).eq(User::getEnable, true).last("limit 1");
        User user = userMapper.selectOne(queryWrapper);
        if (!ObjectUtils.isEmpty(user)) {
            user.setRoles(getRoles(user.getId()));
            return user;
        }
        return null;
    }

    @Override
    public List<Role> getRoles(Long id) {
        return userMapper.getRoles(id);
    }
}
