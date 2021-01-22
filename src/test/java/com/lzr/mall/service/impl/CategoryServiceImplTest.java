package com.lzr.mall.service.impl;

import com.lzr.mall.MallApplicationTests;
import com.lzr.mall.enums.ResponseEnum;
import com.lzr.mall.service.ICategoryService;
import com.lzr.mall.vo.CategoryVo;
import com.lzr.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class CategoryServiceImplTest extends MallApplicationTests {

    @Autowired
    private ICategoryService categoryService;

    @Test
    public void selectAll() {
        ResponseVo<List<CategoryVo>> responseVo = categoryService.selectAll();
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void findSubcategoryId() {
        Set<Integer> set = new HashSet<>();
        categoryService.findSubcategoryId(100001, set);
        log.info("set={}", set);
    }
}