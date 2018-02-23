package com.bocs.alipay.model.result;

import com.alipay.api.response.AlipayEcoMycarParkingParkinglotinfoCreateResponse;
import com.bocs.alipay.model.TradeStatus;

/**
 * 描述:<p> 录入停车场信息结果 </p>
 *
 * @Author: songqi
 * @Date: 2018/2/23 16:05
 */
public class AlipayParkinglotinfoCreateResult implements Result{
    private TradeStatus tradeStatus;

    private AlipayEcoMycarParkingParkinglotinfoCreateResponse response;

    public AlipayParkinglotinfoCreateResult(AlipayEcoMycarParkingParkinglotinfoCreateResponse response){
        this.response = response;
    }


    public TradeStatus getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(TradeStatus tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public AlipayEcoMycarParkingParkinglotinfoCreateResponse getResponse() {
        return response;
    }

    public void setResponse(AlipayEcoMycarParkingParkinglotinfoCreateResponse response) {
        this.response = response;
    }

    @Override
    public boolean isTradeSuccess() {
        return response != null &&
                TradeStatus.SUCCESS.equals(tradeStatus);
    }
}
