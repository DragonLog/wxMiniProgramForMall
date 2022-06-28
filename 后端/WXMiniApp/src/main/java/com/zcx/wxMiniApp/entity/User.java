package com.zcx.wxMiniApp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @TableField("nickname")
    private String nickname;

    @TableField("gender")
    private Integer gender;

    @TableField("language")
    private String language;

    @TableField("city")
    private String city;

    @TableField("province")
    private String province;

    @TableField("country")
    private String country;

    @TableField("avatar_url")
    private String avatarUrl;

    @TableField("tel")
    private String tel;

}
