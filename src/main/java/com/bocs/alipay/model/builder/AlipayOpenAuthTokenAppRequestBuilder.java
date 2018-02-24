package com.bocs.alipay.model.builder;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.StringUtils;

/**
 * 描述:<p> </p>
 *
 * @Author: songqi
 * @Date: 2018/2/7 13:58
 */
public class AlipayOpenAuthTokenAppRequestBuilder extends RequestBuilder{
    private BizContent bizContent = new BizContent();
    final String AUTHORIZATION_CODE = "authorization_code";
    final String REFRESH_TOKEN = "refresh_token";

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


    public String getGrantType() {
        return bizContent.grantType;
    }

    public AlipayOpenAuthTokenAppRequestBuilder setGrantType(String grantType) {
        bizContent.grantType = grantType;
        return this;
    }

    public String getCode() {
        return bizContent.code;
    }

    public AlipayOpenAuthTokenAppRequestBuilder setCode(String code) {
        bizContent.code = code;
        return this;
    }


    public String getRefreshToken() {
        return bizContent.refreshToken;
    }

    public AlipayOpenAuthTokenAppRequestBuilder setRefreshToken(String refreshToken) {
        bizContent.refreshToken = refreshToken;
        return this;
    }



    public static class BizContent {
        @SerializedName("grant_type")
        private String grantType;

        private String code;

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
