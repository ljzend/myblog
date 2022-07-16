package com.ljz.myblog_admin.config.security;

import cn.hutool.core.util.StrUtil;
import com.ljz.myblog_admin.utils.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName : JwtAuthenticationTokenFilter
 * @Description : JWT登录授权过滤器
 * @Author : ljz
 * @Date: 2022/7/15  21:01
 */

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    private static final Logger LOGGER  = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);
    @Resource
    private UserDetailsService userDetailsService;
    @Resource
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        // 从 请求头中获取 token
        String authHeader = request.getHeader(tokenHeader);
        // token 不为空 且以 toekenHead 开头
        if (StrUtil.isNotBlank(authHeader) && authHeader.startsWith(tokenHead)) {
            // 去掉 token 的前缀
            String authToken = authHeader.substring(tokenHead.length() + 1);
            // 从 token 中获取 用户名
            String username = jwtTokenUtil.getUserNameFromToken(authToken);
            // token 未过期，但 SecurityContextHolder 内容为空
            LOGGER.info("checking username ==> {}", username);
            if (StrUtil.isNotBlank(username) && SecurityContextHolder.getContext().getAuthentication() == null) {
                // 重新登录
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                if(jwtTokenUtil.validateToken(authToken, userDetails)){
                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    LOGGER.info("authenticated user ==> {}", username);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
