package com.lzr.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 登陆提交对象
 */

@Data
public class UserRegisterForm {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String email;
}
