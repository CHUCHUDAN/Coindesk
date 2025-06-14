package com.dan.coindesk.vo.res;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * ClassName: ResData
 * Package: com.dan.coindesk.vo.res
 * Description:
 *
 * @Author 嘉哥
 * @Create 2025/6/11 下午 05:44
 * @Version 1.0
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResData {
    private Integer bussinessCode;
    private String msg;
}
