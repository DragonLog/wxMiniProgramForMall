package com.zcx.wxMiniApp.controller;

import com.zcx.wxMiniApp.entity.BaseResponse;
import com.zcx.wxMiniApp.entity.Carousel;
import com.zcx.wxMiniApp.mapper.CarouselMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/carousel")
public class CarouselController {

    @Resource
    private CarouselMapper carouselMapper;

    @GetMapping("/searchAll")
    @ResponseBody
    public BaseResponse<List<Carousel>> searchAll() {
        BaseResponse<List<Carousel>> baseResponse = new BaseResponse<List<Carousel>>();
        List<Carousel> carousels = carouselMapper.selectList(null);
        baseResponse.setCode(200);
        baseResponse.setMessage("查询成功");
        baseResponse.setData(carousels);
        return baseResponse;
    }

}
