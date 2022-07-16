package com.ljz.myblog_admin.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 * 
 * </p>
 *
 * @author ljz
 * @since 2022-07-15 16-40-17
 */
@TableName("t_user")
@ApiModel(value = "User对象", description = "")
public class User implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty("昵称")
    @TableField("nickname")
    private String nickname;

    @ApiModelProperty("用户头像")
    @TableField("avatar")
    private String avatar;

    @ApiModelProperty("性别")
    @TableField("gender")
    private Boolean gender;

    @ApiModelProperty("密码")
    @TableField("password")
    private String password;

    @ApiModelProperty("是否启用")
    @TableField("enable")
    private Boolean enable;

    @ApiModelProperty("邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("电话号码")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("注册时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(value = "modify_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifyTime;

    @ApiModelProperty("逻辑删除")
    @TableField("deleted")
    @TableLogic
    private Boolean deleted;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }
    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", username=" + username +
            ", nickname=" + nickname +
            ", avatar=" + avatar +
            ", gender=" + gender +
            ", password=" + password +
            ", enable=" + enable +
            ", email=" + email +
            ", phone=" + phone +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
            ", deleted=" + deleted +
        "}";
    }
}
