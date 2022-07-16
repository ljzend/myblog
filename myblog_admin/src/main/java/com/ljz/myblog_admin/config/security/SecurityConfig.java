package com.ljz.myblog_admin.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * @ClassName : SecurityConfig
 * @Description :
 * @Author : ljz
 * @Date: 2022/7/15  19:16
 */
@Configuration
public class SecurityConfig {
    @Resource
    private IgnoreUrlsConfig ignoreUrlsConfig;
    @Resource
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    @Resource
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    @Resource
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry =
                httpSecurity.authorizeRequests();

        // //不需要保护的资源路径允许访问
        for (String url : ignoreUrlsConfig.getUrls()) {
            registry.antMatchers(url).permitAll();
        }

        //允许跨域请求的OPTIONS请求
        registry.antMatchers(HttpMethod.OPTIONS)
                .permitAll();
        httpSecurity.csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();

        // 禁用缓存
        httpSecurity.headers().cacheControl();
        // 添加JWT filter
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        //添加自定义未授权和未登录结果返回
        httpSecurity.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthenticationEntryPoint);
        return httpSecurity.build();
    }
}
