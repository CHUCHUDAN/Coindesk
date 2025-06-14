package com.dan.coindesk.service;

import com.dan.coindesk.entity.Currency;
import com.dan.coindesk.vo.req.CurrencyAddRq;
import com.dan.coindesk.vo.req.CurrencyUpdateRq;
import com.dan.coindesk.vo.res.CurrencyRs;
import com.dan.coindesk.vo.res.ResData;
import com.dan.coindesk.vo.res.ResDataFail;
import com.dan.coindesk.vo.res.ResDataSuccess;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * ClassName: CurrencyService
 * Package: com.dan.coindesk.service
 * Description:
 *
 * @Author 嘉哥
 * @Create 2025/6/11 下午 02:24
 * @Version 1.0
 */
public interface CurrencyService {

    // 根據id查找幣別
    CurrencyRs findById(Integer id);

    // 根據CurrencyEn查找幣別
    CurrencyRs findByCurrencyEn(String currencyEn);

    // 查詢所有幣別
    List<CurrencyRs> findAll();

    // 新增幣別
    void addCurrency(CurrencyAddRq currencyAddRq);

    // 根據id更新幣別
    void updateCurrency(CurrencyUpdateRq currencyUpdateRq);

    // 刪除幣別
    void deleteCurrency(Integer id);

}
