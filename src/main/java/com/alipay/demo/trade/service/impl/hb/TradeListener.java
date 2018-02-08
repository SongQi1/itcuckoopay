package com.alipay.demo.trade.service.impl.hb;

/**
 * Created by liuyangkly on 15/10/27.
 */
public interface TradeListener {

    /**
     * 支付成功
     * @param outTradeNo
     * @param beforeCall
     */
    void onPayTradeSuccess(String outTradeNo, long beforeCall);

    /**
     * 支付处理中
     * @param outTradeNo
     * @param beforeCall
     */
    void onPayInProgress(String outTradeNo, long beforeCall);

    /**
     * 支付失败
     * @param outTradeNo
     * @param beforeCall
     */
    void onPayFailed(String outTradeNo, long beforeCall);

    /**
     * 建立连接异常
     * @param outTradeNo
     * @param beforeCall
     */
    void onConnectException(String outTradeNo, long beforeCall);

    /**
     * 报文上送异常
     * @param outTradeNo
     * @param beforeCall
     */
    void onSendException(String outTradeNo, long beforeCall);

    /**
     * 报文接收异常
      * @param outTradeNo
     * @param beforeCall
     */
    void onReceiveException(String outTradeNo, long beforeCall);
}
