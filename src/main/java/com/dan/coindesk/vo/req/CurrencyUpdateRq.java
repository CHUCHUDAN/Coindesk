package com.dan.coindesk.vo.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName: CurrencyUpdateRq
 * Package: com.dan.coindesk.vo.req
 * Description:
 *
 * @Author 嘉哥
 * @Create 2025/6/11 下午 07:11
 * @Version 1.0
 */

@Data
public class CurrencyUpdateRq {
    @NotNull(message = "幣別id不能為空")
    private Integer id;
    private String currencyEn;
    private String currencyZh;
}
