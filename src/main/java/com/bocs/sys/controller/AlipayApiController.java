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
