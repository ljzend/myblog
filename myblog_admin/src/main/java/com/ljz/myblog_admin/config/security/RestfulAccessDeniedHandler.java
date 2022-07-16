package com.ljz.myblog_admin.config.security;

import cn.hutool.json.JSONUtil;
import com.ljz.myblog_admin.vo.ResultData;
import com.ljz.myblog_admin.vo.ReturnCode;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName : RestfulAccessDeniedHandler
 * @Description : 当访问接口没有权限时，自定义的返回结果
 * @Author : ljz
 * @Date: 2022/7/15  19:33
 */
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONUtil.parse(ResultData.fail(ReturnCode.RC403.getCode(), ReturnCode.RC403.getMessage())));
        response.getWriter().flush();
    }
}
