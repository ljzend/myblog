package com.ljz.myblog_admin.controller;

import cn.hutool.core.util.StrUtil;
import com.ljz.myblog_admin.dto.MenuDTO;
import com.ljz.myblog_admin.pojo.User;
import com.ljz.myblog_admin.service.MenuService;
import com.ljz.myblog_admin.service.UserService;
import com.ljz.myblog_admin.vo.LoginParamVo;
import com.ljz.myblog_admin.vo.ReturnCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ljz
 * @since 2022-07-15 16-40-17
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户控制类(UserController)")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;
    @Resource
    private MenuService menuService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation("用户登录后返回token")
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginParamVo loginParamVo){
        LOGGER.info("登录参数为 ==> {}",loginParamVo.toString());
        // 校验参数
        if(ObjectUtils.isEmpty(loginParamVo) || StrUtil.isBlank(loginParamVo.getUsername())
                || StrUtil.isBlank(loginParamVo.getPassword())){
            throw new RuntimeException(ReturnCode.RC222.getMessage());
        }
        return userService.login(loginParamVo.getUsername(), loginParamVo.getPassword());
    }

    @ApiOperation("获取当前登录用户信息")
    @GetMapping("/info")
    public User getUserInfo(Principal principal){
        if(ObjectUtils.isEmpty(principal)){
            return null;
        }
        String username = principal.getName();
        User user = userService.loadUserByUsername(username);
        user.setPassword(null);
        user.setRoles(userService.getRoles(user.getId()));
        return user;
    }

    @ApiOperation("用户退出登录")
    @PostMapping("/logout")
    public String logout(){
        return "注销成功!";
    }

    @ApiOperation("测试")
    @GetMapping("/test")
    public List<MenuDTO> test(){
        return menuService.getMenusWithRole();
    }
}
