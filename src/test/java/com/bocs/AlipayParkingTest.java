package com.bocs;

import com.alipay.api.response.AlipayEcoMycarParkingConfigQueryResponse;
import com.bocs.alipay.model.InterfaceInfo;
import com.bocs.alipay.model.builder.AlipayEcoMycarParkingConfigQueryRequestBuilder;
import com.bocs.alipay.model.builder.AlipayEcoMycarParkingConfigSetRequestBuilder;
import com.bocs.alipay.model.result.AlipayParkingConfigQueryResult;
import com.bocs.alipay.model.result.AlipayParkingConfigSetResult;
import com.bocs.alipay.service.impl.AlipayParkingService;
import com.bocs.alipay.utils.Utils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述:<p>支付宝停车业务测试类 </p>
 *
 * @Author: songqi
 * @Date: 2018/2/23 13:17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AlipayParkingTest {

    private static Log log = LogFactory.getLog(AlipayParkingTest.class);

    @Autowired
    private AlipayParkingService alipayParkingService;

    //沙箱环境中的商户账号的appAuthToken。一年有效期
    String appAuthToken = "201802BBfb1ef08a30304bc0a94b239534a6aE03";


    public void testParkingConfigQuery(){
        AlipayEcoMycarParkingConfigQueryRequestBuilder builder = new AlipayEcoMycarParkingConfigQueryRequestBuilder();
        builder.setAppAuthToken(appAuthToken);

        AlipayParkingConfigQueryResult result = alipayParkingService.parkingConfigQuery(builder);
        AlipayEcoMycarParkingConfigQueryResponse response = result.getResponse();

        if(response.isSuccess()){
            log.info("merchantName:" + response.getMerchantName());
            log.info("merchantServicePhone:" + response.getMerchantServicePhone());
            log.info("accountNo:" + response.getAccountNo());
            log.info("interfaceInfoList :" + response.getInterfaceInfoList().toString());
            log.info("merchantLogo:" + response.getMerchantLogo());
        }

    }

    @Test
    public void testParkingConfigSet(){
        List<InterfaceInfo> inferfaceInfoList = new ArrayList<>();

        InterfaceInfo interfaceInfo =
                InterfaceInfo.newInstance(
                        "alipay.eco.mycar.parking.userpage.query",
                        "interface_page",
                        "https://www.itcuckoo.com/cash/queryParkingFee");
        inferfaceInfoList.add(interfaceInfo);

        AlipayEcoMycarParkingConfigSetRequestBuilder builder = new AlipayEcoMycarParkingConfigSetRequestBuilder()
                .setMerchantName("布谷鸟信息科技（昆山）有限公司")
                .setMerchantServicePhone("13776346982")
                .setAccountNo("songqi@itcuckoo.com")
                .setAppAuthToken(appAuthToken)
                .setMerchantLogo(Utils.getImageBase64Str(new File("D:\\itcuckoo_logo.png")))
                .setInterfaceInfoList(inferfaceInfoList);
        AlipayParkingConfigSetResult result = alipayParkingService.parkingConfigSet(builder);
        switch (result.getTradeStatus()){
            case SUCCESS:
                log.info("设置成功!!!(∩＿∩)");
                break;

            case FAILED:
                log.error("设置失败!!!(¯□¯)");
                break;

            case UNKNOWN:
                log.error("系统异常!!!原因："+ result.getResponse().getSubMsg());
                break;

            default:
                log.error("不支持的交易状态，交易返回异常!!!o(‧\"‧)o ");
                break;
        }

    }


}
