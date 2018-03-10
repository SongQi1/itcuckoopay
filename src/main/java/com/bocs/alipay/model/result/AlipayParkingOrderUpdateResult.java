package com.bocs.alipay.model.result;

import com.alipay.api.response.AlipayEcoMycarParkingOrderUpdateResponse;
import com.bocs.alipay.model.TradeStatus;

/**
 * Description:<p>ISV更新订单结果至支付宝停车平台返回的结果  </p>
 * Created by songqi on 2018/3/10.
 */
public class AlipayParkingOrderUpdateResult implements Result {

    private TradeStatus tradeStatus;


    private AlipayEcoMycarParkingOrderUpdateResponse response;

    public AlipayParkingOrderUpdateResult(AlipayEcoMycarParkingOrderUpdateResponse response){
        this.response = response;
    }

    @Override
    public boolean isTradeSuccess() {
        return response != null &&
                TradeStatus.SUCCESS.equals(tradeStatus);
    }


    public TradeStatus getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(TradeStatus tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public AlipayEcoMycarParkingOrderUpdateResponse getResponse() {
        return response;
    }

    public void setResponse(AlipayEcoMycarParkingOrderUpdateResponse response) {
        this.response = response;
    }
}
