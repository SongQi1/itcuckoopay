package com.bocs.alipay.service.impl;

import com.alipay.api.AlipayClient;
import com.alipay.api.request.*;
import com.alipay.api.response.*;
import com.bocs.alipay.config.Constants;
import com.bocs.alipay.model.TradeStatus;
import com.bocs.alipay.model.builder.AlipayEcoMycarParkingConfigQueryRequestBuilder;
import com.bocs.alipay.model.builder.AlipayEcoMycarParkingConfigSetRequestBuilder;
import com.bocs.alipay.model.builder.AlipayEcoMycarParkingEnterinfoSyncRequestBuilder;
import com.bocs.alipay.model.builder.AlipayEcoMycarParkingParkinglotinfoCreateRequestBuilder;
import com.bocs.alipay.model.result.*;
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
     * ISV通过该接口，配置车主平台各业务所需要的ISV的系统配置信息。如果接口配置存在则覆盖原有的接口信息。
     * 通过该接口设置的配置信息是立刻生效的，在调用该接口修改配置信息时请先评估对线上业务的影响，并做好处理方案。
     * @param builder
     * @return
     */
    public AlipayParkingConfigSetResult parkingConfigSet(AlipayEcoMycarParkingConfigSetRequestBuilder builder){

        validateBuilder(builder);

        AlipayEcoMycarParkingConfigSetRequest request = new AlipayEcoMycarParkingConfigSetRequest();
        //request.putOtherTextParam("app_auth_token", builder.getAppAuthToken());
        request.setBizContent(builder.toJsonString());

        log.info("alipay.eco.mycar.parking.config.set request content:" + builder.toString());

        AlipayEcoMycarParkingConfigSetResponse response = (AlipayEcoMycarParkingConfigSetResponse) getResponse(request,null, builder.getAppAuthToken());
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
     * ISV通过该接口，查询ISV已注册到车主平台停车业务系统配置信息。
     * @param builder
     * @return
     */
    public AlipayParkingConfigQueryResult parkingConfigQuery(AlipayEcoMycarParkingConfigQueryRequestBuilder builder){

        AlipayEcoMycarParkingConfigQueryRequest request = new AlipayEcoMycarParkingConfigQueryRequest();
//        request.putOtherTextParam("app_auth_token", builder.getAppAuthToken());
        request.setBizContent(builder.toJsonString());
        log.info("alipay.eco.mycar.parking.config.query request content:" + builder.toString());

        AlipayEcoMycarParkingConfigQueryResponse response = (AlipayEcoMycarParkingConfigQueryResponse) getResponse(request, null, builder.getAppAuthToken());
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


    /**
     * 录入停车场信息，用于在停车平台注册停车场信息，内容信息通过该接口提交到支付宝，支付宝会生成支付宝这边停车场ID反馈给开发者，用户后续更新和上送车辆信息。
     * @param builder
     * @return
     */
    public AlipayParkingParkinglotinfoCreateResult parkinglotCreate(AlipayEcoMycarParkingParkinglotinfoCreateRequestBuilder builder){
        AlipayEcoMycarParkingParkinglotinfoCreateRequest request = new AlipayEcoMycarParkingParkinglotinfoCreateRequest();
//        request.putOtherTextParam("app_auth_token", builder.getAppAuthToken());
        request.setBizContent(builder.toJsonString());
        log.info("alipay.eco.mycar.parking.parkinglotinfo.create request content:" + builder.toString());

        AlipayEcoMycarParkingParkinglotinfoCreateResponse response = (AlipayEcoMycarParkingParkinglotinfoCreateResponse) getResponse(request,null,builder.getAppAuthToken());
        AlipayParkingParkinglotinfoCreateResult result = new AlipayParkingParkinglotinfoCreateResult(response);

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
     * 更新停车场信息，内容信息通过该接口提交到支付宝，支付宝会生成支付宝这边停车场ID反馈给开发者，用户后续更新和上送车辆信息。
     * @param builder
     * @return
     */
    public AlipayParkingParkinglotinfoUpdateResult parkinglotUpdate(AlipayEcoMycarParkingParkinglotinfoCreateRequestBuilder builder){
        AlipayEcoMycarParkingParkinglotinfoUpdateRequest request = new AlipayEcoMycarParkingParkinglotinfoUpdateRequest();
//        request.putOtherTextParam("app_auth_token", builder.getAppAuthToken());
        request.setBizContent(builder.toJsonString());
        log.info("alipay.eco.mycar.parking.parkinglotinfo.Update request content:" + builder.toString());

        AlipayEcoMycarParkingParkinglotinfoUpdateResponse response = (AlipayEcoMycarParkingParkinglotinfoUpdateResponse) getResponse(request, null, builder.getAppAuthToken());
        AlipayParkingParkinglotinfoUpdateResult result = new AlipayParkingParkinglotinfoUpdateResult(response);

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
     * 车辆驶入接口。上传车辆驶入信息，上传信息通过该接口提交到支付宝，支付宝返回对应的信息
     * @param builder
     * @return
     */
    public AlipayParkingVehicleEnterResult viechleEnterSync(AlipayEcoMycarParkingEnterinfoSyncRequestBuilder builder){
        AlipayEcoMycarParkingEnterinfoSyncRequest request = new AlipayEcoMycarParkingEnterinfoSyncRequest();
//      request.putOtherTextParam("app_auth_token", builder.getAppAuthToken());
        request.setBizContent(builder.toJsonString());
        log.info("alipay.eco.mycar.parking.enterinfo.sync request content:" + builder.toString());

        AlipayEcoMycarParkingEnterinfoSyncResponse response = (AlipayEcoMycarParkingEnterinfoSyncResponse) getResponse(request, null, builder.getAppAuthToken());
        AlipayParkingVehicleEnterResult result = new AlipayParkingVehicleEnterResult(response);
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
