package com.lzr.mall.service;

import com.lzr.mall.form.CartAddForm;
import com.lzr.mall.form.CartUpdateForm;
import com.lzr.mall.vo.CartVo;
import com.lzr.mall.vo.ResponseVo;

public interface ICartService {

    ResponseVo<CartVo> add(Integer uid, CartAddForm form);

    ResponseVo<CartVo> list(Integer uid);

    ResponseVo<CartVo> update(Integer uid, Integer productId, CartUpdateForm form);

    ResponseVo<CartVo> delete(Integer uid, Integer productId);

    ResponseVo<CartVo> selectAll(Integer uid);

    ResponseVo<CartVo> unselectAll(Integer uid);

    ResponseVo<Integer> sum(Integer uid);
}
