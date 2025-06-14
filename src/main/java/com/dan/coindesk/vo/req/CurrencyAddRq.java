package com.dan.coindesk.vo.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName: CurrencyRq
 * Package: com.dan.coindesk.vo.req
 * Description:
 *
 * @Author 嘉哥
 * @Create 2025/6/11 下午 05:30
 * @Version 1.0
 */

@Data
public class CurrencyAddRq {
    @NotNull(message = "英文幣別不能為空")
    private String currencyEn;
    @NotNull(message = "中文幣別不能為空")
    private String currencyZh;
}
