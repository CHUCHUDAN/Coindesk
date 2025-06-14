package com.dan.coindesk.enums;

import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * ClassName: StatusEnum
 * Package: com.dan.coindesk.config.error
 * Description:
 *
 * @Author 嘉哥
 * @Create 2025/6/12 下午 12:15
 * @Version 1.0
 */
@Getter
public enum StatusEnum {

    // 成功
    SUCCESS(HttpStatus.OK,200, "ok"),
    CREATED(HttpStatus.CREATED,201, "新增資料成功"),

    // 異常
    DATA_VALID_FAIL(HttpStatus.BAD_REQUEST, 400, "數據檢核失敗"),
    UNEXCEPT_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,99999,"未預期錯誤");


    private HttpStatus httpStatus;
    private Integer bussinessCode;
    private String msg;

    StatusEnum(HttpStatus httpStatus, Integer bussinessCode, String msg){
        this.httpStatus = httpStatus;
        this.bussinessCode = bussinessCode;
        this.msg = msg;
    }
}