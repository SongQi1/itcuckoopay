package com.bocs.sys.controller;

import com.bocs.sys.service.AlipayApiService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:<p> </p>
 * Created by songqi on 2018/2/2.
 */

@RestController
public class AlipayApiController {



    @Autowired
    private AlipayApiService alipayApiService;

    /**
     * 用商户的app_auth_code换取app_auth_token，使用app_auth_token代替商户完成签约的功能。
     * @param app_auth_code
     * @param app_id
     * @return
     */
    @RequestMapping(value = "/authRedirect")
    public String authRedirect(String app_auth_code, String app_id){
        alipayApiService.openAppAuthToken(app_auth_code, app_id);
        return "success";
    }

    @RequestMapping(value = "/receivePush")
    public String receivePush(){
        return "success";
    }

    /**
     * 用户在支付宝钱包的车主服务->停车服务中查询并支付停车费，支付宝的停车平台根据用户车辆驶入
     * 信息匹配并跳转到此页面，并携带auth_code和car_id两个参数。
     * 根据auth_code调用支付宝授权接口（alipay.system.oauth.token）获取access_token和user_id，
     * 再根据access_token和car_id调用获取车辆信息接口（alipay.eco.mycar.parking.vehicle.query）获取用户的车牌信息，
     * 根据车牌信息到数据库查询进场时间，计算停车费用，显示给用户。
     * @param auth_code
     * @param car_id
     * @return
     */
    @RequestMapping(value = "/queryParkingFee")
    public String queryParkingFee(String auth_code, String car_id){

        return "parking/parking_fee";
    }

}
