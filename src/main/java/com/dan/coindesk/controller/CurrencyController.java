package com.dan.coindesk.controller;

import com.dan.coindesk.entity.Currency;
import com.dan.coindesk.enums.StatusEnum;
import com.dan.coindesk.service.CurrencyService;
import com.dan.coindesk.vo.req.CurrencyAddRq;
import com.dan.coindesk.vo.req.CurrencyUpdateRq;
import com.dan.coindesk.vo.res.CurrencyRs;
import com.dan.coindesk.vo.res.ResData;
import com.dan.coindesk.vo.res.ResDataSuccess;
import com.dan.coindesk.vo.res.ResponseEntityBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * ClassName: CurrencyController
 * Package: com.dan.coindesk.controller
 * Description:
 *
 * @Author 嘉哥
 * @Create 2025/6/11 下午 02:23
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/v1")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/currency/{id}")
    public ResponseEntity<ResDataSuccess<CurrencyRs>> getById(@PathVariable Integer id) {
        return ResponseEntityBuilder.success(currencyService.findById(id), StatusEnum.SUCCESS);
    }

    @GetMapping("/currency")
    public ResponseEntity<ResDataSuccess<CurrencyRs>> getByCurrencyEn(@RequestParam("currencyEn") String currencyEn){
        return ResponseEntityBuilder.success(currencyService.findByCurrencyEn(currencyEn), StatusEnum.SUCCESS);
    }

    @GetMapping("/currencies")
    public ResponseEntity<ResDataSuccess<List<CurrencyRs>>> getAll() {
        return ResponseEntityBuilder.success(currencyService.findAll(), StatusEnum.SUCCESS);
    }

    @PostMapping("/currency")
    public ResponseEntity<ResDataSuccess> addCurrency(@RequestBody @Valid CurrencyAddRq currencyAddRq) {
        currencyService.addCurrency(currencyAddRq);
        return ResponseEntityBuilder.success(StatusEnum.CREATED);
    }

    @PutMapping("/currency")
    public ResponseEntity<ResDataSuccess> updateCurrency(@RequestBody @Valid CurrencyUpdateRq currencyUpdateRq) {
        currencyService.updateCurrency(currencyUpdateRq);
        return ResponseEntityBuilder.success();
    }

    @DeleteMapping("/currency/{id}")
    public ResponseEntity<ResDataSuccess> deleteCurrency(@PathVariable Integer id) {
        currencyService.deleteCurrency(id);
        return ResponseEntityBuilder.success();
    }
}
