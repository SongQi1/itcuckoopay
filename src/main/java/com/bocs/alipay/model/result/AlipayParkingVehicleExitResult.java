package com.bocs.alipay.model.result;

import com.alipay.api.response.AlipayEcoMycarParkingExitinfoSyncResponse;
import com.bocs.alipay.model.TradeStatus;

/**
 * 描述:<p>车辆离场信息同步。上传车辆离开停车场信息到支付宝接口返回结果 </p>
 *
 * @Author: songqi
 * @Date: 2018/2/24 13:41
 */
public class AlipayParkingVehicleExitResult implements Result{
    private TradeStatus tradeStatus;

    private AlipayEcoMycarParkingExitinfoSyncResponse response;

    public AlipayParkingVehicleExitResult(AlipayEcoMycarParkingExitinfoSyncResponse response){
        this.response = response;
    }


    public TradeStatus getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(TradeStatus tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public AlipayEcoMycarParkingExitinfoSyncResponse getResponse() {
        return response;
    }

    public void setResponse(AlipayEcoMycarParkingExitinfoSyncResponse response) {
        this.response = response;
    }

    @Override
    public boolean isTradeSuccess() {
        return response != null &&
                TradeStatus.SUCCESS.equals(tradeStatus);
    }
}
