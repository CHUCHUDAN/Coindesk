package com.dan.coindesk.controller;

import com.dan.coindesk.enums.StatusEnum;
import com.dan.coindesk.service.CoindeskService;
import com.dan.coindesk.vo.res.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: CoindeskController
 * Package: com.dan.coindesk.controller
 * Description:
 *
 * @Author 嘉哥
 * @Create 2025/6/12 下午 01:03
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/v1")
public class CoindeskController {
    @Autowired
    private CoindeskService coindeskService;

    @GetMapping("/coindesk")
    public ResponseEntity<ResDataSuccess<CoindeskRs>> getCoindesk() {
        return ResponseEntityBuilder.success(coindeskService.getCoindesk(), StatusEnum.SUCCESS);
    }

    @GetMapping("/coindeskTransfer")
    public ResponseEntity<ResDataSuccess<CoindeskTransferRs>> getCoindeskTransfer() {
        return ResponseEntityBuilder.success(coindeskService.getCoindeskTransfer(), StatusEnum.SUCCESS);
    }

}
