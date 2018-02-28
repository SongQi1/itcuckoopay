package com.bocs.alipay.model.result;

import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.bocs.alipay.model.TradeStatus;

/**
 * Description:<p>用auth_code换取授权访问令牌结果 </p>
 * Created by songqi on 2018/2/28.
 */
public class AlipaySystemOauthTokenRequestResult implements Result{

    private TradeStatus tradeStatus;

    private AlipaySystemOauthTokenResponse response;

    public AlipaySystemOauthTokenRequestResult(AlipaySystemOauthTokenResponse response){
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

    public AlipaySystemOauthTokenResponse getResponse() {
        return response;
    }

    public void setResponse(AlipaySystemOauthTokenResponse response) {
        this.response = response;
    }
}
