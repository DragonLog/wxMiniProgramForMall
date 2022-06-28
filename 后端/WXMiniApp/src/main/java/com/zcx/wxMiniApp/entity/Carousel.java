package com.zcx.wxMiniApp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("carousel")
public class Carousel {

    @TableId(value = "carousel_id", type = IdType.AUTO)
    private Integer carouselId;

    @TableField("title")
    private String title;

    @TableField("url")
    private String url;

}
