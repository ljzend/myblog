package com.ljz.myblog_admin.dto;

import com.ljz.myblog_admin.pojo.Menu;
import com.ljz.myblog_admin.pojo.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * @ClassName : MenuDTO
 * @Description : menu 数据返回对象
 * @Author : ljz
 * @Date: 2022/7/16  9:00
 */

public class MenuDTO extends Menu {
    private List<MenuDTO> children = new ArrayList<>();

    private List<Role> roles;

    public List<MenuDTO> getChildren() {
        return children;
    }

    public void setChildren(List<MenuDTO> children) {
        this.children = children;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuDTO menuDTO = (MenuDTO) o;
        return Objects.equals(children, menuDTO.children) && Objects.equals(roles, menuDTO.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(children, roles);
    }
}
