package com.bocs.alipay.model.builder;

import com.bocs.alipay.utils.GsonFactory;

/**
 * Created by liuyangkly on 15/7/31.
 */
public abstract class RequestBuilder {

    /**
     * 应用授权Token。开发者通过此appAuthToken代替商户发起当面付的收单请求
     */
    private String appAuthToken;


    /**
     * 用户授权Token。
     */
    private String accessToken;

    /**
     *
     */
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

    public String getAccessToken() {
        return accessToken;
    }

    public RequestBuilder setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }
}
