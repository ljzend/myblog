package com.ljz.myblog_admin.handler;

import com.ljz.myblog_admin.vo.ResultData;
import com.ljz.myblog_admin.vo.ReturnCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName : RestExceptionHandler
 * @Description :
 * @Author : ljz
 * @Date: 2022/7/3  16:29
 */

@RestControllerAdvice
public class RestExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

    /**
     * 默认全局异常处理。
     *
     * @param e the e
     * @return ResultData
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> exception(Exception e) {
        LOGGER.error("全局异常信息 ex={}", e.getMessage(), e);
        return ResultData.fail(ReturnCode.RC500.getCode(), e.getMessage());
    }

}
