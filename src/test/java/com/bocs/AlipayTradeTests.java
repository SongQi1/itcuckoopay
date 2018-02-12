package com.bocs;

import com.bocs.alipay.config.Configs;
import com.bocs.alipay.model.ExtendParams;
import com.bocs.alipay.model.GoodsDetail;
import com.bocs.alipay.model.InterfaceInfo;
import com.bocs.alipay.model.builder.AlipayEcoMycarParkingConfigSetRequestBuilder;
import com.bocs.alipay.model.builder.AlipayTradeCreateRequestBuilder;
import com.bocs.alipay.model.builder.AlipayTradePayRequestBuilder;
import com.bocs.alipay.model.result.AlipayF2FPayResult;
import com.bocs.alipay.service.AlipayTradeService;
import com.bocs.alipay.service.impl.AlipayParkingService;
import com.bocs.alipay.utils.Utils;
import com.bocs.sys.service.AlipayApiScheduleService;
import com.bocs.sys.service.AlipayApiService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlipayTradeTests {

	private static Log log = LogFactory.getLog(AlipayTradeTests.class);
	@Autowired
	private AlipayTradeService alipayTradeService;
	@Autowired
	private AlipayParkingService alipayParkingService;

	@Autowired
	private Configs configs;

	@Autowired
	private AlipayApiService alipayApiService;


	@Autowired
	private AlipayApiScheduleService alipayApiScheduleService;

	//卖家授权给APP的token。一年有效期
	String appAuthToken = "201802BBfb1ef08a30304bc0a94b239534a6aE03";

	@Test
	public void testTradePay() {
		// (必填) 商户网站订单系统中唯一订单号，64个字符以内，只能包含字母、数字、下划线，
		// 需保证商户系统端不能重复，建议通过数据库sequence生成，
		String outTradeNo = "tradepay" + System.currentTimeMillis()
				+ (long) (Math.random() * 10000000L);

		// (必填) 订单标题，粗略描述用户的支付目的。如“xxx品牌xxx门店消费”
		String subject = "xxx品牌xxx门店当面付消费";

		// (必填) 订单总金额，单位为元，不能超过1亿元
		// 如果同时传入了【打折金额】,【不可打折金额】,【订单总金额】三者,则必须满足如下条件:【订单总金额】=【打折金额】+【不可打折金额】
		String totalAmount = "1111.22";

		// (必填) 付款条码，用户支付宝钱包手机app点击“付款”产生的付款条码
		String authCode = "280275157416327565"; // 条码示例，286648048691290423
		// (可选，根据需要决定是否使用) 订单可打折金额，可以配合商家平台配置折扣活动，如果订单部分商品参与打折，可以将部分商品总价填写至此字段，默认全部商品可打折
		// 如果该值未传入,但传入了【订单总金额】,【不可打折金额】 则该值默认为【订单总金额】- 【不可打折金额】
		//        String discountableAmount = "1.00"; //



		// 卖家支付宝账号ID，用于支持一个签约账号下支持打款到不同的收款账号，(打款到sellerId对应的支付宝账号)
		// 如果该字段为空，则默认为与支付宝签约的商户的PID，也就是appid对应的PID
		String sellerId = "2088102175192031";



		// 订单描述，可以对交易或商品进行一个详细地描述，比如填写"购买商品3件共20.00元"
		String body = "购买商品3件共20.00元";

		// 商户操作员编号，添加此参数可以为商户操作员做销售统计
		String operatorId = "test_operator_id";

		// (必填) 商户门店编号，通过门店号和商家后台可以配置精准到门店的折扣信息，详询支付宝技术支持
		String storeId = "test_store_id";

		// 业务扩展参数，系统商编号
		//该参数作为系统商返佣数据提取的依据，请填写系统商签约协议的PID
		String providerId = configs.getPid();
		ExtendParams extendParams = new ExtendParams();
		extendParams.setSysServiceProviderId(providerId);

		// 支付超时，线下扫码交易定义为5分钟
		String timeoutExpress = "5m";

		// 商品明细列表，需填写购买商品详细信息，
		List<GoodsDetail> goodsDetailList = new ArrayList<GoodsDetail>();
		// 创建一个商品信息，参数含义分别为商品id（使用国标）、名称、单价（单位为分）、数量，如果需要添加商品类别，详见GoodsDetail
		GoodsDetail goods1 = GoodsDetail.newInstance("goods_id001", "xxx面包", 1000, 1);
		// 创建好一个商品后添加至商品明细列表
		goodsDetailList.add(goods1);

		// 继续创建并添加第一条商品信息，用户购买的产品为“黑人牙刷”，单价为5.00元，购买了两件
		GoodsDetail goods2 = GoodsDetail.newInstance("goods_id002", "xxx牙刷", 500, 2);
		goodsDetailList.add(goods2);



		// 创建条码支付请求builder，设置请求参数
		AlipayTradePayRequestBuilder builder = new AlipayTradePayRequestBuilder()
				.setAppAuthToken(appAuthToken)

				.setOutTradeNo(outTradeNo).setSubject(subject).setAuthCode(authCode)
				.setTotalAmount(totalAmount).setStoreId(storeId)
				.setBody(body).setOperatorId(operatorId)
				.setExtendParams(extendParams).setSellerId(sellerId)
				.setGoodsDetailList(goodsDetailList).setTimeoutExpress(timeoutExpress);

		// 调用tradePay方法获取当面付应答
		AlipayF2FPayResult result = alipayTradeService.tradePay(builder);

		switch (result.getTradeStatus()){
			case SUCCESS:
				log.info("支付宝支付成功!!!(∩＿∩)");
				break;

			case FAILED:
				log.error("支付宝支付失败!!!(¯□¯)");
				break;

			case UNKNOWN:
				log.error("系统异常，订单状态未知!!!(⊙ o ⊙)");
				break;

			default:
				log.error("不支持的交易状态，交易返回异常!!!o(‧\"‧)o ");
				break;
		}
	}

	@Test
	public void testRefreshAuthToken(){

		String refreshToken = "201802BBb399ec8b816c4e17ac073363ef401X03";

		alipayApiService.refreshAppAuthToken(refreshToken);
	}


	@Test
	public void testHeartbeatSyn(){
		// 启动当面付，此处每隔5秒调用一次支付接口，并且当随机数为0时交易保障线程退出
		for(int i=0;i<5;i++) {
			testTradePay();
			Utils.sleep(5 * 1000);
		}

		alipayApiScheduleService.alipayHeartbeatSyn();
	}


	@Test
	public void testTradeCreate(){

		String outTradeNo = "tradepay" + System.currentTimeMillis()
				+ (long) (Math.random() * 10000000L);
		AlipayTradeCreateRequestBuilder builder = new AlipayTradeCreateRequestBuilder()
				//.setAppAuthToken(appAuthToken)
				.setOutTradeNo(outTradeNo).setTotalAmount("0.1")
				.setSubject("测试交易创建接口");
				//.setExtendParams(new ExtendParams().setSysServiceProviderId(configs.getPid()));

		alipayTradeService.tradeCreate(builder);
	}


	@Test
	public void testParkingSet(){
		List<InterfaceInfo> inferfaceInfoList = new ArrayList<>();

		InterfaceInfo interfaceInfo = InterfaceInfo.newInstance("alipay.eco.mycar.parking.userpage.query","interface_page","https://www.itcuckoo.com/cash/queryParkingFee");
		inferfaceInfoList.add(interfaceInfo);

		AlipayEcoMycarParkingConfigSetRequestBuilder builder = new AlipayEcoMycarParkingConfigSetRequestBuilder()
				.setMerchantName("布谷鸟信息科技（昆山）有限公司")
				.setMerchantServicePhone("13776346982")
				.setAccountNo("songqi@itcuckoo.com")
				.setAppAuthToken(appAuthToken)
				.setInterfaceInfoList(inferfaceInfoList);
		alipayParkingService.parkingConfigSet(builder);
	}
}
