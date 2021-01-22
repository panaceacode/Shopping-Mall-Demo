package com.lzr.mall.service;

import com.github.pagehelper.PageInfo;
import com.lzr.mall.vo.ProductDetailVo;
import com.lzr.mall.vo.ResponseVo;

public interface IProductService {

    ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);

    ResponseVo<ProductDetailVo> detail(Integer productId);
}
