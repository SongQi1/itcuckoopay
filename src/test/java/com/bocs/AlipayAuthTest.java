package com.bocs;

import com.bocs.alipay.model.builder.AlipaySystemOauthTokenRequestBuilder;
import com.bocs.alipay.model.result.AlipaySystemOauthTokenRequestResult;
import com.bocs.alipay.service.AlipayAuthService;
import com.bocs.sys.service.AlipayApiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description:<p> </p>
 * Created by songqi on 2018/2/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AlipayAuthTest {

    @Autowired
    private AlipayApiService alipayApiService;

    @Autowired
    private AlipayAuthService alipayAuthService;

    //沙箱环境中的商户账号授权给APP的token。一年有效期
    String appAuthToken = "201802BBfb1ef08a30304bc0a94b239534a6aE03";

    @Test
    public void testRefreshAuthToken(){

        String refreshToken = "201802BBb399ec8b816c4e17ac073363ef401X03";

        alipayApiService.refreshAppAuthToken(refreshToken);


    }


    @Test
    public void testSystemOauthToken(){
        AlipaySystemOauthTokenRequestBuilder builder = new AlipaySystemOauthTokenRequestBuilder();

        builder.setAppAuthToken(appAuthToken);
        builder.setGrantType("authorization_code");
        builder.setCode("");

        AlipaySystemOauthTokenRequestResult response = alipayAuthService.systemOauthToken(builder);
    }

}
