package com.bocs.sys.controller;

import com.bocs.sys.service.AlipayApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:<p> </p>
 * Created by songqi on 2018/2/2.
 */

@RestController
public class AlipayApiController {



    @Autowired
    private AlipayApiService alipayApiService;

    /**
     * 用商户的app_auth_code换取app_auth_token，使用app_auth_token代替商户完成签约的功能。
     * @param app_auth_code
     * @param app_id
     * @return
     */
    @RequestMapping(value = "/authRedirect")
    public String authRedirect(String app_auth_code, String app_id){
        alipayApiService.openAppAuthToken(app_auth_code, app_id);
        return "success";
    }

    @RequestMapping(value = "/receivePush")
    public String receivePush(){
        return "success";
    }
}
