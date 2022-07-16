package com.ljz.myblog_admin.controller;

import com.ljz.myblog_admin.dto.MenuDTO;
import com.ljz.myblog_admin.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ljz
 * @since 2022-07-15 16-40-17
 */
@RestController
@RequestMapping("/menu")
@Api(tags = "菜单控制类(MenuController)")
public class MenuController {
    @Resource
    private MenuService menuService;

    @ApiOperation("根据登录用户id查询菜单")
    @GetMapping("/list")
    public List<MenuDTO> getMenusByUserId(){
        return menuService.getMenusByUserId();
    }
}
