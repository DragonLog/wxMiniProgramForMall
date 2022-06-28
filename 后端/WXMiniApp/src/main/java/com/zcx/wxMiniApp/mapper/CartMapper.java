package com.zcx.wxMiniApp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zcx.wxMiniApp.entity.Cart;
import org.apache.ibatis.annotations.Param;

public interface CartMapper extends BaseMapper<Cart> {

    int updateCheckedToFalse(@Param("cartIds") int[] cartIds);

    int updateCheckedToTrue(@Param("cartIds") int[] cartIds);

}
