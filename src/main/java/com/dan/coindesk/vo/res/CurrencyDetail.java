package com.dan.coindesk.vo.res;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * ClassName: CurrencyDetail
 * Package: com.dan.coindesk.vo.res
 * Description:
 *
 * @Author 嘉哥
 * @Create 2025/6/12 下午 02:38
 * @Version 1.0
 */
@Data
public class CurrencyDetail {
    private String code;
    private String symbol;
    private String rate;
    private String description;
    @JsonProperty("rate_float")
    private BigDecimal rateFloat;
}
