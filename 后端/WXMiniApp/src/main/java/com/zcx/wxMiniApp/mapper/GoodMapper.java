package com.zcx.wxMiniApp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zcx.wxMiniApp.entity.Good;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface GoodMapper extends BaseMapper<Good> {

    List<Good> selectLike(@Param("title") String title);

}
