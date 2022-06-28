package com.zcx.wxMiniApp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zcx.wxMiniApp.entity.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper extends BaseMapper<Category> {

    List<Category> selectLike(@Param("title") String title);

}
