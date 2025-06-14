package com.dan.coindesk.enums;

import lombok.Getter;

/**
 * ClassName: DateFormatEnum
 * Package: com.dan.coindesk.enums
 * Description:
 *
 * @Author 嘉哥
 * @Create 2025/6/12 下午 04:28
 * @Version 1.0
 */
@Getter
public enum DatePatternEnum {
    UTC("MMM d, yyyy HH:mm:ss z"),
    ISO("yyyy-MM-dd'T'HH:mm:ss"),
    BST("MMM d, yyyy 'at' HH:mm z"),
    YYYY_MM_DD_HH_MM_SS("yyyy/MM/dd HH:mm:ss");

    private final String pattern;

    DatePatternEnum(String pattern) {
        this.pattern = pattern;
    }
}
