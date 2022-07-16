package com.ljz.myblog_admin.vo;

/**
 * @ClassName : ReturnCode
 * @Description :
 * @Author : ljz
 * @Date: 2022/7/3  16:22
 */

public enum ReturnCode {
    /**
     * 操作成功
     **/
    RC100(100, "操作成功"),
    /**
     * 操作失败
     **/
    RC999(999, "操作失败"),
    /**
     * 参数不合法
     */
    RC222(222, "参数不合法"),
    /**
     * sql错误
     */
    RC333(333, "sql错误"),
    /**
     * 业务代码出错
     */
    RC444(444, "业务代码出错"),
    /**
     * 服务限流
     **/
    RC200(200, "服务开启限流保护,请稍后再试!"),
    /**
     * 服务降级
     **/
    RC201(201, "服务开启降级保护,请稍后再试!"),
    /**
     * 热点参数限流
     **/
    RC202(202, "热点参数限流,请稍后再试!"),
    /**
     * 系统规则不满足
     **/
    RC203(203, "系统规则不满足要求,请稍后再试!"),
    /**
     * 授权规则不通过
     **/
    RC204(204, "授权规则不通过,请稍后再试!"),
    /**
     * 用户未登录
     */
    RC205(205, "用户未登录，请登录!"),
    /**
     * access_denied
     **/
    RC403(403, "无访问权限,请联系管理员授予权限"),
    /**
     * access_denied
     **/
    RC401(401, "匿名用户访问无权限资源时的异常"),
    /**
     * 服务异常
     **/
    RC500(500, "系统异常，请稍后重试"),

    INVALID_TOKEN(2001, "访问令牌不合法"),
    ACCESS_DENIED(2003, "没有权限访问该资源"),
    CLIENT_AUTHENTICATION_FAILED(1001, "客户端认证失败"),
    USERNAME_OR_PASSWORD_ERROR(1002, "用户名或密码错误"),
    UNSUPPORTED_GRANT_TYPE(1003, "不支持的认证模式");

    /**
     * 自定义状态码
     **/
    private final int code;
    /**
     * 自定义描述
     **/
    private final String message;

    ReturnCode(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}