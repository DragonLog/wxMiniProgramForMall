package com.zcx.wxMiniApp.controller;

import com.zcx.wxMiniApp.entity.BaseResponse;
import com.zcx.wxMiniApp.entity.Comment;
import com.zcx.wxMiniApp.mapper.CommentMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentMapper commentMapper;

    @GetMapping("/searchAll")
    @ResponseBody
    public BaseResponse<List<Comment>> searchAll() {
        List<Comment> comments = commentMapper.selectList(null);
        BaseResponse<List<Comment>> baseResponse = new BaseResponse<List<Comment>>();
        baseResponse.setMessage("查询成功");
        baseResponse.setData(comments);
        baseResponse.setCode(200);
        return baseResponse;
    }

}
