package com.zcx.wxMiniApp.controller;

import com.zcx.wxMiniApp.entity.BaseResponse;
import com.zcx.wxMiniApp.entity.User;
import com.zcx.wxMiniApp.mapper.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/searchByTelAndNickname")
    @ResponseBody
    public BaseResponse<List<User>> searchByTelAndNickname(String tel, String nickname) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("tel", tel);
        param.put("nickname", nickname);
        List<User> users = userMapper.selectByMap(param);
        BaseResponse<List<User>> baseResponse = new BaseResponse<List<User>>();
        baseResponse.setCode(200);
        baseResponse.setMessage("查询成功");
        baseResponse.setData(users);
        return baseResponse;
    }

    @PostMapping("/add")
    @ResponseBody
    public BaseResponse<User> add(@RequestBody User user) {
        BaseResponse<User> baseResponse = new BaseResponse<User>();
        userMapper.insert(user);
        baseResponse.setCode(200);
        baseResponse.setMessage("插入成功");
        baseResponse.setData(user);
        return baseResponse;
    }

}
