package com.dan.coindesk.enums;

import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * ClassName: BussinessExceptionEnum
 * Package: com.dan.coindesk.config.error
 * Description:
 *
 * @Author 嘉哥
 * @Create 2025/6/11 下午 05:58
 * @Version 1.0
 */
@Getter
public enum BussinessExceptionEnum {

    CURRENCY_NOT_EXIST(HttpStatus.NOT_FOUND,10001, "幣別不存在"),
    CURRENCY_EXIST(HttpStatus.CONFLICT,10002, "中、英幣別已存在");
    private HttpStatus httpStatus;
    private Integer bussinessCode;
    private String msg;

    BussinessExceptionEnum(HttpStatus httpStatus, Integer bussinessCode, String msg){
        this.httpStatus = httpStatus;
        this.bussinessCode = bussinessCode;
        this.msg = msg;
    }
}
