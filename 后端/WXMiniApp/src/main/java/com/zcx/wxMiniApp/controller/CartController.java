package com.zcx.wxMiniApp.controller;

import com.zcx.wxMiniApp.entity.BaseResponse;
import com.zcx.wxMiniApp.entity.Cart;
import com.zcx.wxMiniApp.entity.Good;
import com.zcx.wxMiniApp.mapper.CartMapper;
import com.zcx.wxMiniApp.mapper.GoodMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Resource
    private CartMapper cartMapper;

    @Resource
    private GoodMapper goodMapper;

    @GetMapping("/searchByTelAndGoodIdAndNickname")
    @ResponseBody
    public BaseResponse<List<Cart>> searchByTelAndGoodIdAndNickname(String tel, int goodId, String nickname) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("tel", tel);
        params.put("good_id", goodId);
        params.put("nickname", nickname);
        BaseResponse<List<Cart>> baseResponse = new BaseResponse<List<Cart>>();
        List<Cart> carts = cartMapper.selectByMap(params);
        baseResponse.setCode(200);
        baseResponse.setMessage("查询成功");
        baseResponse.setData(carts);
        return baseResponse;
    }

    @PostMapping("/add")
    @ResponseBody
    public BaseResponse<Cart> add(@RequestBody Cart cart) {
        BaseResponse<Cart> baseResponse = new BaseResponse<Cart>();
        cartMapper.insert(cart);
        baseResponse.setCode(200);
        baseResponse.setData(cart);
        baseResponse.setMessage("插入成功");
        return baseResponse;
    }

    @PutMapping("/change")
    @ResponseBody
    public BaseResponse<Cart> change(@RequestBody Cart cart) {
        BaseResponse<Cart> baseResponse = new BaseResponse<Cart>();
        cartMapper.updateById(cart);
        baseResponse.setCode(200);
        baseResponse.setData(cart);
        baseResponse.setMessage("更新成功");
        return baseResponse;
    }

    @GetMapping("/searchByNicknameAndTel")
    @ResponseBody
    public BaseResponse<List<Cart>> searchByNicknameAndTel(String nickname, String tel) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("nickname", nickname);
        params.put("tel", tel);
        List<Cart> carts = cartMapper.selectByMap(params);
        for(Cart cart : carts) {
            Good good = goodMapper.selectById(cart.getGoodId());
            cart.setGood(good);
        }
        BaseResponse<List<Cart>> baseResponse = new BaseResponse<List<Cart>>();
        baseResponse.setCode(200);
        baseResponse.setMessage("查询成功");
        baseResponse.setData(carts);
        return baseResponse;
    }

    @DeleteMapping("/remove/{cartId}")
    @ResponseBody
    public BaseResponse<Cart> remove(@PathVariable("cartId") int cartId) {
        BaseResponse<Cart> baseResponse = new BaseResponse<Cart>();
        cartMapper.deleteById(cartId);
        baseResponse.setCode(200);
        baseResponse.setMessage("删除成功");
        return baseResponse;
    }

    @PutMapping("/changeCheckedToFalse")
    @ResponseBody
    public BaseResponse<Cart> changeCheckedToFalse(@RequestBody Map<String, Object> params) {
        BaseResponse<Cart> baseResponse = new BaseResponse<Cart>();
        if (params.get("cartIds") != null) {
            cartMapper.updateCheckedToFalse(((List<Integer>) params.get("cartIds")).stream().mapToInt(Integer::valueOf).toArray());
        }
        baseResponse.setCode(200);
        baseResponse.setMessage("更新成功");
        return baseResponse;
    }

    @PutMapping("/changeCheckedToTrue")
    @ResponseBody
    public BaseResponse<Cart> changeCheckedToTrue(@RequestBody Map<String, Object> params) {
        BaseResponse<Cart> baseResponse = new BaseResponse<Cart>();
        if (params.get("cartIds") != null) {
            cartMapper.updateCheckedToTrue(((List<Integer>) params.get("cartIds")).stream().mapToInt(Integer::valueOf).toArray());
        }
        baseResponse.setCode(200);
        baseResponse.setMessage("更新成功");
        return baseResponse;
    }

}
