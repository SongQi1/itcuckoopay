package com.bocs.alipay.model.result;

import com.alipay.api.response.AlipayEcoMycarParkingVehicleQueryResponse;
import com.bocs.alipay.model.TradeStatus;

/**
 * Description:<p>根据车辆ID查询车牌返回结果 </p>
 * Created by songqi on 2018/2/27.
 */
public class AlipayParkingVehicleQueryResult implements Result{
    private TradeStatus tradeStatus;

    private AlipayEcoMycarParkingVehicleQueryResponse response;

    public AlipayParkingVehicleQueryResult(AlipayEcoMycarParkingVehicleQueryResponse response){
        this.response = response;
    }

    public TradeStatus getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(TradeStatus tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public AlipayEcoMycarParkingVehicleQueryResponse getResponse() {
        return response;
    }

    public void setResponse(AlipayEcoMycarParkingVehicleQueryResponse response) {
        this.response = response;
    }

    @Override
    public boolean isTradeSuccess() {
        return response != null &&
                TradeStatus.SUCCESS.equals(tradeStatus);
    }
}
