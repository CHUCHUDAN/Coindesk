package com.dan.coindesk.vo.res;

import lombok.Data;

import javax.persistence.*;

/**
 * ClassName: CurrencyRs
 * Package: com.dan.coindesk.vo.res
 * Description:
 *
 * @Author 嘉哥
 * @Create 2025/6/11 下午 05:33
 * @Version 1.0
 */

@Data
public class CurrencyRs {
    private Integer id;
    private String currencyEn;
    private String currencyZh;
}
