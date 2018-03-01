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
     * 第三方应用授权回调页面。
     * 开发者根据相应的规则拼接一个特殊的url（
     * 正式环境拼接规则为：https://openauth.alipay.com/oauth2/appToAppAuth.htm?app_id=APPID&redirect_uri=REDIRECT_URI
     * 沙箱环境拼接规则为：https://openauth.alipaydev.com/oauth2/appToAppAuth.htm?app_id=APPID&redirect_uri=REDIRECT_URI
     * 其中REDIRECT_URI是经过URLENCODE转义的url链接，url必须以http或者https开头），转成二维码。
     * 商户用支付宝扫描该二维码，跳转到支付宝的第三方应用授权页面。商户同意授权后，支付宝再跳转到redirect_uri
     * 指定的页面，也就是此页面，同时传递app_auth_code和app_id到此页面。
     * 应用系统用商户的app_auth_code换取app_auth_token，使用app_auth_token可以帮助商户完成相应的业务逻辑，例如代替商户发起当面付的收单请求
     * @param app_auth_code
     * @param app_id
     * @return
     */
    @RequestMapping(value = "/authRedirect")
    public String authRedirect(String app_auth_code, String app_id){
        alipayApiService.openAppAuthToken(app_auth_code, app_id);
        return "success";
    }

    /**
     * 用户使用支付宝登录回调页面。
     * @param app_id 开发者应用的app_id；相同支付宝账号下，不同的app_id获取的token切忌混用。
     * @param scope 成功授权的接口权限值，目前只支持auth_user（获取用户信息、网站支付宝登录）、auth_base（用户信息授权）、auth_ecard（商户会员卡）、auth_invoice_info（支付宝闪电开票）、auth_puc_charge（生活缴费）五个值;
     *              多个scope时用“,”分隔，如scope为“auth_user,auth_ecard”时，此时获取到的access_token，既可以用来获取用户信息，又可以给用户发送会员卡
     * @param error_scope error_scope表示授权是失败的scope列表及对应的错误信息（错误列表之间用“
     * @param state 商户自定义参数，用户授权后，重定向到redirect_uri时会原样回传给商户。 为防止CSRF攻击，建议开发者请求授权时传入state参数，该参数要做到既不可预测，又可以证明客户端和当前第三方网站的登录认证状态存在关联。
     * @param auth_code 临时授权码，一次性有效，同时若超过有效期未使用，则会失效。有效期目前至少为5分钟，最长为24小时。请获取auth_code后尽快通过调用alipay.system.oauth.token接口获取访问令牌
     * @return
     */
    @RequestMapping(value = "/userAuthRedirect")
    public String userAuthRedirect(String app_id, String scope, String error_scope, String state, String auth_code){
        return "success";
    }

    /**
     * 用于接收支付宝异步通知，如口碑开店中的开发者门店被动通知；
     * @return
     */
    @RequestMapping(value = "/receivePush")
    public String receivePush(){
        return "success";
    }

    /**
     * 用户在支付宝钱包的车主服务->停车服务中查询并支付停车费，支付宝的停车平台根据用户车辆驶入
     * 信息匹配并跳转到此页面，并携带auth_code和car_id两个参数。
     * 根据auth_code调用支付宝授权接口（alipay.system.oauth.token）获取access_token和user_id，
     * 再根据access_token和car_id调用获取车辆信息接口（alipay.eco.mycar.parking.vehicle.query）获取用户的车牌信息，
     * 根据车牌信息到数据库查询进场时间，计算停车费用，显示给用户。
     * @param auth_code
     * @param car_id
     * @return
     */
    @RequestMapping(value = "/queryParkingFee")
    public String queryParkingFee(String auth_code, String car_id){

        return "parking/parking_fee";
    }

}
