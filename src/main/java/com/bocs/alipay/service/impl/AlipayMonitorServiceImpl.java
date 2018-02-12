package com.bocs.alipay.service.impl;

import com.alipay.api.AlipayClient;
import com.alipay.api.request.MonitorHeartbeatSynRequest;
import com.alipay.api.response.MonitorHeartbeatSynResponse;
import com.bocs.alipay.model.builder.AlipayHeartbeatSynRequestBuilder;
import com.bocs.alipay.service.AlipayMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by liuyangkly on 15/10/22.
 */
@Service(value = "alipayMonitorService")
public class AlipayMonitorServiceImpl extends AbsAlipayService implements AlipayMonitorService {


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
    public MonitorHeartbeatSynResponse heartbeatSyn(AlipayHeartbeatSynRequestBuilder builder) {
        validateBuilder(builder);

        MonitorHeartbeatSynRequest request = new MonitorHeartbeatSynRequest();
        request.putOtherTextParam("app_auth_token", builder.getAppAuthToken());
        request.setBizContent(builder.toJsonString());
        log.info("heartbeat.sync bizContent:" + request.getBizContent());

        return (MonitorHeartbeatSynResponse) getResponse(request);
    }
}
