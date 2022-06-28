package com.zcx.wxMiniApp.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcx.wxMiniApp.entity.BaseResponse;
import com.zcx.wxMiniApp.entity.Description;
import com.zcx.wxMiniApp.entity.Good;
import com.zcx.wxMiniApp.entity.Slide;
import com.zcx.wxMiniApp.mapper.DescriptionMapper;
import com.zcx.wxMiniApp.mapper.GoodMapper;
import com.zcx.wxMiniApp.mapper.SlideMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/good")
public class GoodController {

    @Resource
    private GoodMapper goodMapper;

    @Resource
    private SlideMapper slideMapper;

    @Resource
    private DescriptionMapper descriptionMapper;

    @GetMapping("/searchPage")
    @ResponseBody
    public BaseResponse<List<Good>> searchPage(int current, int size, HttpServletResponse response) {
        response.setHeader("X-Total-Count", goodMapper.selectCount(null) + ""); //模仿jsonServer
        Page<Good> page = new Page<Good>(current, size);    //分页条件
        Page<Good> goodPage = goodMapper.selectPage(page, null);
        List<Good> goods = goodPage.getRecords();
        for (Good good : goods) {
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("good_id", good.getGoodId());
            List<Slide> slideList = slideMapper.selectByMap(param);
            List<String> slides = new ArrayList<String>();
            for (Slide slide : slideList) {
                slides.add(slide.getUrl());
            }
            List<Description> descriptionList = descriptionMapper.selectByMap(param);
            List<String> descriptions = new ArrayList<String>();
            for (Description description : descriptionList) {
                descriptions.add(description.getUrl());
            }
            good.setSlides(slides);
            good.setDescriptions(descriptions);
        }
        BaseResponse<List<Good>> baseResponse = new BaseResponse<List<Good>>();
        baseResponse.setData(goods);
        baseResponse.setCode(200);
        baseResponse.setMessage("查询成功");
        return baseResponse;
    }

    @GetMapping("/search/{goodId}")
    @ResponseBody
    public BaseResponse<Good> search(@PathVariable("goodId") int goodId) {
        Good good = goodMapper.selectById(goodId);
        if (good != null) {
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("good_id", good.getGoodId());
            List<Slide> slideList = slideMapper.selectByMap(param);
            List<String> slides = new ArrayList<String>();
            for (Slide slide : slideList) {
                slides.add(slide.getUrl());
            }
            List<Description> descriptionList = descriptionMapper.selectByMap(param);
            List<String> descriptions = new ArrayList<String>();
            for(Description description : descriptionList) {
                descriptions.add(description.getUrl());
            }
            good.setSlides(slides);
            good.setDescriptions(descriptions);
        }
        BaseResponse<Good> baseResponse = new BaseResponse<Good>();
        baseResponse.setCode(200);
        baseResponse.setData(good);
        baseResponse.setMessage("查询成功");
        return baseResponse;
    }

    @GetMapping("/searchLike")
    @ResponseBody
    public BaseResponse<List<Good>> searchLike(String title){
        List<Good> goods = goodMapper.selectLike(title);
        for (Good good : goods) {
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("good_id", good.getGoodId());
            List<Slide> slideList = slideMapper.selectByMap(param);
            List<String> slides = new ArrayList<String>();
            for (Slide slide : slideList) {
                slides.add(slide.getUrl());
            }
            List<Description> descriptionList = descriptionMapper.selectByMap(param);
            List<String> descriptions = new ArrayList<String>();
            for (Description description : descriptionList) {
                descriptions.add(description.getUrl());
            }
            good.setSlides(slides);
            good.setDescriptions(descriptions);
        }
        BaseResponse<List<Good>> baseResponse = new BaseResponse<List<Good>>();
        baseResponse.setData(goods);
        baseResponse.setCode(200);
        baseResponse.setMessage("查询成功");
        return baseResponse;
    }

    @GetMapping("/searchByCategoryId/{categoryId}")
    @ResponseBody
    public BaseResponse<List<Good>> searchByCategoryId(@PathVariable("categoryId") int categoryId) {
        Map<String, Object> param1 = new HashMap<String, Object>();
        param1.put("category_id", categoryId);
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
        BaseResponse<List<Good>> baseResponse = new BaseResponse<List<Good>>();
        baseResponse.setData(goods);
        baseResponse.setCode(200);
        baseResponse.setMessage("查询成功");
        return baseResponse;
    }

}
