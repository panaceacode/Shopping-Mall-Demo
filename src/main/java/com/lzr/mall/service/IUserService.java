package com.lzr.mall.service;

import com.lzr.mall.pojo.User;
import com.lzr.mall.vo.ResponseVo;

public interface IUserService {

    /**
     * 注册
     */
    ResponseVo register(User user);

    /**
     * 登陆
     */
    ResponseVo<User> login(String username, String password);

}
