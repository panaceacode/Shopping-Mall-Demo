package com.lzr.mall.enums;

import lombok.Getter;

/**
 * 用户身份码
 */

@Getter
public enum RoleEnum {

    ADMIN(0),

    CUSTOMER(1),

        ;

    Integer code;

    RoleEnum(Integer code) {
        this.code = code;
    }
}
