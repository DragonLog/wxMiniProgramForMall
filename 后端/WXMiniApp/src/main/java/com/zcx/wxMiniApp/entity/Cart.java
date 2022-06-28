package com.zcx.wxMiniApp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("cart")
public class Cart {

    @TableId(value = "cart_id", type = IdType.AUTO)
    private Integer cartId;

    @TableField("tel")
    private String tel;

    @TableField("nickname")
    private String nickname;

    @TableField("good_id")
    private Integer goodId;

    @TableField("number")
    private Integer number;

    @TableField("checked")
    private Boolean checked;

    @TableField(exist = false)
    private Good good;

}
