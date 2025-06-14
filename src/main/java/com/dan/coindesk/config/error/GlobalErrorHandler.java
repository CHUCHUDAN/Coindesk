package com.dan.coindesk.config.error;

import com.dan.coindesk.enums.StatusEnum;
import com.dan.coindesk.vo.res.ResData;
import com.dan.coindesk.vo.res.ResDataFail;
import com.dan.coindesk.vo.res.ResponseEntityBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: GlobalErrorHandler
 * Package: com.dan.coindesk.config
 * Description:
 *
 * @Author 嘉哥
 * @Create 2025/6/11 下午 05:52
 * @Version 1.0
 */
@RestControllerAdvice
@Slf4j
public class GlobalErrorHandler {

    @ExceptionHandler(BussinessException.class)
    public ResponseEntity<ResDataFail> handleBussinessException(BussinessException ex){
        return ResponseEntityBuilder.fail(ex.getHttpStatus(), ex.getCode(), ex.getMsg());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResDataFail> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.toList());
        return ResponseEntityBuilder.fail(StatusEnum.DATA_VALID_FAIL, errors);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ResDataFail> handleThrowable(Throwable ex){
        log.error(ex.getMessage());
        return ResponseEntityBuilder.fail();
    }
}
