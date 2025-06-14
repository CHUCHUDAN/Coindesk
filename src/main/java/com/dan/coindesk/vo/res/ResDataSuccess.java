package com.dan.coindesk.vo.res;

import com.dan.coindesk.enums.StatusEnum;
import lombok.Data;
import lombok.ToString;

/**
 * ClassName: ResDataSuccess
 * Package: com.dan.coindesk.vo.res
 * Description:
 *
 * @Author 嘉哥
 * @Create 2025/6/12 上午 11:40
 * @Version 1.0
 */
@Data
@ToString(callSuper = true)
public class ResDataSuccess<T> extends ResData {
    private T data;

    // success 200
    public static ResDataSuccess success(){
        ResDataSuccess res = new ResDataSuccess<>();
        res.setBussinessCode(StatusEnum.SUCCESS.getBussinessCode());
        res.setMsg(StatusEnum.SUCCESS.getMsg());
        return res;
    }

    // 自訂
    public static <T> ResDataSuccess<T> success(T data, StatusEnum statusEnum){
        ResDataSuccess<T> res = new ResDataSuccess<>();
        res.setBussinessCode(statusEnum.getBussinessCode());
        res.setMsg(statusEnum.getMsg());
        res.setData(data);
        return res;
    }

    public static <T> ResDataSuccess<T> success(StatusEnum statusEnum){
        ResDataSuccess<T> res = new ResDataSuccess<>();
        res.setBussinessCode(statusEnum.getBussinessCode());
        res.setMsg(statusEnum.getMsg());
        return res;
    }

}
