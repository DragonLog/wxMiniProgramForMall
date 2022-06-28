package com.zcx.wxMiniApp.controller;

import com.zcx.wxMiniApp.entity.*;
import com.zcx.wxMiniApp.mapper.CategoryMapper;
import com.zcx.wxMiniApp.mapper.DescriptionMapper;
import com.zcx.wxMiniApp.mapper.GoodMapper;
import com.zcx.wxMiniApp.mapper.SlideMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private GoodMapper goodMapper;

    @Resource
    private SlideMapper slideMapper;

    @Resource
    private DescriptionMapper descriptionMapper;

    @GetMapping("/searchLike")
    @ResponseBody
    public BaseResponse<List<Category>> searchLike(String title) {
        List<Category> categories = categoryMapper.selectLike(title);
        BaseResponse<List<Category>> baseResponse = new BaseResponse<List<Category>>();
        baseResponse.setCode(200);
        baseResponse.setData(categories);
        baseResponse.setMessage("查询成功");
        return baseResponse;
    }

    @GetMapping("/searchAllWithGoods")
    @ResponseBody
    public BaseResponse<List<Category>> searchAllWithGoods() {
        List<Category> categories = categoryMapper.selectList(null);
        for (Category category : categories) {
            Map<String, Object> param1 = new HashMap<String, Object>();
            param1.put("category_id", category.getCategoryId());
            List<Good> goods = goodMapper.selectByMap(param1);
            for (Good good : goods) {
                Map<String, Object> param2 = new HashMap<String, Object>();
                param2.put("good_id", good.getGoodId());
                List<Slide> slideList = slideMapper.selectByMap(param2);
                List<String> slides = new ArrayList<String>();
                for (Slide slide : slideList) {
                    slides.add(slide.getUrl());
                }
                List<Description> descriptionList = descriptionMapper.selectByMap(param2);
                List<String> descriptions = new ArrayList<String>();
                for (Description description : descriptionList) {
                    descriptions.add(description.getUrl());
                }
                good.setSlides(slides);
                good.setDescriptions(descriptions);
            }
            category.setGoods(goods);
        }
        BaseResponse<List<Category>> baseResponse = new BaseResponse<List<Category>>();
        baseResponse.setMessage("查询成功");
        baseResponse.setData(categories);
        baseResponse.setCode(200);
        return baseResponse;
    }

}
