package com.bocs.alipay.model.builder;

import com.bocs.alipay.model.hb.*;
import com.bocs.alipay.utils.Utils;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by liuyangkly on 16/3/2.
 */
public class AlipayHeartbeatSynRequestBuilder extends RequestBuilder {




    private BizContent bizContent = new BizContent();

    @Override
    public BizContent getBizContent() {
        return bizContent;
    }

    @Override
    public boolean validate() {
        if (bizContent.product == null) {
            throw new NullPointerException("product should not be NULL!");
        }
        if (bizContent.type == null) {
            throw new NullPointerException("type should not be NULL!");
        }
        if (StringUtils.isEmpty(bizContent.equipmentId)) {
            throw new NullPointerException("equipment_id should not be NULL!");
        }

        if (StringUtils.isEmpty(bizContent.time)) {
            throw new NullPointerException("time should not be NULL!");
        }

        if(StringUtils.isEmpty(bizContent.storeId)){
            throw new NullPointerException("store_id should not be NULL!");
        }
        if(StringUtils.isEmpty(bizContent.networkType)){
            throw new NullPointerException("network_type should not be NULL!");
        }

        return true;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AlipayHeartbeatSynRequestBuilder{");
        sb.append("bizContent=").append(bizContent);
        sb.append(", commonParams=").append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    public AlipayHeartbeatSynRequestBuilder(){
        bizContent.product = Product.FP;
        bizContent.type = Type.CR;
        bizContent.time = Utils.toDate(new Date());
    }

    @Override
    public AlipayHeartbeatSynRequestBuilder setAppAuthToken(String appAuthToken) {
        return (AlipayHeartbeatSynRequestBuilder) super.setAppAuthToken(appAuthToken);
    }

    @Override
    public AlipayHeartbeatSynRequestBuilder setNotifyUrl(String notifyUrl) {
        return (AlipayHeartbeatSynRequestBuilder) super.setNotifyUrl(notifyUrl);
    }

    public String getMac() {
        return bizContent.mac;
    }

    public AlipayHeartbeatSynRequestBuilder setMac(String mac) {
        bizContent.mac = mac;
        return this;
    }

    public String getNetworkType() {
        return bizContent.networkType;
    }

    public AlipayHeartbeatSynRequestBuilder setNetworkType(String networkType) {
        bizContent.networkType = networkType;
        return this;
    }

    public String getSysServiceProviderId() {
        return bizContent.sysServiceProviderId;
    }

    public AlipayHeartbeatSynRequestBuilder setSysServiceProviderId(String sysServiceProviderId) {
        bizContent.sysServiceProviderId = sysServiceProviderId;
        return this;
    }


    public String getEquipmentId() {
        return bizContent.equipmentId;
    }

    public AlipayHeartbeatSynRequestBuilder setEquipmentId(String equipmentId) {
        bizContent.equipmentId = equipmentId;
        return this;
    }


    public List<ExceptionInfo> getExceptionInfoList() {
        return bizContent.exceptionInfoList;
    }

    public AlipayHeartbeatSynRequestBuilder setExceptionInfoList(List<ExceptionInfo> exceptionInfoList) {
        bizContent.exceptionInfoList = exceptionInfoList;
        return this;
    }

    public Map<String, Object> getExtendInfo() {
        return bizContent.extendInfo;
    }

    public AlipayHeartbeatSynRequestBuilder setExtendInfo(Map<String, Object> extendInfo) {
        bizContent.extendInfo = extendInfo;
        return this;
    }

    public Product getProduct() {
        return bizContent.product;
    }

    public AlipayHeartbeatSynRequestBuilder setProduct(Product product) {
        bizContent.product = product;
        return this;
    }

    public String getStoreId() {
        return bizContent.storeId;
    }

    public AlipayHeartbeatSynRequestBuilder setStoreId(String storeId) {
        bizContent.storeId = storeId;
        return this;
    }

    public String getTime() {
        return bizContent.time;
    }

    public AlipayHeartbeatSynRequestBuilder setTime(String time) {
        bizContent.time = time;
        return this;
    }

    public List<TradeInfo> getTradeInfoList() {
        return bizContent.tradeInfoList;
    }

    public AlipayHeartbeatSynRequestBuilder setSysTradeInfoList(List<SysTradeInfo> sysTradeInfoList) {
        if (Utils.isListNotEmpty(sysTradeInfoList)) {
            bizContent.tradeInfoList = new ArrayList<TradeInfo>(sysTradeInfoList);
        }
        return this;
    }

    public AlipayHeartbeatSynRequestBuilder setPosTradeInfoList(List<PosTradeInfo> posTradeInfoList) {
        if (Utils.isListNotEmpty(posTradeInfoList)) {
            bizContent.tradeInfoList = new ArrayList<TradeInfo>(posTradeInfoList);
        }
        return this;
    }

    public Type getType() {
        return bizContent.type;
    }

    public AlipayHeartbeatSynRequestBuilder setType(Type type) {
        bizContent.type = type;
        return this;
    }

    public static class BizContent {
        private Product product;

        private Type type;

        @SerializedName("equipment_id")
        private String equipmentId;


        private String time;


        @SerializedName("store_id")
        private String storeId;



        @SerializedName("network_type")
        private String networkType;

        @SerializedName("sys_service_provider_id")
        private String sysServiceProviderId;

        private String mac;

        @SerializedName("trade_info")
        private List<TradeInfo> tradeInfoList;

        @SerializedName("exception_info")
        private List<ExceptionInfo> exceptionInfoList;

        @SerializedName("extend_info")
        private Map<String, Object> extendInfo;

        @Override
        public String toString() {
            return "{" +
                    "product=" + product +
                    ", type=" + type +
                    ", equipmentId='" + equipmentId + '\'' +
                    ", time='" + time + '\'' +
                    ", storeId='" + storeId + '\'' +
                    ", networkType='" + networkType + '\'' +
                    ", sysServiceProviderId='" + sysServiceProviderId + '\'' +
                    ", mac='" + mac + '\'' +
                    ", tradeInfoList=" + tradeInfoList +
                    ", exceptionInfoList=" + exceptionInfoList +
                    ", extendInfo=" + extendInfo +
                    '}';
        }
    }
}
