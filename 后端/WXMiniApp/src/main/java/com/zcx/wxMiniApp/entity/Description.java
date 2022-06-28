package com.zcx.wxMiniApp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("description")
public class Description {

    @TableId(value = "description_id", type = IdType.AUTO)
    private Integer descriptionId;

    @TableField("url")
    private String url;

    @TableField("good_id")
    private String goodId;

}
