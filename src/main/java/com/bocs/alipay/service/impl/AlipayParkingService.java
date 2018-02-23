package com.bocs.alipay.service.impl;

import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayEcoMycarParkingConfigQueryRequest;
import com.alipay.api.request.AlipayEcoMycarParkingConfigSetRequest;
import com.alipay.api.response.AlipayEcoMycarParkingConfigQueryResponse;
import com.alipay.api.response.AlipayEcoMycarParkingConfigSetResponse;
import com.bocs.alipay.config.Constants;
import com.bocs.alipay.model.TradeStatus;
import com.bocs.alipay.model.builder.AlipayEcoMycarParkingConfigQueryRequestBuilder;
import com.bocs.alipay.model.builder.AlipayEcoMycarParkingConfigSetRequestBuilder;
import com.bocs.alipay.model.result.AlipayParkingConfigQueryResult;
import com.bocs.alipay.model.result.AlipayParkingConfigSetResult;
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
     * ISV在支付宝系统中配置停车业务的信息。
     * 主要信息包括：ISV的商户简称，ISV的客服电话，ISV签约的支付宝账号，ISV的商户logo，用户查询url
     * @param builder
     * @return
     */
    public AlipayParkingConfigSetResult parkingConfigSet(AlipayEcoMycarParkingConfigSetRequestBuilder builder){

        validateBuilder(builder);

        AlipayEcoMycarParkingConfigSetRequest request = new AlipayEcoMycarParkingConfigSetRequest();
        request.putOtherTextParam("app_auth_token", builder.getAppAuthToken());
        request.setBizContent(builder.toJsonString());

        log.info("alipay.eco.mycar.parking.config.set request content:" + builder.toString());

        AlipayEcoMycarParkingConfigSetResponse response = (AlipayEcoMycarParkingConfigSetResponse) getResponse(request);
        AlipayParkingConfigSetResult result = new AlipayParkingConfigSetResult(response);
        if (response != null && Constants.SUCCESS.equals(response.getCode())) {
            //交易成功
            result.setTradeStatus(TradeStatus.SUCCESS);

        } else if (tradeError(response)) {
            // 系统发生异常，状态未知
            result.setTradeStatus(TradeStatus.UNKNOWN);

        } else {
            // 其他情况表明该交易明确失败
            result.setTradeStatus(TradeStatus.FAILED);
        }
        return result;
    }

    /**
     * ISV查询在支付宝系统中配置的停车业务信息。
     * @return
     */
    public AlipayParkingConfigQueryResult parkingConfigQuery(AlipayEcoMycarParkingConfigQueryRequestBuilder builder){

        AlipayEcoMycarParkingConfigQueryRequest request = new AlipayEcoMycarParkingConfigQueryRequest();
        request.putOtherTextParam("app_auth_token", builder.getAppAuthToken());
        request.setBizContent(builder.toJsonString());
        log.info("alipay.eco.mycar.parking.config.query request content:" + builder.toString());
        AlipayEcoMycarParkingConfigQueryResponse response = (AlipayEcoMycarParkingConfigQueryResponse) getResponse(request);
        AlipayParkingConfigQueryResult result = new AlipayParkingConfigQueryResult(response);
        if (response != null && Constants.SUCCESS.equals(response.getCode())) {
            //交易成功
            result.setTradeStatus(TradeStatus.SUCCESS);

        } else if (tradeError(response)) {
            // 系统发生异常，状态未知
            result.setTradeStatus(TradeStatus.UNKNOWN);

        } else {
            // 其他情况表明该交易明确失败
            result.setTradeStatus(TradeStatus.FAILED);
        }
        return result;
    }

}
