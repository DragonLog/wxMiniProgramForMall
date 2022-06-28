package com.zcx.wxMiniApp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
@TableName("comment")
public class Comment {

    @TableId(value = "comment_id", type = IdType.AUTO)
    private Integer commentId;

    @TableField("content")
    private String content;

    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @TableField("score")
    private Integer score;

    @TableField("user_image_url")
    private String userImageUrl;

    @TableField("nickname")
    private String nickname;

    @TableField("comment_image_url")
    private String commentImageUrl;

}
