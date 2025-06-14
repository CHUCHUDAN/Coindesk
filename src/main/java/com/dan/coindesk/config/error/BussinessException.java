package com.dan.coindesk.config.error;

import com.dan.coindesk.enums.BussinessExceptionEnum;
import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

/**
 * ClassName: BussinessException
 * Package: com.dan.coindesk.config.error
 * Description:
 *
 * @Author 嘉哥
 * @Create 2025/6/11 下午 05:58
 * @Version 1.0
 */
@Data
public class BussinessException extends RuntimeException {

    // http狀態碼
    private HttpStatus httpStatus;

    // 業務異常代碼
    private Integer code;

    // 業務異常訊息
    private String msg;

    public BussinessException(BussinessExceptionEnum exceptionEnum){
        super(exceptionEnum.getMsg());
        this.httpStatus = exceptionEnum.getHttpStatus();
        this.code = exceptionEnum.getBussinessCode();
        this.msg = exceptionEnum.getMsg();
    }
}
