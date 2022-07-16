package com.ljz.myblog_admin.common;

/**
 * @ClassName : SystemCommon
 * @Description : 常量
 * @Author : ljz
 * @Date: 2022/7/15  21:03
 */

public class SystemCommon {
    /**
     * 返回 token 中的 map 的 key
     */
    public static final String TOKEN = "token";

    /**
     * redis 中的存储 登录用户的 menu 的 key 前缀
     */
    public static final String REDIS_MENU_PREFIX = "cache:menu:";
}
