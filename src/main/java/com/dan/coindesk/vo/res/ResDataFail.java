package com.dan.coindesk.vo.res;

import com.dan.coindesk.enums.StatusEnum;
import lombok.Data;

import java.util.List;

/**
 * ClassName: ResDataFail
 * Package: com.dan.coindesk.vo.res
 * Description:
 *
 * @Author 嘉哥
 * @Create 2025/6/12 上午 11:44
 * @Version 1.0
 */
@Data
public class ResDataFail extends ResData{
    private List<String> errors;

    // BussinessException 失敗
    public static ResDataFail fail(Integer bussinessCode, String msg){
        ResDataFail res = new ResDataFail();
        res.setBussinessCode(bussinessCode);
        res.setMsg(msg);
        return res;
    }

    // 失敗 500
    public static ResDataFail fail(){
        ResDataFail res = new ResDataFail();
        res.setBussinessCode(StatusEnum.UNEXCEPT_ERROR.getBussinessCode());
        res.setMsg(StatusEnum.UNEXCEPT_ERROR.getMsg());
        return res;
    }

    // 自訂
    public static ResDataFail fail(StatusEnum statusEnum){
        ResDataFail res = new ResDataFail();
        res.setBussinessCode(statusEnum.getBussinessCode());
        res.setMsg(statusEnum.getMsg());
        return res;
    }
    public static ResDataFail fail(StatusEnum statusEnum, List<String> errors){
        ResDataFail res = new ResDataFail();
        res.setBussinessCode(statusEnum.getBussinessCode());
        res.setMsg(statusEnum.getMsg());
        res.setErrors(errors);
        return res;
    }
}
