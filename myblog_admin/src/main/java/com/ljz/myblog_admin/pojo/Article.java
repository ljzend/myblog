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
 * @since 2022-07-15 16-40-16
 */
@TableName("t_article")
@ApiModel(value = "Article对象", description = "")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("文章id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("文章简介")
    @TableField("summary")
    private String summary;

    @ApiModelProperty("文章标题")
    @TableField("title")
    private String title;

    @ApiModelProperty("浏览数量")
    @TableField("view_count")
    private Integer viewCount;

    @ApiModelProperty("文章是否置顶(0不置顶，1置顶)")
    @TableField("weight")
    private Boolean weight;

    @ApiModelProperty("文章创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("文章更新时间")
    @TableField(value = "modify_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifyTime;

    @ApiModelProperty("逻辑删除(0未删除，1删除)")
    @TableField("deleted")
    @TableLogic
    private Boolean deleted;

    @ApiModelProperty("分类id")
    @TableField("category_id")
    private Long categoryId;

    @ApiModelProperty("用户id")
    @TableField("user_id")
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }
    public Boolean getWeight() {
        return weight;
    }

    public void setWeight(Boolean weight) {
        this.weight = weight;
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
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Article{" +
            "id=" + id +
            ", summary=" + summary +
            ", title=" + title +
            ", viewCount=" + viewCount +
            ", weight=" + weight +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
            ", deleted=" + deleted +
            ", categoryId=" + categoryId +
            ", userId=" + userId +
        "}";
    }
}
