package com.zcx.wxMiniApp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.UnsupportedEncodingException;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Value(("${local.image.url}"))
    private String localImageUrl;

    //静态资源映射
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        try {
            localImageUrl = new String(localImageUrl.getBytes("iso8859-1"), "UTF-8");   //application.properties有中文需要转码
        } catch (UnsupportedEncodingException e) {
            System.out.println("字符转码异常！");
            e.printStackTrace();
        }
        registry.addResourceHandler("/images/**").addResourceLocations("file:" + localImageUrl);
    }
}
