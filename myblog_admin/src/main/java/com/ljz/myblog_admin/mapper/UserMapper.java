package com.ljz.myblog_admin.mapper;

import com.ljz.myblog_admin.pojo.Role;
import com.ljz.myblog_admin.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ljz
 * @since 2022-07-15 16-40-17
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * Gets roles.
     * 根据用户 id 获取角色
     * @param id the id
     * @return the roles
     */
    List<Role> getRoles(Long id);
}
