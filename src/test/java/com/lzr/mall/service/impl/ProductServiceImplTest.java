package com.lzr.mall.service.impl;

import com.github.pagehelper.PageInfo;
import com.lzr.mall.MallApplicationTests;
import com.lzr.mall.enums.ResponseEnum;
import com.lzr.mall.service.IProductService;
import com.lzr.mall.vo.ProductDetailVo;
import com.lzr.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceImplTest extends MallApplicationTests {

    @Autowired
    private IProductService productService;

    @Test
    public void list() {
        ResponseVo<PageInfo> responseVo = productService.list(null, 2, 3);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void detail() {

        ResponseVo<ProductDetailVo> responseVo = productService.detail(26);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}