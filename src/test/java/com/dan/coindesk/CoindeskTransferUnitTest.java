package com.dan.coindesk;

import com.dan.coindesk.service.impl.CoindeskServiceImpl;
import com.dan.coindesk.vo.res.CoindeskRs;
import com.dan.coindesk.vo.res.CoindeskTransferRs;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;

/**
 * ClassName: Coindesk
 * Package: com.dan.coindesk
 * Description:
 *
 * @Author 嘉哥
 * @Create 2025/6/13 下午 04:52
 * @Version 1.0
 */
@ExtendWith(MockitoExtension.class)
class CoindeskTransferUnitTest {

    @Spy
    private CoindeskServiceImpl coindeskService;

    /**
     * getCoindeskTransfer 單元測試
     */
    @Test
    void testGetCoindeskTransfer() {
        // Arrange
        CoindeskRs mockCoindesk = CoindeskRs.builder()
                .time(CoindeskRs.Time.builder()
                        .updated("Sep 2, 2024 07:07:20 UTC")
                        .updatedIso("2024-09-02T07:07:20+00:00")
                        .updatedUk("Sep 2, 2024 at 08:07 BST")
                        .build())
                .bpi(CoindeskRs.Bpi.builder()
                        .usd(CoindeskRs.Usd.builder()
                                .code("USD")
                                .rateFloat(BigDecimal.valueOf(57756.2984))
                                .build())
                        .gbp(CoindeskRs.Gbp.builder()
                                .code("GBP")
                                .rateFloat(BigDecimal.valueOf(43984.0203))
                                .build())
                        .eur(CoindeskRs.Eur.builder()
                                .code("EUR")
                                .rateFloat(BigDecimal.valueOf(52243.2865))
                                .build())
                        .build())
                .build();

        // 模擬方法行為
        doReturn(mockCoindesk).when(coindeskService).getCoindesk();
        doReturn("美元").when(coindeskService).getCurrencyZh("USD");
        doReturn("英鎊").when(coindeskService).getCurrencyZh("GBP");
        doReturn("歐元").when(coindeskService).getCurrencyZh("EUR");

        // Act
        CoindeskTransferRs result = coindeskService.getCoindeskTransfer();

        // Assert
        assertNotNull(result);
        assertEquals("2024/09/02 07:07:20", result.getTime().getUpdated());
        assertEquals("2024/09/02 07:07:20", result.getTime().getUpdatedIso());
        assertEquals("2024/09/02 08:07:00", result.getTime().getUpdatedUk());
        assertEquals("美元", result.getBpi().getUsd().getCurrencyZh());
        assertEquals(BigDecimal.valueOf(57756.2984), result.getBpi().getUsd().getRateFloat());
        assertEquals("英鎊", result.getBpi().getGbp().getCurrencyZh());
        assertEquals(BigDecimal.valueOf(43984.0203), result.getBpi().getGbp().getRateFloat());
        assertEquals("歐元", result.getBpi().getEur().getCurrencyZh());
        assertEquals(BigDecimal.valueOf(52243.2865), result.getBpi().getEur().getRateFloat());

    }
}
