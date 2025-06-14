package com.dan.coindesk;

import com.dan.coindesk.service.CurrencyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.nio.charset.StandardCharsets;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * ClassName: TestCoindeskController
 * Package: com.dan.coindesk
 * Description:
 *
 * @Author 嘉哥
 * @Create 2025/6/13 上午 11:30
 * @Version 1.0
 */

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Slf4j
public class TestCoindeskController {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    CurrencyService currencyService;
    @Autowired
    ObjectMapper objectMapper;

    /**
     * 測試call coindesk api
     * @throws Exception
     */
    @Test
    public void testGetCoindesk() throws Exception {

        // [Act] 模擬網路呼叫[GET]
        String returnString = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/coindesk")
                        .accept(MediaType.APPLICATION_JSON ))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        // 顯示內容
        log.info("result: " + returnString);
    }

    /**
     * 測試call coindesk transfer
     * @throws Exception
     */
    @Test
    public void testGetCoindeskTransfer() throws Exception {

        // [Act] 模擬網路呼叫[GET]
        String returnString = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/coindeskTransfer")
                        .accept(MediaType.APPLICATION_JSON ))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        // 顯示內容
        log.info("result: " + returnString);
    }
}
