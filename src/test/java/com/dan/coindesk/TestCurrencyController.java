package com.dan.coindesk;

import com.dan.coindesk.service.CurrencyService;
import com.dan.coindesk.vo.res.CurrencyRs;
import com.dan.coindesk.vo.res.ResDataSuccess;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * ClassName: CRUDTest
 * Package: com.dan.coindesk
 * Description:
 *
 * @Author 嘉哥
 * @Create 2025/6/12 下午 05:20
 * @Version 1.0
 */

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Slf4j
public class TestCurrencyController {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    CurrencyService currencyService;
    @Autowired
    ObjectMapper objectMapper;

    /**
     * 測試根據id獲取幣別
     * @throws Exception
     */
    @Test
    public void testGetCurrencyById() throws Exception {
        // 預期回傳的值
        CurrencyRs expectedObj = new CurrencyRs();
        expectedObj.setId(1);
        expectedObj.setCurrencyEn("USD");
        expectedObj.setCurrencyZh("美元");

        // [Act] 模擬網路呼叫[GET]
        String returnString = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/currency/1")
                        .accept(MediaType.APPLICATION_JSON ))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        ResDataSuccess<CurrencyRs> actuaObj = objectMapper.readValue(returnString, new TypeReference<ResDataSuccess<CurrencyRs>>() {
        });
        // [Assert] 判定回傳的body是否跟預期的一樣
        assertEquals(expectedObj,  actuaObj.getData());
        // 顯示內容
        log.info("result: " + actuaObj.getData());
    }

    /**
     * 測試獲取所有幣別
     * @throws Exception
     */
    @Test
    public void testGetCurrencies() throws Exception {
        // 預期回傳的值
        List<CurrencyRs> expectedList = new ArrayList<>();
        CurrencyRs usd = new CurrencyRs();
        usd.setId(1);
        usd.setCurrencyEn("USD");
        usd.setCurrencyZh("美元");
        CurrencyRs eur = new CurrencyRs();
        eur.setId(2);
        eur.setCurrencyEn("EUR");
        eur.setCurrencyZh("歐元");
        CurrencyRs gbp = new CurrencyRs();
        gbp.setId(3);
        gbp.setCurrencyEn("GBP");
        gbp.setCurrencyZh("英鎊");
        expectedList.add(usd);
        expectedList.add(eur);
        expectedList.add(gbp);

        // [Act] 模擬網路呼叫[GET]
        String returnString = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/currencies")
                        .accept(MediaType.APPLICATION_JSON ))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        ResDataSuccess<List<CurrencyRs>> actualList = objectMapper.readValue(returnString, new TypeReference<ResDataSuccess<List<CurrencyRs>>>() {
        });
        // [Assert] 判定回傳的body是否跟預期的一樣
        assertEquals(expectedList,  actualList.getData());
        // 顯示內容
        log.info("result: " + actualList.getData());
    }

    /**
     * 測試新增幣別
     * @throws Exception
     */
    @Test
    public void testCreateCurrency() throws Exception {

        // 預期回傳的值
        ResDataSuccess expectedObj = new ResDataSuccess();
        expectedObj.setBussinessCode(201);
        expectedObj.setMsg("新增資料成功");

        // [Arrange] 準備要送出的 JSON 物件
        JSONObject currencyObject = new JSONObject();
        currencyObject.put("currencyEn", "TWD");
        currencyObject.put("currencyZh", "台灣");

        // [Act] 發送 POST 請求並取得回應內容
        String returnString = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/currency")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(currencyObject.toString()))
                .andExpect(status().isCreated()) // 預期 HTTP 201 Created
                .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        ResDataSuccess actualObj = objectMapper.readValue(returnString, ResDataSuccess.class);

        // [Assert] 判定回傳的body是否跟預期的一樣
        assertEquals(expectedObj,  actualObj);
        assertEquals(201, actualObj.getBussinessCode());
        assertEquals("新增資料成功", actualObj.getMsg());

        // 顯示內容
        log.info("result: " + actualObj);
    }

    /**
     * 測試修改幣別資料
     * @throws Exception
     */
    @Test
    public void testUpdateCurrency() throws Exception {

        // 預期回傳的值
        ResDataSuccess expectedObj = new ResDataSuccess();
        expectedObj.setBussinessCode(200);
        expectedObj.setMsg("ok");

        // [Arrange] 準備要送出的 JSON 物件
        JSONObject currencyObject = new JSONObject();
        currencyObject.put("id", 2);
        currencyObject.put("currencyEn", "TWD");
        currencyObject.put("currencyZh", "台灣");

        // [Act] 模擬網路呼叫[PUT]
        String returnString = mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/currency")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(currencyObject.toString()))
                .andExpect(status().isOk()) // 預期 HTTP 200(OK)
                .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        ResDataSuccess actualObj = objectMapper.readValue(returnString, ResDataSuccess.class);

        // [Assert] 判定回傳的body是否跟預期的一樣
        assertEquals(expectedObj,  actualObj);
        assertEquals(200, actualObj.getBussinessCode());
        assertEquals("ok", actualObj.getMsg());

        // 顯示內容
        log.info("result: " + actualObj);
    }

    /**
     * 測試刪除幣別
     * @throws Exception
     */
    @Test
    public void testDeleteCurrency() throws Exception {
        // 預期回傳的值
        ResDataSuccess expectedObj = new ResDataSuccess();
        expectedObj.setBussinessCode(200);
        expectedObj.setMsg("ok");

        // [Act] 模擬網路呼叫[DELETE]
        String returnString = mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/currency/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) // 預期 HTTP 200(OK)
                .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        ResDataSuccess actualObj = objectMapper.readValue(returnString, ResDataSuccess.class);

        // [Assert] 判定回傳的body是否跟預期的一樣
        assertEquals(expectedObj,  actualObj);
        assertEquals(200, actualObj.getBussinessCode());
        assertEquals("ok", actualObj.getMsg());

        // 顯示內容
        log.info("result: " + actualObj);

    }
}
