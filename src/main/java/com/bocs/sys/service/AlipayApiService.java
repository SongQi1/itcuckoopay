package com.bocs.sys.service;

import com.alipay.api.response.AlipayOpenAuthTokenAppResponse;
import com.bocs.alipay.model.builder.AlipayOpenAuthTokenAppRequestBuilder;
import com.bocs.alipay.service.AlipayAuthService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.bocs.core.exception.BusinessException;
import com.bocs.sys.mapper.AlipayOpenAuthTokenMapper;
import com.bocs.sys.model.AlipayOpenAuthToken;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Description:<p> </p>
 * Created by songqi on 2018/2/2.
 */

@Service
public class AlipayApiService {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AlipayAuthService alipayAuthService;
    @Autowired
    private AlipayOpenAuthTokenMapper alipayOpenAuthTokenMapper;


    /**
     * 获取第三方商户授权的token，取获取 appAuthToken，用来替代商户发起交易
     * @param app_auth_code
     * @param app_id
     */
    public void openAppAuthToken(String app_auth_code, String app_id){

        AlipayOpenAuthTokenAppRequestBuilder builder = new AlipayOpenAuthTokenAppRequestBuilder()
                .setCode(app_auth_code).setGrantType("authorization_code");

        AlipayOpenAuthTokenAppResponse response = alipayAuthService.openAuthTokenApp(builder);

        if(response.isSuccess()){
            AlipayOpenAuthToken token = new AlipayOpenAuthToken();

            token.setAppAuthToken(response.getAppAuthToken());
            token.setAppRefreshToken(response.getAppRefreshToken());
            token.setUserId(response.getUserId());
            token.setExpiresIn(Long.parseLong(response.getExpiresIn()));
            token.setExpiresInDateTime(DateUtils.addSeconds(new Date(), Integer.valueOf(response.getExpiresIn())));
            token.setReExpiresIn(Long.parseLong(response.getReExpiresIn()));
            token.setReExpiresInDateTime(DateUtils.addSeconds(new Date(), Integer.valueOf(response.getReExpiresIn())));
            token.setAuthAppId(response.getAuthAppId());
            token.insert();
        }else{
            throw new BusinessException(response.getSubMsg());
        }
    }


    /**
     * 更新商户的appAuthToken
     * @param app_refresh_token
     */
    public void refreshAppAuthToken(String app_refresh_token){
        AlipayOpenAuthTokenAppRequestBuilder builder = new AlipayOpenAuthTokenAppRequestBuilder()
                .setGrantType("refresh_token").setRefreshToken(app_refresh_token);
        AlipayOpenAuthTokenAppResponse response = alipayAuthService.openAuthTokenApp(builder);
        if(response.isSuccess()){
            List<AlipayOpenAuthToken> alipayOpenAuthTokenList = alipayOpenAuthTokenMapper.selectList(new EntityWrapper<AlipayOpenAuthToken>().eq("appRefreshToken", app_refresh_token));
            if(alipayOpenAuthTokenList != null && alipayOpenAuthTokenList.size() > 0){
                AlipayOpenAuthToken alipayOpenAuthTokenDb = alipayOpenAuthTokenList.get(0);

                alipayOpenAuthTokenDb.setAppRefreshToken(response.getAppRefreshToken());
                alipayOpenAuthTokenDb.setAppAuthToken(response.getAppAuthToken());

                alipayOpenAuthTokenDb.setExpiresIn(Long.valueOf(response.getExpiresIn()));
                alipayOpenAuthTokenDb.setExpiresInDateTime(DateUtils.addSeconds(new Date(), Integer.valueOf(response.getExpiresIn())));

                alipayOpenAuthTokenDb.setReExpiresIn(Long.valueOf(response.getReExpiresIn()));
                alipayOpenAuthTokenDb.setReExpiresInDateTime(DateUtils.addSeconds(new Date(), Integer.valueOf(response.getReExpiresIn())));

                alipayOpenAuthTokenDb.updateById();
                alipayOpenAuthTokenMapper.updateById(alipayOpenAuthTokenDb);
            }
        }else{
            throw new BusinessException(response.getSubMsg());
        }
    }
}
