package com.bocs.alipay.service.impl;

import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayOpenAuthTokenAppRequest;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.response.AlipayOpenAuthTokenAppResponse;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.bocs.alipay.config.Constants;
import com.bocs.alipay.model.TradeStatus;
import com.bocs.alipay.model.builder.AlipayOpenAuthTokenAppRequestBuilder;
import com.bocs.alipay.model.builder.AlipaySystemOauthTokenRequestBuilder;
import com.bocs.alipay.model.result.AlipaySystemOauthTokenRequestResult;
import com.bocs.alipay.service.AlipayAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * 描述:<p> </p>
 *
 * @Author: songqi
 * @Date: 2018/2/7 14:27
 */
@Service("alipayAuthService")
public class AlipayAuthServiceImpl extends AbsAlipayService implements AlipayAuthService{

    @Autowired
    protected AlipayClient alipayClient ;


    /**
     * @PostConstruct是Java EE 5引入的注解，Spring允许开发者在受管Bean中使用它。
     * 当DI容器实例化当前受管Bean时，@PostConstruct注解的方法会被自动触发，从而完成一些初始化工作
     */
    @PostConstruct
    public void initAlipayClient(){
        super.alipayClient = alipayClient;
    }


    @Override
    public AlipayOpenAuthTokenAppResponse openAuthTokenApp(AlipayOpenAuthTokenAppRequestBuilder builder) {
        validateBuilder(builder);

        AlipayOpenAuthTokenAppRequest request = new AlipayOpenAuthTokenAppRequest();
        request.setBizContent(builder.toJsonString());
        log.info("alipay.open.auth.token.app bizContent:" + request.getBizContent());

        return (AlipayOpenAuthTokenAppResponse) getResponse(request);
    }

    @Override
    public AlipaySystemOauthTokenRequestResult systemOauthToken(AlipaySystemOauthTokenRequestBuilder builder) {
        validateBuilder(builder);
        AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
        request.setGrantType(builder.getGrantType());
        request.setCode(builder.getCode());
        request.setRefreshToken(builder.getRefreshToken());
        AlipaySystemOauthTokenResponse response = (AlipaySystemOauthTokenResponse) getResponse(request, null, builder.getAppAuthToken());

        AlipaySystemOauthTokenRequestResult result = new AlipaySystemOauthTokenRequestResult(response);
        if (response != null && Constants.SUCCESS.equals(response.getCode())) {
            //交易成功
            result.setTradeStatus(TradeStatus.SUCCESS);

        } else if (tradeError(response)) {
            // 系统发生异常，状态未知
            result.setTradeStatus(TradeStatus.UNKNOWN);

        } else {
            // 其他情况表明该交易明确失败
            result.setTradeStatus(TradeStatus.FAILED);
        }
        return result;
    }

}
