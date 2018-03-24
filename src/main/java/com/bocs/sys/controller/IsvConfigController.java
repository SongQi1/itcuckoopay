package com.bocs.sys.controller;

import com.alipay.api.response.AlipayEcoMycarParkingConfigQueryResponse;
import com.bocs.alipay.config.Constants;
import com.bocs.alipay.model.InterfaceInfo;
import com.bocs.alipay.model.builder.AlipayEcoMycarParkingConfigQueryRequestBuilder;
import com.bocs.alipay.model.builder.AlipayEcoMycarParkingConfigSetRequestBuilder;
import com.bocs.alipay.model.result.AlipayParkingConfigQueryResult;
import com.bocs.alipay.model.result.AlipayParkingConfigSetResult;
import com.bocs.alipay.service.impl.AlipayParkingService;
import com.bocs.core.base.AbstractController;
import com.bocs.core.util.DozerUtil;
import com.bocs.core.util.ExcuteResult;
import com.bocs.sys.model.IsvConfigDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * isv配置信息管理Controller
 * @author Wangpeidong
 */
@Controller
@RequestMapping("/isvconfig")
public class IsvConfigController{

    @Autowired
    private AlipayParkingService alipayParkingService;

    @RequestMapping("/toform")
    @ApiOperation(value = "查询ISV在支付宝的配置信息")
    public ModelAndView getIsvConfigInfo(@ApiParam(hidden = true) ModelMap modelMap) {
        AlipayEcoMycarParkingConfigQueryRequestBuilder builder = new AlipayEcoMycarParkingConfigQueryRequestBuilder();
        AlipayParkingConfigQueryResult result = alipayParkingService.parkingConfigQuery(builder);
        ModelAndView modelAndView = new ModelAndView("isvconfig/isvconfig");
        modelAndView.addObject("isvConfig", DozerUtil.map(result.getResponse(), IsvConfigDTO.class));
        return modelAndView;
    }

    @RequestMapping("/set")
    @ApiOperation(value = "设置ISV的配置信息")
    @ResponseBody
    public ExcuteResult setIsvConfigInfo(@ApiParam(hidden = true) ModelMap modelMap, IsvConfigDTO config) {
        AlipayEcoMycarParkingConfigSetRequestBuilder builder = new AlipayEcoMycarParkingConfigSetRequestBuilder();
        builder.setAccountNo(config.getAccountNo());
        builder.setMerchantName(config.getMerchantName());
        builder.setMerchantServicePhone(config.getMerchantServicePhone());
        if (!ObjectUtils.isEmpty(config.getMerchantLogo())) {
            builder.setMerchantLogo(config.getMerchantLogo());
        }
        List<InterfaceInfo> interfaceInfoList = new ArrayList<>();
        String interfaceUrl = "";
        try {
            interfaceUrl = URLEncoder.encode(Constants.INTERFACE_URL, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        InterfaceInfo interfaceInfo = InterfaceInfo.newInstance("alipay.eco.mycar.parking.userpage.query", "interface_page", interfaceUrl);
        interfaceInfoList.add(interfaceInfo);
        builder.setInterfaceInfoList(interfaceInfoList);
        AlipayParkingConfigSetResult result = alipayParkingService.parkingConfigSet(builder);
        if (!result.isTradeSuccess()) {
            return ExcuteResult.errorResult(result.getResponse().getMsg());
        }
        return ExcuteResult.successResult();
    }

}
