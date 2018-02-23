package com.bocs.alipay.model.result;

import com.alipay.api.response.AlipayEcoMycarParkingConfigQueryResponse;
import com.alipay.api.response.AlipayEcoMycarParkingConfigSetResponse;
import com.bocs.alipay.model.TradeStatus;

/**
 * 描述:<p>查询ISV停车业务配置信息结果 </p>
 *
 * @Author: songqi
 * @Date: 2018/2/23 15:45
 */
public class AlipayParkingConfigQueryResult implements Result{

    private TradeStatus tradeStatus;

    private AlipayEcoMycarParkingConfigQueryResponse response;


    public AlipayParkingConfigQueryResult(AlipayEcoMycarParkingConfigQueryResponse response){
        this.response = response;
    }


    public TradeStatus getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(TradeStatus tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public AlipayEcoMycarParkingConfigQueryResponse getResponse() {
        return response;
    }

    public void setResponse(AlipayEcoMycarParkingConfigQueryResponse response) {
        this.response = response;
    }

    @Override
    public boolean isTradeSuccess() {
        return response != null &&
                TradeStatus.SUCCESS.equals(tradeStatus);
    }
}
