package com.bocs.alipay.service;

import com.alipay.api.response.AlipayOpenAuthTokenAppResponse;
import com.bocs.alipay.model.builder.AlipayOpenAuthTokenAppRequestBuilder;
import com.bocs.alipay.model.builder.AlipaySystemOauthTokenRequestBuilder;
import com.bocs.alipay.model.result.AlipaySystemOauthTokenRequestResult;

/**
 * Description:<p>授权 </p>
 * Created by songqi on 2018/2/6.
 */
public interface AlipayAuthService {


    /**
     * 获取/更新第三方应用授权Token。通过此接口获取商户的appAuthToken，然后用此appAuthToken代替商户发取当面付等一系列的操作
     * @param builder
     * @return
     */
    AlipayOpenAuthTokenAppResponse openAuthTokenApp(AlipayOpenAuthTokenAppRequestBuilder builder);


    /**
     * 获取用户的授权。用户请求用支付宝账号登录，访问商户特殊的URL
     * (url拼接规则：https://openauth.alipay.com/oauth2/publicAppAuthorize.htm?app_id=APPID&scope=SCOPE&redirect_uri=ENCODED_URL)
     * 跳转到支付宝的登录授权页面，用户确认登录后，支付宝将用户的auth_code返回给商户指定的地址（即redirect_uri中指定的地址）。商户后台拿auth_code调用此方法换
     * 取用户access_token与user_id
     * @param builder
     * @return
     */
    AlipaySystemOauthTokenRequestResult systemOauthToken(AlipaySystemOauthTokenRequestBuilder builder);

}
