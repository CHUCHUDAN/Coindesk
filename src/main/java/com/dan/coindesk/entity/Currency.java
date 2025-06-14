package com.dan.coindesk.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * ClassName: Currency
 * Package: com.dan.coindesk.entity
 * Description:
 *
 * @Author 嘉哥
 * @Create 2025/6/11 下午 01:25
 * @Version 1.0
 */

@Entity
@Table(name = "currency")
@Data
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "currency_en", nullable = false)
    private String currencyEn;

    @Column(name = "currency_zh", nullable = false)
    private String currencyZh;
}
