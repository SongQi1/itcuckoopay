package com.bocs.alipay.model.builder;

/**
 * 描述:<p>oAuth授权 </p>
 *
 * @Author: songqi
 * @Date: 2018/2/27 16:51
 */
public class AlipaySystemOauthTokenRequestBuilder extends RequestBuilder{
    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public Object getBizContent() {
        return null;
    }
}
