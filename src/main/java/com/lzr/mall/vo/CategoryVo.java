package com.lzr.mall.vo;

import lombok.Data;

import java.util.List;

/**
 * 查询 Category 返回对象
 */

@Data
public class CategoryVo {

    private Integer id;

    private Integer parentId;

    private String name;

    private Integer sortOrder;

    private List<CategoryVo> subCategories;
}
