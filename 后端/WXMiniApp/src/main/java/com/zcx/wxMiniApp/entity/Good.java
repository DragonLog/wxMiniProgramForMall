package com.zcx.wxMiniApp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@TableName("good")
@Data
public class Good {

    @TableId(value = "good_id", type = IdType.AUTO)
    private Integer goodId;

    @TableField("title")
    private String title;

    @TableField("category_id")
    private Integer categoryId;

    @TableField("feature")
    private String feature;

    @TableField("price")
    private Integer price;

    @TableField("good_comment")
    private String goodComment;

    @TableField("poster")
    private String poster;

    @TableField(exist = false)
    private List<String> slides;

    @TableField(exist = false)
    private List<String> descriptions;
}
