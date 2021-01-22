package com.lzr.mall.service;

import com.lzr.mall.vo.CategoryVo;
import com.lzr.mall.vo.ResponseVo;

import java.util.List;
import java.util.Set;

public interface ICategoryService {

    ResponseVo<List<CategoryVo>> selectAll();

    void findSubcategoryId(Integer id, Set<Integer> resultSet);
}
