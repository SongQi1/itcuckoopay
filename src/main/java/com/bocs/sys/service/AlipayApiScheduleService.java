package com.bocs.sys.service;

import com.alipay.api.response.MonitorHeartbeatSynResponse;
import com.alipay.trade.model.builder.AlipayHeartbeatSynRequestBuilder;
import com.alipay.trade.service.AlipayMonitorService;
import com.alipay.trade.service.impl.hb.HbQueue;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 描述:<p> 支付宝相关的定时任务</p>
 *
 * @Author: songqi
 * @Date: 2018/2/8 15:21
 */
@Service
public class AlipayApiScheduleService {

    protected Log log = LogFactory.getLog(getClass());

    @Autowired
    private AlipayMonitorService monitorService;

    /**
     * 每隔5分钟同步交易到支付宝云监控平台，帮助分析交易性能
     */
    public void alipayHeartbeatSyn(){

        AlipayHeartbeatSynRequestBuilder builder = new AlipayHeartbeatSynRequestBuilder()
                .setSysTradeInfoList(HbQueue.poll())
                .setStoreId("DF")
                .setNetworkType("LAN")
                .setEquipmentId("98-EE-CB-5A-42-22");
        MonitorHeartbeatSynResponse response = monitorService.heartbeatSyn(builder);

        StringBuilder sb = new StringBuilder(response.getCode())
                .append(":")
                .append(response.getMsg());
        if (StringUtils.isNotEmpty(response.getSubCode())) {
            sb.append(", ")
                    .append(response.getSubCode())
                    .append(":")
                    .append(response.getSubMsg());
        }
        log.info(sb.toString());
    }


    /**
     * 每隔
     */
    public void autoRefreshAppAuthToken(){


    }

}
