package com.dan.coindesk.service;

import com.dan.coindesk.vo.res.CoindeskRs;
import com.dan.coindesk.vo.res.CoindeskTransferRs;
import com.dan.coindesk.vo.res.ResDataSuccess;

/**
 * ClassName: CoindeskService
 * Package: com.dan.coindesk.service
 * Description:
 *
 * @Author 嘉哥
 * @Create 2025/6/12 下午 01:03
 * @Version 1.0
 */
public interface CoindeskService {
    // 獲取coindesk api資料
    CoindeskRs getCoindesk();

    // 獲取幣別轉換資料
    CoindeskTransferRs getCoindeskTransfer();
}