package com.bocs.sys.service;

import com.alipay.api.response.AlipayOpenAuthTokenAppResponse;
import com.alipay.demo.trade.model.builder.AlipayOpenAuthTokenAppRequestBuilder;
import com.alipay.demo.trade.service.AlipayAuthService;
import com.bocs.core.exception.BusinessException;
import com.bocs.sys.model.AlipayOpenAuthToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:<p> </p>
 * Created by songqi on 2018/2/2.
 */

@Service
public class AlipayApiService {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AlipayAuthService alipayAuthService;



    public void openAppAuthToken(String app_auth_code, String app_id){

        AlipayOpenAuthTokenAppRequestBuilder builder = new AlipayOpenAuthTokenAppRequestBuilder()
                .setCode(app_auth_code).setGrantType("authorization_code");

        AlipayOpenAuthTokenAppResponse response = alipayAuthService.opentAuthTokenApp(builder);

        if(response.isSuccess()){
            AlipayOpenAuthToken token = new AlipayOpenAuthToken();

            token.setAppAuthToken(response.getAppAuthToken());
            token.setAppRefreshToken(response.getAppRefreshToken());
            token.setUserId(response.getUserId());
            token.setExpiresIn(Long.parseLong(response.getExpiresIn()));
            token.setReExpiresIn(Long.parseLong(response.getReExpiresIn()));
            token.setAuthAppId(response.getAuthAppId());
            token.insert();
        }else{
            throw new BusinessException("授权失败，请重试！");
        }


    }


    public void refreshAppAuthToken(String app_refresh_token){
        AlipayOpenAuthTokenAppRequestBuilder builder = new AlipayOpenAuthTokenAppRequestBuilder()
                .setGrantType("refresh_token").setRefreshToken(app_refresh_token);
        AlipayOpenAuthTokenAppResponse response = alipayAuthService.opentAuthTokenApp(builder);
        System.out.println(response);
    }
}
