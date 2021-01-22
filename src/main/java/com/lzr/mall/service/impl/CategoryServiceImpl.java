package com.lzr.mall.service.impl;

import com.lzr.mall.consts.MallConst;
import com.lzr.mall.dao.CategoryMapper;
import com.lzr.mall.pojo.Category;
import com.lzr.mall.service.ICategoryService;
import com.lzr.mall.vo.CategoryVo;
import com.lzr.mall.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 耗时：http(请求微信api) > 磁盘 > 内存
     * mysql(内网+磁盘)
     *
     * @return
     */
    @Override
    public ResponseVo<List<CategoryVo>> selectAll() {

        List<Category> categories = categoryMapper.selectAll();

        // lambda + stream
        // 慎用for循环查sql等工作
        List<CategoryVo> categoryVoList = categories.stream()
                .filter(e -> e.getParentId().equals(MallConst.ROOT_PARENT_ID))
                .map(this::transform)
                .sorted(Comparator.comparing(CategoryVo::getSortOrder).reversed())
                .collect(Collectors.toList());

        // 查询子目录
        findSubcategories(categoryVoList, categories);

        return ResponseVo.success(categoryVoList);
    }

    private CategoryVo transform(Category category) {
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category, categoryVo);
        return categoryVo;
    }

    private void findSubcategories(List<CategoryVo> categoryVoList, List<Category> categoryList) {
        for (CategoryVo categoryVo : categoryVoList) {
            List<CategoryVo> subcategoriesVoList = new ArrayList<>();

            // 如果查到内容，设置subcategory，继续往下查
            for (Category category : categoryList) {
                if (categoryVo.getId().equals(category.getParentId())) {
                    CategoryVo subcategoryVo = transform(category);
                    subcategoriesVoList.add(subcategoryVo);
                }

                subcategoriesVoList.sort(Comparator.comparing(CategoryVo::getSortOrder).reversed());

                categoryVo.setSubCategories(subcategoriesVoList);

                findSubcategories(subcategoriesVoList, categoryList);
            }
        }
    }

    @Override
    public void findSubcategoryId(Integer id, Set<Integer> resultSet) {
        List<Category> categoryList = categoryMapper.selectAll();
        findSubcategoryId(id, resultSet, categoryList);
    }

    private void findSubcategoryId(Integer id, Set<Integer> resultSet, List<Category> categoryList) {
        for (Category category : categoryList) {
            if (category.getParentId().equals(id)) {
                resultSet.add(category.getId());
                findSubcategoryId(category.getId(), resultSet, categoryList);
            }
        }
    }
}
