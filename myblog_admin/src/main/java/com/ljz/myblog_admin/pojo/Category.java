package com.ljz.myblog_admin.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author ljz
 * @since 2022-07-15 16-40-17
 */
@TableName("t_category")
@ApiModel(value = "Category对象", description = "")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("文章分类id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("分类的图标")
    @TableField("avatar")
    private String avatar;

    @ApiModelProperty("分类名称")
    @TableField("category_name")
    private String categoryName;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("注册时间")
    @TableField(value = "modify_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifyTime;

    @ApiModelProperty("逻辑删除(0未删除，1删除)")
    @TableField("deleted")
    @TableLogic
    private Boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
        return "Category{" +
            "id=" + id +
            ", avatar=" + avatar +
            ", categoryName=" + categoryName +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
            ", deleted=" + deleted +
        "}";
    }
}
