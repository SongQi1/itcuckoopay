package com.alipay.trade.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayRequest;
import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.util.json.JSONWriter;
import com.alipay.trade.model.builder.RequestBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by liuyangkly on 15/10/22.
 */
abstract class AbsAlipayService {
    protected Log log = LogFactory.getLog(getClass());


    protected AlipayClient alipayClient;

    /**
     * 验证bizContent对象
     * @param builder
     */
    protected void validateBuilder(RequestBuilder builder) {
        if (builder == null) {
            throw new NullPointerException("builder should not be NULL!");
        }

        if (!builder.validate()) {
            throw new IllegalStateException("builder validate failed! " + builder.toString());
        }
    }

    /**
     * 调用AlipayClient的execute方法，进行远程调用
     * @param request
     * @return
     */
    protected AlipayResponse getResponse(AlipayRequest request) {
        try {
            log.info("支付宝请求报文：" + new JSONWriter().write(request));
            AlipayResponse response = alipayClient.execute(request);
            if (response != null) {
                log.info("支付宝返回报文：" + new JSONWriter().write(response));
            }
            return response;

        } catch (AlipayApiException e) {
            e.printStackTrace();
            return null;
        }
    }
}
