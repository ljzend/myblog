package com.ljz.myblog_admin.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @ClassName : MyMetaObjectHandler
 * @Description : 字段自动填充
 * @Author : ljz
 * @Date: 2022/7/4  7:22
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject, "create_time", LocalDateTime.class, LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 起始版本 3.3.0(推荐)
        this.strictUpdateFill(metaObject, "modify_time", LocalDateTime.class, LocalDateTime.now());
    }
}
