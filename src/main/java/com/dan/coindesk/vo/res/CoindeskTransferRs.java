package com.dan.coindesk.vo.res;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

/**
 * ClassName: CoindeskTransferRs
 * Package: com.dan.coindesk.vo.res
 * Description:
 *
 * @Author 嘉哥
 * @Create 2025/6/12 下午 01:47
 * @Version 1.0
 */

@Data
@Builder
public class CoindeskTransferRs {
    private Time time;

    @Data
    @Builder
    public static class Time {
        private String updated;
        @JsonProperty("updatedISO")
        private String updatedIso;
        @JsonProperty("updateduk")
        private String updatedUk;
    }

    private Bpi bpi;

    @Data
    @Builder
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
    public static class Usd {
        private String code;
        @JsonProperty("currency_zh")
        private String currencyZh;
        @JsonProperty("rate_float")
        private BigDecimal rateFloat;
    }

    @Data
    @Builder
    public static class Gbp {
        private String code;
        @JsonProperty("currency_zh")
        private String currencyZh;
        @JsonProperty("rate_float")
        private BigDecimal rateFloat;
    }

    @Data
    @Builder
    public static class Eur {
        private String code;
        @JsonProperty("currency_zh")
        private String currencyZh;
        @JsonProperty("rate_float")
        private BigDecimal rateFloat;
    }
}

