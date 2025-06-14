package com.dan.coindesk.vo.res;

import com.dan.coindesk.enums.StatusEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * ClassName: ResponseEntityBuilder
 * Package: com.dan.coindesk.vo.res
 * Description:
 *
 * @Author 嘉哥
 * @Create 2025/6/12 下午 06:22
 * @Version 1.0
 */
public class ResponseEntityBuilder {

    // 成功，200 OK
    public static ResponseEntity<ResDataSuccess> success() {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(ResDataSuccess.success());
    }
    // 成功 自訂
    public static <T> ResponseEntity<ResDataSuccess<T>> success(T data, StatusEnum statusEnum) {
        return ResponseEntity.status(statusEnum.getHttpStatus())
                .contentType(MediaType.APPLICATION_JSON)
                .body(ResDataSuccess.success(data, statusEnum));
    }

    public static <T> ResponseEntity<ResDataSuccess> success(StatusEnum statusEnum) {
        return ResponseEntity.status(statusEnum.getHttpStatus())
                .contentType(MediaType.APPLICATION_JSON)
                .body(ResDataSuccess.success(statusEnum));
    }

    // BussinessException 失敗
    public static <T> ResponseEntity<ResDataFail> fail(HttpStatus httpStatus, Integer bussinessCode, String msg) {
        return ResponseEntity.status(httpStatus)
                .contentType(MediaType.APPLICATION_JSON)
                .body(ResDataFail.fail(bussinessCode,msg));
    }

    // 失敗，500
    public static <T> ResponseEntity<ResDataFail> fail() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(ResDataFail.fail());
    }

    // 失敗 自訂
    public static <T> ResponseEntity<ResDataFail> fail(StatusEnum statusEnum) {
        return ResponseEntity.status(statusEnum.getHttpStatus())
                .contentType(MediaType.APPLICATION_JSON)
                .body(ResDataFail.fail(statusEnum));
    }

    public static <T> ResponseEntity<ResDataFail> fail(StatusEnum statusEnum, List<String> errors) {
        return ResponseEntity.status(statusEnum.getHttpStatus())
                .contentType(MediaType.APPLICATION_JSON)
                .body(ResDataFail.fail(statusEnum, errors));
    }
}