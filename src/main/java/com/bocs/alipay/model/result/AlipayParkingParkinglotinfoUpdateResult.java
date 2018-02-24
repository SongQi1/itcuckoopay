package com.bocs.alipay.model.result;

import com.alipay.api.response.AlipayEcoMycarParkingParkinglotinfoCreateResponse;
import com.alipay.api.response.AlipayEcoMycarParkingParkinglotinfoUpdateResponse;
import com.bocs.alipay.model.TradeStatus;

/**
 * 描述:<p> 更新停车场信息结果 </p>
 *
 * @Author: songqi
 * @Date: 2018/2/23 16:05
 */
public class AlipayParkingParkinglotinfoUpdateResult implements Result{
    private TradeStatus tradeStatus;

    private AlipayEcoMycarParkingParkinglotinfoUpdateResponse response;

    public AlipayParkingParkinglotinfoUpdateResult(AlipayEcoMycarParkingParkinglotinfoUpdateResponse response){
        this.response = response;
    }


    public TradeStatus getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(TradeStatus tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public AlipayEcoMycarParkingParkinglotinfoUpdateResponse getResponse() {
        return response;
    }

    public void setResponse(AlipayEcoMycarParkingParkinglotinfoUpdateResponse response) {
        this.response = response;
    }

    @Override
    public boolean isTradeSuccess() {
        return response != null &&
                TradeStatus.SUCCESS.equals(tradeStatus);
    }
}
