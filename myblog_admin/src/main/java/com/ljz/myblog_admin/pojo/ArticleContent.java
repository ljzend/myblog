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
@TableName("t_article_content")
@ApiModel(value = "ArticleContent对象", description = "")
public class ArticleContent implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("文章内容id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("文章内容md形式")
    @TableField("content")
    private String content;

    @ApiModelProperty("文章内容html形式")
    @TableField("content_html")
    private String contentHtml;

    @ApiModelProperty("文章id")
    @TableField("article_id")
    private Long articleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getContentHtml() {
        return contentHtml;
    }

    public void setContentHtml(String contentHtml) {
        this.contentHtml = contentHtml;
    }
    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    @Override
    public String toString() {
        return "ArticleContent{" +
            "id=" + id +
            ", content=" + content +
            ", contentHtml=" + contentHtml +
            ", articleId=" + articleId +
        "}";
    }
}
