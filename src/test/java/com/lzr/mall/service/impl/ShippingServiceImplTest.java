package com.lzr.mall.service.impl;

import com.lzr.mall.MallApplicationTests;
import com.lzr.mall.enums.ResponseEnum;
import com.lzr.mall.form.ShippingForm;
import com.lzr.mall.service.IShippingService;
import com.lzr.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@Slf4j
public class ShippingServiceImplTest extends MallApplicationTests {

    @Autowired
    private IShippingService shippingService;

    private Integer uid = 1;

    private ShippingForm shippingForm;

    private Integer shippingId = 16;

    @Before
    public void before() {
        ShippingForm shippingForm = new ShippingForm();
        shippingForm.setReceiverName("林梓润");
        shippingForm.setReceiverAddress("太玉园");
        shippingForm.setReceiverCity("北京");
        shippingForm.setReceiverMobile("17722222222");
        shippingForm.setReceiverPhone("0123456");
        shippingForm.setReceiverProvince("北京");
        shippingForm.setReceiverDistrict("通州区");
        shippingForm.setReceiverZip("000000");
        this.shippingForm = shippingForm;
        add();
    }


    public void add() {
        ResponseVo<Map<String, Integer>> responseVo = shippingService.add(uid, shippingForm);
        log.info("responseVo={}", responseVo);
        this.shippingId = responseVo.getData().get("shippingId");
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @After
    public void delete() {
        ResponseVo responseVo = shippingService.delete(uid, shippingId);
        log.info("responseVo={}", responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void update() {
        shippingForm.setReceiverCity("上海");
        ResponseVo responseVo = shippingService.update(uid, shippingId, shippingForm);
        log.info("responseVo={}", responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void list() {
        ResponseVo responseVo = shippingService.list(uid, 1, 10);
        log.info("result={}", responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}