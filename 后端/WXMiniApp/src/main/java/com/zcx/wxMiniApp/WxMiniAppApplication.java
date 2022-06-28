package com.zcx.wxMiniApp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zcx.wxMiniApp.mapper")
public class WxMiniAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxMiniAppApplication.class, args);
    }

}
