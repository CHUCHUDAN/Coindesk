package com.dan.coindesk.service.impl;

import com.dan.coindesk.enums.DatePatternEnum;
import com.dan.coindesk.service.CoindeskService;
import com.dan.coindesk.service.CurrencyService;
import com.dan.coindesk.util.DateTimeTransfer;
import com.dan.coindesk.vo.res.CoindeskRs;
import com.dan.coindesk.vo.res.CoindeskTransferRs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: CoindeskServiceImpl
 * Package: com.dan.coindesk.service.impl
 * Description:
 *
 * @Author 嘉哥
 * @Create 2025/6/12 下午 01:04
 * @Version 1.0
 */
@Service
public class CoindeskServiceImpl implements CoindeskService {

    @Autowired
    private CurrencyService currencyService;

    @Override
    public CoindeskRs getCoindesk() {
        RestTemplate restTemplate = new RestTemplate();
        CoindeskRs coindeskRs = restTemplate.getForObject("https://kengp3.github.io/blog/coindesk.json", CoindeskRs.class);
        return coindeskRs;
    }

    @Override
    public CoindeskTransferRs getCoindeskTransfer() {
        CoindeskRs coindeskRs = getCoindesk();
        CoindeskRs.Time coinTime = coindeskRs.getTime();
        CoindeskRs.Bpi coinBpi = coindeskRs.getBpi();

        String updated = DateTimeTransfer.dateFormatTransfer(coinTime.getUpdated(), DatePatternEnum.UTC, DatePatternEnum.YYYY_MM_DD_HH_MM_SS);
        String updatedIso = DateTimeTransfer.dateFormatTransfer(coinTime.getUpdatedIso(), DatePatternEnum.YYYY_MM_DD_HH_MM_SS);
        String updatedUk = DateTimeTransfer.dateFormatTransfer(coinTime.getUpdatedUk(), DatePatternEnum.BST, DatePatternEnum.YYYY_MM_DD_HH_MM_SS);

        // Time
        CoindeskTransferRs.Time coinTransTime = CoindeskTransferRs.Time.builder()
                .updated(updated)
                .updatedIso(updatedIso)
                .updatedUk(updatedUk)
                .build();

        // USD
        CoindeskRs.Usd coinUsd = coinBpi.getUsd();
        String usdZh = getCurrencyZh(coinUsd.getCode());

        CoindeskTransferRs.Usd coinTransUsd = CoindeskTransferRs.Usd.builder()
                .code(coinUsd.getCode())
                .currencyZh(usdZh)
                .rateFloat(coinUsd.getRateFloat())
                .build();

        // GBP
        CoindeskRs.Gbp coinGbp = coinBpi.getGbp();
        String gbpZh = getCurrencyZh(coinGbp.getCode());

        CoindeskTransferRs.Gbp coinTransGbp = CoindeskTransferRs.Gbp.builder()
                .code(coinGbp.getCode())
                .currencyZh(gbpZh)
                .rateFloat(coinGbp.getRateFloat())
                .build();

        // EUR
        CoindeskRs.Eur coinEur = coinBpi.getEur();
        String eurZh = getCurrencyZh(coinEur.getCode());

        CoindeskTransferRs.Eur coinTransEur = CoindeskTransferRs.Eur.builder()
                .code(coinEur.getCode())
                .currencyZh(eurZh)
                .rateFloat(coinEur.getRateFloat())
                .build();

        // Bpi
        CoindeskTransferRs.Bpi coinTransBpi = CoindeskTransferRs.Bpi.builder()
                .usd(coinTransUsd)
                .gbp(coinTransGbp)
                .eur(coinTransEur)
                .build();

        CoindeskTransferRs coindeskTransferRs = CoindeskTransferRs.builder()
                .time(coinTransTime)
                .bpi(coinTransBpi)
                .build();

        return coindeskTransferRs;
    }

    public String getCurrencyZh(String currencyEn){
        return (currencyService.findByCurrencyEn(currencyEn)).getCurrencyZh();
    }
}
