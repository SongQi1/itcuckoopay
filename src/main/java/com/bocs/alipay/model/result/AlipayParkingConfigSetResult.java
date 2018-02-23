package com.bocs.alipay.model.result;

import com.alipay.api.response.AlipayEcoMycarParkingConfigSetResponse;
import com.bocs.alipay.model.TradeStatus;

/**
 * 描述:<p>配置ISV停车业务信息结果 </p>
 *
 * @Author: songqi
 * @Date: 2018/2/23 15:45
 */
public class AlipayParkingConfigSetResult implements Result{

    private TradeStatus tradeStatus;

    private AlipayEcoMycarParkingConfigSetResponse response;


    public AlipayParkingConfigSetResult(AlipayEcoMycarParkingConfigSetResponse response){
        this.response = response;
    }


    public TradeStatus getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(TradeStatus tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public AlipayEcoMycarParkingConfigSetResponse getResponse() {
        return response;
    }

    public void setResponse(AlipayEcoMycarParkingConfigSetResponse response) {
        this.response = response;
    }

    @Override
    public boolean isTradeSuccess() {
        return response != null &&
                TradeStatus.SUCCESS.equals(tradeStatus);
    }
}
