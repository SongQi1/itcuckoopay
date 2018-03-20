package com.bocs.sys.controller;

import com.alipay.api.response.AlipayEcoMycarParkingConfigQueryResponse;
import com.bocs.alipay.model.builder.AlipayEcoMycarParkingConfigQueryRequestBuilder;
import com.bocs.alipay.model.builder.AlipayEcoMycarParkingConfigSetRequestBuilder;
import com.bocs.alipay.model.result.AlipayParkingConfigQueryResult;
import com.bocs.alipay.model.result.AlipayParkingConfigSetResult;
import com.bocs.alipay.service.impl.AlipayParkingService;
import com.bocs.core.base.AbstractController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * isv配置信息管理Controller
 * @author Wangpeidong
 */
@Controller
@RequestMapping("/isvConfig")
public class IsvConfigController{

    @Autowired
    private AlipayParkingService alipayParkingService;

    @RequestMapping("/toForm")
    @ApiOperation(value = "查询ISV在支付宝的配置信息")
    public ModelAndView getIsvConfigInfo(@ApiParam(hidden = true) ModelMap modelMap) {
        AlipayEcoMycarParkingConfigQueryRequestBuilder builder = new AlipayEcoMycarParkingConfigQueryRequestBuilder();
        AlipayParkingConfigQueryResult result = alipayParkingService.parkingConfigQuery(builder);
        ModelAndView modelAndView = new ModelAndView("isvconfig/isvconfig");
        modelAndView.addObject("isvConfig", result.getResponse());
        return modelAndView;
    }

    @RequestMapping("/set")
    @ApiOperation(value = "设置ISV的配置信息")
    public Object setIsvConfigInfo(@ApiParam(hidden = true) ModelMap modelMap, AlipayEcoMycarParkingConfigQueryResponse config) {
        AlipayEcoMycarParkingConfigSetRequestBuilder builder = new AlipayEcoMycarParkingConfigSetRequestBuilder();
        builder.setAccountNo(config.getAccountNo());
        builder.setMerchantName(config.getMerchantName());
        builder.setMerchantServicePhone(config.getMerchantServicePhone());
        if (!ObjectUtils.isEmpty(config.getMerchantLogo())) {
            builder.setMerchantLogo(config.getMerchantLogo());
        }
        AlipayParkingConfigSetResult result = alipayParkingService.parkingConfigSet(builder);
        if (result.isTradeSuccess()) {
            return null;
        } else{

        }
        return null;
    }

}
