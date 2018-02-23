package com.bocs.alipay.model.result;

import com.alipay.api.response.AlipayTradeCreateResponse;
import com.bocs.alipay.model.TradeStatus;

/**
 * 描述:<p> </p>
 *
 * @Author: songqi
 * @Date: 2018/2/23 9:59
 */
public class AlipayF2FCreateResult implements Result {

    private TradeStatus tradeStatus;

    private AlipayTradeCreateResponse response;


    public AlipayF2FCreateResult(AlipayTradeCreateResponse response){
        this.response = response;
    }

    public TradeStatus getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(TradeStatus tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public AlipayTradeCreateResponse getResponse() {
        return response;
    }

    public void setResponse(AlipayTradeCreateResponse response) {
        this.response = response;
    }

    @Override
    public boolean isTradeSuccess() {
        return response != null &&
                TradeStatus.SUCCESS.equals(tradeStatus);
    }
}
