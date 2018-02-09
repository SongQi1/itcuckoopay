package com.alipay.demo.trade.service.impl;

import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayEcoMycarParkingConfigSetRequest;
import com.alipay.api.response.AlipayEcoMycarParkingConfigSetResponse;
import com.alipay.demo.trade.model.builder.AlipayEcoMycarParkingConfigSetRequestBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * 描述:<p>支付宝停车缴费 </p>
 *
 * @Author: songqi
 * @Date: 2018/2/9 15:40
 */
@Service
public class AlipayParkingService extends AbsAlipayService{


    @Autowired
    protected AlipayClient alipayClient ;


    /**
     * @PostConstruct是Java EE 5引入的注解，Spring允许开发者在受管Bean中使用它。
     * 当DI容器实例化当前受管Bean时，@PostConstruct注解的方法会被自动触发，从而完成一些初始化工作
     */
    @PostConstruct
    public void initAlipayClient(){
        super.alipayClient = alipayClient;
    }


    /**
     * 停车ISV系统配置接口
     * @param builder
     * @return
     */
    public boolean parkingConfigSet(AlipayEcoMycarParkingConfigSetRequestBuilder builder){

        validateBuilder(builder);

        AlipayEcoMycarParkingConfigSetRequest request = new AlipayEcoMycarParkingConfigSetRequest();
        request.putOtherTextParam("app_auth_token", builder.getAppAuthToken());
        request.setBizContent(builder.toJsonString());

        log.info("alipay.eco.mycar.parking.config.set request content:" + builder.toString());

        AlipayEcoMycarParkingConfigSetResponse response = (AlipayEcoMycarParkingConfigSetResponse) getResponse(request);
        return response.isSuccess();
    }

}
