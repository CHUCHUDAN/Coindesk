package com.dan.coindesk.vo.res;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * ClassName: CoindeskRs
 * Package: com.dan.coindesk.vo.res
 * Description:
 *
 * @Author 嘉哥
 * @Create 2025/6/12 下午 01:24
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoindeskRs {

    private Time time;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Time {
        private String updated;
        @JsonProperty("updatedISO")
        private String updatedIso;
        @JsonProperty("updateduk")
        private String updatedUk;
    }

    private String disclaimer;
    private String chartName;
    private Bpi bpi;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Bpi {
        @JsonProperty("USD")
        private Usd usd;

        @JsonProperty("GBP")
        private Gbp gbp;

        @JsonProperty("EUR")
        private Eur eur;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Usd {
        private String code;
        private String symbol;
        private String rate;
        private String description;
        @JsonProperty("rate_float")
        private BigDecimal rateFloat;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Gbp {
        private String code;
        private String symbol;
        private String rate;
        private String description;
        @JsonProperty("rate_float")
        private BigDecimal rateFloat;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Eur {
        private String code;
        private String symbol;
        private String rate;
        private String description;
        @JsonProperty("rate_float")
        private BigDecimal rateFloat;
    }
}

