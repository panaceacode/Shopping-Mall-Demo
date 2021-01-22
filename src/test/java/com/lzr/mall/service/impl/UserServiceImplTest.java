package com.lzr.mall.service.impl;

import com.lzr.mall.MallApplicationTests;
import com.lzr.mall.enums.ResponseEnum;
import com.lzr.mall.enums.RoleEnum;
import com.lzr.mall.pojo.User;
import com.lzr.mall.service.IUserService;
import com.lzr.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserServiceImplTest extends MallApplicationTests {

    public static final String USERNAME = "jack";

    public static final String PASSWORD = "123456";

    @Autowired
    private IUserService userService;

    @Before
    public void register() {
        User user = new User(USERNAME, PASSWORD, "tom@qq.com", RoleEnum.CUSTOMER.getCode());
        userService.register(user);
    }

    @Test
    public void login() {
        ResponseVo<User> responseVo = userService.login(USERNAME, PASSWORD);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}