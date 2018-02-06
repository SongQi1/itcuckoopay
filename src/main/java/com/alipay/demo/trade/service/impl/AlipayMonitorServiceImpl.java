package com.alipay.demo.trade.service.impl;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.MonitorHeartbeatSynRequest;
import com.alipay.api.response.MonitorHeartbeatSynResponse;
import com.alipay.demo.trade.config.Configs;
import com.alipay.demo.trade.model.builder.AlipayHeartbeatSynRequestBuilder;
import com.alipay.demo.trade.service.AlipayMonitorService;
import com.bocs.core.util.PropertiesUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liuyangkly on 15/10/22.
 */
@Service(value = "alipayMonitorService")
public class AlipayMonitorServiceImpl extends AbsAlipayService implements AlipayMonitorService {



    @Autowired
    private Configs configs;


    @Override
    public MonitorHeartbeatSynResponse heartbeatSyn(AlipayHeartbeatSynRequestBuilder builder) {
        validateBuilder(builder);

        MonitorHeartbeatSynRequest request = new MonitorHeartbeatSynRequest();
        request.putOtherTextParam("app_auth_token", builder.getAppAuthToken());
        request.setBizContent(builder.toJsonString());
        log.info("heartbeat.sync bizContent:" + request.getBizContent());

        AlipayClient client = new DefaultAlipayClient(configs.getMcloudApiDomain(), configs.getAppid(), configs.getPrivateKey(),
                "json", "utf-8", "RSA2");
        return (MonitorHeartbeatSynResponse) getResponse(client, request);
    }
}
