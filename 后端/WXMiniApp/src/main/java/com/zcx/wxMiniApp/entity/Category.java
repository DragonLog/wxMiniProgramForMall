package com.zcx.wxMiniApp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("category")
public class Category {

    @TableId(value = "category_id", type = IdType.AUTO)
    private Integer categoryId;

    @TableField("title")
    private String title;

    @TableField(exist = false)
    private List<Good> goods;

}
