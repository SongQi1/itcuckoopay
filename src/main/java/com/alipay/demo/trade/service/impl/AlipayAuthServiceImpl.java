package com.alipay.demo.trade.service.impl;

import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayOpenAuthTokenAppRequest;
import com.alipay.api.response.AlipayOpenAuthTokenAppResponse;
import com.alipay.demo.trade.model.builder.AlipayOpenAuthTokenAppRequestBuilder;
import com.alipay.demo.trade.service.AlipayAuthService;
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
    public AlipayOpenAuthTokenAppResponse opentAuthTokenApp(AlipayOpenAuthTokenAppRequestBuilder builder) {
        validateBuilder(builder);

        AlipayOpenAuthTokenAppRequest request = new AlipayOpenAuthTokenAppRequest();
        request.setBizContent(builder.toJsonString());
        log.info("alipay.open.auth.token.app bizContent:" + request.getBizContent());

        return (AlipayOpenAuthTokenAppResponse) getResponse(request);
    }

}
