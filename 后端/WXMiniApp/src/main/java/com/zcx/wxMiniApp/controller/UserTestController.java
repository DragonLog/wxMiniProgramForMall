package com.zcx.wxMiniApp.controller;

import com.zcx.wxMiniApp.entity.BaseResponse;
import com.zcx.wxMiniApp.entity.UserTest;
import com.zcx.wxMiniApp.mapper.UserTestMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 逻辑简单追求效率直接controller调mapper，不走service了
 */
@Controller
@RequestMapping("/userTest")
public class UserTestController {

    @Resource
    private UserTestMapper userTestMapper;

    @PostMapping("/add")
    @ResponseBody
    public BaseResponse<UserTest> add(@RequestBody UserTest userTest) {
        BaseResponse<UserTest> baseResponse = new BaseResponse<UserTest>();
        userTestMapper.insert(userTest);
        baseResponse.setCode(200);
        baseResponse.setMessage("插入成功");
        baseResponse.setData(userTest);
        return baseResponse;
    }

    @GetMapping("/searchAll")
    @ResponseBody
    public BaseResponse<List<UserTest>> searchAll() throws InterruptedException {
        BaseResponse<List<UserTest>> baseResponse = new BaseResponse<List<UserTest>>();
        List<UserTest> userTests = userTestMapper.selectList(null);
        baseResponse.setCode(200);
        baseResponse.setMessage("查询成功");
        baseResponse.setData(userTests);
        Thread.sleep(5000); //测试加载窗口
        return baseResponse;
    }

    @PutMapping("/change")
    @ResponseBody
    public BaseResponse<UserTest> change(@RequestBody UserTest userTest) {
        BaseResponse<UserTest> baseResponse = new BaseResponse<UserTest>();
        userTestMapper.updateById(userTest);
        baseResponse.setCode(200);
        baseResponse.setMessage("更新成功");
        baseResponse.setData(userTest);
        return baseResponse;
    }

    @DeleteMapping("/remove/{userId}")
    @ResponseBody
    public BaseResponse<UserTest> remove(@PathVariable("userId") int userId) {
        BaseResponse<UserTest> baseResponse = new BaseResponse<UserTest>();
        userTestMapper.deleteById(userId);
        baseResponse.setCode(200);
        baseResponse.setMessage("删除成功");
        return baseResponse;
    }
}
