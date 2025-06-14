package com.dan.coindesk.util;

import com.dan.coindesk.enums.DatePatternEnum;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * ClassName: DateTimeTransfer
 * Package: com.dan.coindesk.util
 * Description:
 *
 * @Author 嘉哥
 * @Create 2025/6/12 下午 04:27
 * @Version 1.0
 */
public class DateTimeTransfer {

    // 日期格式轉換
    public static String dateFormatTransfer(String inputDateTime, DatePatternEnum orignPattern, DatePatternEnum transPattern){
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(orignPattern.getPattern(), Locale.ENGLISH);
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(inputDateTime, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(transPattern.getPattern());

        return zonedDateTime.format(outputFormatter);
    }

    // 日期格式轉換(ISO)
    public static String dateFormatTransfer(String inputDateTime, DatePatternEnum transPattern){
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(inputDateTime);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(transPattern.getPattern());

        return zonedDateTime.format(outputFormatter);
    }
}
