package com.bocs.alipay.trade.model.builder;

import com.bocs.alipay.trade.utils.GsonFactory;

/**
 * Created by liuyangkly on 15/7/31.
 */
public abstract class RequestBuilder {
    private String appAuthToken;
    private String notifyUrl;

    /**
     * 验证请求对象
     * @return
     */
    public abstract boolean validate();

    /**
     * 获取bizContent对象，用于下一步转换为json字符串
     * @return
     */
    public abstract Object getBizContent();

    /**
     * 将bizContent对象转换为json字符串
     * @return
     */
    public String toJsonString() {
        // 使用gson将对象转换为json字符串
        return GsonFactory.getGson().toJson(this.getBizContent());
    }

    @Override
    public String toString() {
        return "{" +
                "appAuthToken='" + appAuthToken + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                '}';
    }

    public String getAppAuthToken() {
        return appAuthToken;
    }

    public RequestBuilder setAppAuthToken(String appAuthToken) {
        this.appAuthToken = appAuthToken;
        return this;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public RequestBuilder setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
        return this;
    }


}
