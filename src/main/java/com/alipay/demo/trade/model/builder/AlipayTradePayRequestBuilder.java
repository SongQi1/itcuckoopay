package com.alipay.demo.trade.model.builder;

import com.alipay.demo.trade.model.ExtendParams;
import com.alipay.demo.trade.model.GoodsDetail;
import com.alipay.demo.trade.model.PartnerRole;
import com.bocs.core.util.PropertiesUtil;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by songqi on 2018/2/8.
 */
public class AlipayTradePayRequestBuilder extends RequestBuilder {

    private BizContent bizContent = new BizContent();

    @Override
    public BizContent getBizContent() {
        return bizContent;
    }

    @Override
    public boolean validate() {
        if (StringUtils.isEmpty(bizContent.scene)) {
            throw new NullPointerException("scene should not be NULL!");
        }
        if (StringUtils.isEmpty(bizContent.authCode)) {
            throw new NullPointerException("auth_code should not be NULL!");
        }
        if (!Pattern.matches("^\\d{10,}$", bizContent.authCode)) {
            throw new IllegalStateException("invalid auth_code!");
        }
        if (StringUtils.isEmpty(bizContent.outTradeNo)) {
            throw new NullPointerException("out_trade_no should not be NULL!");
        }
        if (StringUtils.isEmpty(bizContent.totalAmount)) {
            throw new NullPointerException("total_amount should not be NULL!");
        }
        if (StringUtils.isEmpty(bizContent.subject)) {
            throw new NullPointerException("subject should not be NULL!");
        }
        if (StringUtils.isEmpty(bizContent.storeId)) {
            throw new NullPointerException("store_id should not be NULL!");
        }
        if(PartnerRole.ISV.getRole().equalsIgnoreCase(PropertiesUtil.getString("partnerRole"))
                && (bizContent.extendParams == null || StringUtils.isEmpty(bizContent.extendParams.getSysServiceProviderId()))){
            throw new NullPointerException("sys_service_provider_id should not be NULL!");
        }
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AlipayTradePayRequestBuilder{");
        sb.append("bizContent=").append(bizContent);
        sb.append(", commonParams=").append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    public AlipayTradePayRequestBuilder() {
        // 条码支付，场景为bar_code
        bizContent.scene = "bar_code";
    }

    @Override
    public AlipayTradePayRequestBuilder setAppAuthToken(String appAuthToken) {
        return (AlipayTradePayRequestBuilder) super.setAppAuthToken(appAuthToken);
    }

    @Override
    public AlipayTradePayRequestBuilder setNotifyUrl(String notifyUrl) {
        return (AlipayTradePayRequestBuilder) super.setNotifyUrl(notifyUrl);
    }

    public String getScene() {
        return bizContent.scene;
    }

    public AlipayTradePayRequestBuilder setScene(String scene) {
        bizContent.scene = scene;
        return this;
    }

    public String getAuthCode() {
        return bizContent.authCode;
    }

    public AlipayTradePayRequestBuilder setAuthCode(String authCode) {
        bizContent.authCode = authCode;
        return this;
    }

    public String getOutTradeNo() {
        return bizContent.outTradeNo;
    }

    public AlipayTradePayRequestBuilder setOutTradeNo(String outTradeNo) {
        bizContent.outTradeNo = outTradeNo;
        return this;
    }

    public String getSellerId() {
        return bizContent.sellerId;
    }

    public AlipayTradePayRequestBuilder setSellerId(String sellerId) {
        bizContent.sellerId = sellerId;
        return this;
    }

    public String getTotalAmount() {
        return bizContent.totalAmount;
    }

    public AlipayTradePayRequestBuilder setTotalAmount(String totalAmount) {
        bizContent.totalAmount = totalAmount;
        return this;
    }

    public String getDiscountableAmount() {
        return bizContent.discountableAmount;
    }

    public AlipayTradePayRequestBuilder setDiscountableAmount(String discountableAmount) {
        bizContent.discountableAmount = discountableAmount;
        return this;
    }


    public String getSubject() {
        return bizContent.subject;
    }

    public AlipayTradePayRequestBuilder setSubject(String subject) {
        bizContent.subject = subject;
        return this;
    }

    public String getBody() {
        return bizContent.body;
    }

    public AlipayTradePayRequestBuilder setBody(String body) {
        bizContent.body = body;
        return this;
    }

    public List<GoodsDetail> getGoodsDetailList() {
        return bizContent.goodsDetailList;
    }

    public AlipayTradePayRequestBuilder setGoodsDetailList(List<GoodsDetail> goodsDetailList) {
        bizContent.goodsDetailList = goodsDetailList;
        return this;
    }

    public String getOperatorId() {
        return bizContent.operatorId;
    }

    public AlipayTradePayRequestBuilder setOperatorId(String operatorId) {
        bizContent.operatorId = operatorId;
        return this;
    }

    public String getStoreId() {
        return bizContent.storeId;
    }

    public AlipayTradePayRequestBuilder setStoreId(String storeId) {
        bizContent.storeId = storeId;
        return this;
    }


    public String getTerminalId() {
        return bizContent.terminalId;
    }

    public AlipayTradePayRequestBuilder setTerminalId(String terminalId) {
        bizContent.terminalId = terminalId;
        return this;
    }

    public ExtendParams getExtendParams() {
        return bizContent.extendParams;
    }

    public AlipayTradePayRequestBuilder setExtendParams(ExtendParams extendParams) {
        bizContent.extendParams = extendParams;
        return this;
    }

    public String getTimeoutExpress() {
        return bizContent.timeoutExpress;
    }

    public AlipayTradePayRequestBuilder setTimeoutExpress(String timeoutExpress) {
        bizContent.timeoutExpress = timeoutExpress;
        return this;
    }

    public String getProductCode() {
        return bizContent.productCode;
    }

    public AlipayTradePayRequestBuilder setProductCode(String productCode) {
        bizContent.productCode = productCode;
        return this;
    }

    public String getBuyerId() {
        return bizContent.buyerId;
    }

    public AlipayTradePayRequestBuilder setBuyerId(String buyerId) {
        bizContent.buyerId = buyerId;
        return this;
    }

    public static class BizContent {

        /**
         *  商户网站订单系统中唯一订单号，64个字符以内，只能包含字母、数字、下划线，
         *  需保证商户系统端不能重复，建议通过数据库sequence生成，
         */
        @SerializedName("out_trade_no")
        private String outTradeNo;

        /**
         * 支付场景，条码支付场景为bar_code
         */
        private String scene;

        /**
         * 付款条码，用户支付宝钱包手机app点击“付款”产生的付款条码
         */
        @SerializedName("auth_code")
        private String authCode;

        /**
         * 销售产品码
         */
        @SerializedName("product_code ")
        private String productCode;


        /**
         * 订单标题，粗略描述用户的支付目的。如“喜士多（浦东店）消费”
         */
        private String subject;

        /**
         * 买家的支付宝用户id，如果为空，会从传入了码值信息中获取买家ID
         */
        @SerializedName("buyer_id")
        private String buyerId;



        /**
         * 卖家支付宝账号ID，用于支持一个签约账号下支持打款到不同的收款账号，(打款到sellerId对应的支付宝账号)
         * 如果该字段为空，则默认为与支付宝签约的商户的PID，也就是appid对应的PID
         */
        @SerializedName("seller_id")
        private String sellerId;

        /**
         * 订单总金额，整形，此处单位为元，精确到小数点后2位，不能超过1亿元
         * 如果同时传入了【打折金额】,【不可打折金额】,【订单总金额】三者,则必须满足如下条件:【订单总金额】=【打折金额】+【不可打折金额】
         */
        @SerializedName("total_amount")
        private String totalAmount;

        /**
         * 订单可打折金额，此处单位为元，精确到小数点后2位
         * 可以配合商家平台配置折扣活动，如果订单部分商品参与打折，可以将部分商品总价填写至此字段，默认全部商品可打折
         * 如果该值未传入,但传入了【订单总金额】,【不可打折金额】 则该值默认为【订单总金额】- 【不可打折金额】
         */
        @SerializedName("discountable_amount")
        private String discountableAmount;




        /**
         * 订单描述，可以对交易或商品进行一个详细地描述，比如填写"购买商品2件共15.00元"
         */
        private String body;

        /**
         * 商品明细列表，需填写购买商品详细信息，
         */
        @SerializedName("goods_detail")
        private List<GoodsDetail> goodsDetailList;

        /**
         * 商户操作员编号，添加此参数可以为商户操作员做销售统计
         */
        @SerializedName("operator_id")
        private String operatorId;

        /**
         * 商户门店编号，通过门店号和商家后台可以配置精准到门店的折扣信息，详询支付宝技术支持
         */
        @SerializedName("store_id")
        private String storeId;


        /**
         * 商户机具终端编号，当以机具方式接入支付宝时必传，详询支付宝技术支持
         */
        @SerializedName("terminal_id")
        private String terminalId;


        /**
         * 业务扩展参数，目前可添加由支付宝分配的系统商编号(通过setSysServiceProviderId方法)，详情请咨询支付宝技术支持
         */
        @SerializedName("extend_params")
        private ExtendParams extendParams;


        /**
         * (推荐使用，相对时间) 支付超时时间，5m 5分钟
         */
        @SerializedName("timeout_express")
        private String timeoutExpress;


        @Override
        public String toString() {
            return "{" +
                    "outTradeNo='" + outTradeNo + '\'' +
                    ", scene='" + scene + '\'' +
                    ", authCode='" + authCode + '\'' +
                    ", productCode='" + productCode + '\'' +
                    ", subject='" + subject + '\'' +
                    ", buyerId='" + buyerId + '\'' +
                    ", sellerId='" + sellerId + '\'' +
                    ", totalAmount='" + totalAmount + '\'' +
                    ", discountableAmount='" + discountableAmount + '\'' +
                    ", body='" + body + '\'' +
                    ", goodsDetailList=" + goodsDetailList +
                    ", operatorId='" + operatorId + '\'' +
                    ", storeId='" + storeId + '\'' +
                    ", terminalId='" + terminalId + '\'' +
                    ", extendParams=" + extendParams +
                    ", timeoutExpress='" + timeoutExpress + '\'' +
                    '}';
        }
    }
}
