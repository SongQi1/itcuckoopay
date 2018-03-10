package com.bocs.alipay.model.result;

import com.alipay.api.response.AlipayEcoMycarParkingOrderSyncResponse;
import com.bocs.alipay.model.TradeStatus;

/**
 * Description:<p>ISV停车支付订单同步结果  </p>
 * Created by songqi on 2018/3/10.
 */
public class AlipayParkingOrderSyncResult implements Result {

    private TradeStatus tradeStatus;


    private AlipayEcoMycarParkingOrderSyncResponse response;

    public AlipayParkingOrderSyncResult(AlipayEcoMycarParkingOrderSyncResponse response){
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

    public AlipayEcoMycarParkingOrderSyncResponse getResponse() {
        return response;
    }

    public void setResponse(AlipayEcoMycarParkingOrderSyncResponse response) {
        this.response = response;
    }
}
