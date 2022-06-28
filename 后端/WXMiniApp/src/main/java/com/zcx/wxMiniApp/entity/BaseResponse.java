package com.zcx.wxMiniApp.entity;

import lombok.Data;

@Data
public class BaseResponse<T> {

    private Integer code;
    private String message;
    private T data;

}
