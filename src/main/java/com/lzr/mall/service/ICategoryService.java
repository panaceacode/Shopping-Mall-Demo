package com.lzr.mall.service;

import com.lzr.mall.vo.CategoryVo;
import com.lzr.mall.vo.ResponseVo;

import java.util.List;

public interface ICategoryService {

    ResponseVo<List<CategoryVo>> selectAll();
}
