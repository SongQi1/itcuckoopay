package com.bocs.alipay.model.builder;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.StringUtils;

/**
 * 描述:<p>获取用户access_token请求 </p>
 *
 * @Author: songqi
 * @Date: 2018/2/27 16:51
 */
public class AlipaySystemOauthTokenRequestBuilder extends RequestBuilder{

    final String AUTHORIZATION_CODE = "authorization_code";
    final String REFRESH_TOKEN = "refresh_token";

    private BizContent bizContent = new BizContent();
    @Override
    public boolean validate() {
        if(StringUtils.isEmpty(bizContent.grantType)){
            throw new NullPointerException("grant_type should not be NULL!");
        }
        if(AUTHORIZATION_CODE.equalsIgnoreCase(bizContent.grantType) && StringUtils.isEmpty(bizContent.code)){
            throw new NullPointerException("code should not be NULL!");
        }
        if(REFRESH_TOKEN.equalsIgnoreCase(bizContent.grantType) && StringUtils.isEmpty(bizContent.refreshToken)){
            throw new NullPointerException("refresh_token should not be NULL!");
        }
        return true;
    }

    @Override
    public BizContent getBizContent() {
        return bizContent;
    }

    @Override
    public AlipaySystemOauthTokenRequestBuilder setAppAuthToken(String appAuthToken) {
        return (AlipaySystemOauthTokenRequestBuilder) super.setAppAuthToken(appAuthToken);
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AlipaySystemOauthTokenRequestBuilder{");
        sb.append("bizContent=").append(bizContent);
        sb.append(", commonParams=").append(super.toString());
        sb.append('}');
        return sb.toString();
    }


    public String getGrantType() {
        return bizContent.grantType;
    }

    public AlipaySystemOauthTokenRequestBuilder setGrantType(String grantType) {
        bizContent.grantType = grantType;
        return this;
    }

    public String getCode() {
        return bizContent.code;
    }

    public AlipaySystemOauthTokenRequestBuilder setCode(String code) {
        bizContent.code = code;
        return this;
    }

    public String getRefreshToken() {
        return bizContent.refreshToken;
    }

    public AlipaySystemOauthTokenRequestBuilder setRefreshToken(String refreshToken) {
        bizContent.refreshToken = refreshToken;
        return this;
    }

    public static class BizContent{

        /**
         * 值为authorization_code时，代表用code换取；
         * 值为refresh_token时，代表用refresh_token换取
         */
        @SerializedName("grant_type")
        private String grantType;

        /**
         * 授权码，用户对应用授权后得到。
         */
        @SerializedName("code")
        private String code;

        /**
         * 刷刷新令牌，上次换取访问令牌时得到。
         * 见出参的refresh_token字段
         */
        @SerializedName("refresh_token")
        private String refreshToken;



        @Override
        public String toString() {
            return "{" +
                    "grantType='" + grantType + '\'' +
                    ", code='" + code + '\'' +
                    ", refreshToken='" + refreshToken + '\'' +
                    '}';
        }
    }
}
