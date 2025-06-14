package com.dan.coindesk.service.impl;

import com.dan.coindesk.config.error.BussinessException;
import com.dan.coindesk.enums.BussinessExceptionEnum;
import com.dan.coindesk.entity.Currency;
import com.dan.coindesk.repository.CurrencyRepository;
import com.dan.coindesk.service.CurrencyService;
import com.dan.coindesk.vo.req.CurrencyAddRq;
import com.dan.coindesk.vo.req.CurrencyUpdateRq;
import com.dan.coindesk.vo.res.CurrencyRs;
import com.dan.coindesk.vo.res.ResDataSuccess;
import com.dan.coindesk.vo.res.ResponseEntityBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: CurrencyServiceImpl
 * Package: com.dan.coindesk.service.impl
 * Description:
 *
 * @Author 嘉哥
 * @Create 2025/6/11 下午 02:25
 * @Version 1.0
 */
@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    /**
     * 根據id查找幣別
     * @param id
     * @return
     */
    private Currency findCurrencyById(Integer id){
        return currencyRepository.findById(id).orElse(null);
    }

    private Currency findCurrencyByCurrencyEn(String currencyEn){
        return currencyRepository.findByCurrencyEn(currencyEn).orElse(null);
    }


    @Override
    public CurrencyRs findById(Integer id) {
        CurrencyRs currencyRs = new CurrencyRs();
        Currency currency = findCurrencyById(id);
        if (ObjectUtils.isEmpty(currency)){
            throw new BussinessException(BussinessExceptionEnum.CURRENCY_NOT_EXIST);
        }
        BeanUtils.copyProperties(currency, currencyRs);
        return currencyRs;
    }

    @Override
    public CurrencyRs findByCurrencyEn(String currencyEn) {
        CurrencyRs currencyRs = new CurrencyRs();
        Currency currency = findCurrencyByCurrencyEn(currencyEn);
        if (ObjectUtils.isEmpty(currency)){
            throw new BussinessException(BussinessExceptionEnum.CURRENCY_NOT_EXIST);
        }
        BeanUtils.copyProperties(currency, currencyRs);
        return currencyRs;
    }

    @Override
    public List<CurrencyRs> findAll() {
        List<Currency> currencies = currencyRepository.findAll();
        List<CurrencyRs> currenciesRs = currencies.stream().map(currency -> {
            CurrencyRs currencyRs = new CurrencyRs();
            BeanUtils.copyProperties(currency, currencyRs);
            return currencyRs;
        }).collect(Collectors.toList());
        return currenciesRs;
    }

    @Override
    public void addCurrency(CurrencyAddRq currencyAddRq) {
        // 檢查中英幣別任一是否已存在於database
        boolean exists = currencyRepository.existsByCurrencyEnOrCurrencyZh(
                currencyAddRq.getCurrencyEn(), currencyAddRq.getCurrencyZh()
        );

        if (exists) {
            throw new BussinessException(BussinessExceptionEnum.CURRENCY_EXIST);
        }
        Currency currency = new Currency();
        BeanUtils.copyProperties(currencyAddRq, currency);
        currencyRepository.save(currency);
    }

    @Override
    public void updateCurrency(CurrencyUpdateRq currencyUpdateRq) {
        Currency currency = findCurrencyById(currencyUpdateRq.getId());
        if (ObjectUtils.isEmpty(currency)){
            throw new BussinessException(BussinessExceptionEnum.CURRENCY_NOT_EXIST);
        }
        // 部分更新
        if (StringUtils.hasText(currencyUpdateRq.getCurrencyEn())){
            currency.setCurrencyEn(currencyUpdateRq.getCurrencyEn());
        }
        if (StringUtils.hasText(currencyUpdateRq.getCurrencyZh())){
            currency.setCurrencyZh(currencyUpdateRq.getCurrencyZh());
        }
        currencyRepository.save(currency);
    }

    @Override
    public void deleteCurrency(Integer id) {
        if (ObjectUtils.isEmpty(findCurrencyById(id))){
            throw new BussinessException(BussinessExceptionEnum.CURRENCY_NOT_EXIST);
        }
        currencyRepository.deleteById(id);
    }
}
