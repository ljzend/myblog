package com.ljz.myblog_admin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("t_article_tag")
@ApiModel(value = "ArticleTag对象", description = "")
public class ArticleTag implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("文章id")
    @TableField("article_id")
    private Long articleId;

    @ApiModelProperty("标签id")
    @TableField("tag_id")
    private Long tagId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }
    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return "ArticleTag{" +
            "id=" + id +
            ", articleId=" + articleId +
            ", tagId=" + tagId +
        "}";
    }
}
