package com.zcx.wxMiniApp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("slide")
public class Slide {

    @TableId(value = "slide_id", type = IdType.AUTO)
    private Integer slideId;

    @TableField("url")
    private String url;

    @TableField("good_id")
    private String goodId;

}
