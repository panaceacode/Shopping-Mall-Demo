package com.lzr.mall.service.impl;

import com.lzr.mall.MallApplicationTests;
import com.lzr.mall.enums.ResponseEnum;
import com.lzr.mall.service.ICategoryService;
import com.lzr.mall.vo.CategoryVo;
import com.lzr.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class CategoryServiceImplTest extends MallApplicationTests {

    @Autowired
    private ICategoryService categoryService;

    @Test
    public void selectAll() {
        ResponseVo<List<CategoryVo>> responseVo = categoryService.selectAll();
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}