package com.ljz.myblog_admin.config.security;

import cn.hutool.json.JSONUtil;
import com.ljz.myblog_admin.vo.ResultData;
import com.ljz.myblog_admin.vo.ReturnCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName : RestAuthenticationEntryPoint
 * @Description : 当未登录或者token失效访问接口时，自定义的返回结果
 * @Author : ljz
 * @Date: 2022/7/15  19:34
 */
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONUtil.parse(ResultData.fail(ReturnCode.RC401.getCode(), ReturnCode.RC401.getMessage())));
        response.getWriter().flush();
    }
}
