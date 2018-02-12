package com.bocs.alipay.model.builder;

import com.bocs.alipay.model.InterfaceInfo;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 描述:<p>停车ISV系统配置请求 </p>
 *
 * @Author: songqi
 * @Date: 2018/2/9 15:43
 */
public class AlipayEcoMycarParkingConfigSetRequestBuilder extends RequestBuilder{


    private BizContent bizContent = new BizContent();


    @Override
    public boolean validate() {
        if(StringUtils.isEmpty(bizContent.merchantName)){
            throw new NullPointerException("merchant_name should not be NULL!");
        }
        if(StringUtils.isEmpty(bizContent.merchantServicePhone)){
            throw new NullPointerException("merchant_service_phone should not be NULL!");
        }
        if(StringUtils.isEmpty(bizContent.accountNo)){
            throw new NullPointerException("account_no should not be NULL!");
        }

        if(bizContent.interfaceInfoList == null){
            throw new NullPointerException("interface_info_list should not be NULL!");
        }

        return true;
    }

    @Override
    public BizContent getBizContent() {
        return bizContent;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AlipayEcoMycarParkingConfigSetRequestBuilder{");
        sb.append("bizContent=").append(bizContent);
        sb.append(", commonParams=").append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public AlipayEcoMycarParkingConfigSetRequestBuilder setAppAuthToken(String appAuthToken) {
        return (AlipayEcoMycarParkingConfigSetRequestBuilder) super.setAppAuthToken(appAuthToken);
    }

    @Override
    public AlipayEcoMycarParkingConfigSetRequestBuilder setNotifyUrl(String notifyUrl) {
        return (AlipayEcoMycarParkingConfigSetRequestBuilder) super.setNotifyUrl(notifyUrl);
    }

    public static class BizContent {

        /**
         * 商户简称
         */
        @SerializedName("merchant_name")
        private String merchantName;

        /**
         * 商户客服电话
         */
        @SerializedName("merchant_service_phone")
        private String merchantServicePhone;

        /**
         * 签约支付宝账号
         */
        @SerializedName("account_no")
        private String accountNo;


        /**
         * 接口信息列表，停车业务需要配置的接口列表，该值为JSON数据格式的LIST对象，
         * 现阶段只需要配置一个页面接口即可 。每次请将所有的接口配置信息都传入，未传的接口信息将会被置空。
         */
        @SerializedName("interface_info_list")
        private List<InterfaceInfo> interfaceInfoList;

        /**
         * 商户在停车平台首页露出的LOGO；
         * 注意：该图片为PNG格式内容为BASE64的字符串，若为空则停车平台首页将不露出商户LOGO。
         * 建议图片尺寸27px*27px，大小不要超过60K
         */
        @SerializedName("merchant_logo")
        private String merchantLogo;




        @Override
        public String toString() {
            return "{" +
                    "merchantName='" + merchantName + '\'' +
                    ", merchantServicePhone='" + merchantServicePhone + '\'' +
                    ", accountNo='" + accountNo + '\'' +
                    ", interfaceInfoList=" + interfaceInfoList +
                    ", merchantLogo='" + merchantLogo + '\'' +
                    '}';
        }
    }

    public String getMerchantName() {
        return bizContent.merchantName;
    }

    public AlipayEcoMycarParkingConfigSetRequestBuilder setMerchantName(String merchantName) {
        bizContent.merchantName = merchantName;
        return this;
    }

    public String getMerchantServicePhone() {
        return bizContent.merchantServicePhone;
    }

    public AlipayEcoMycarParkingConfigSetRequestBuilder setMerchantServicePhone(String merchantServicePhone) {
        bizContent.merchantServicePhone = merchantServicePhone;
        return this;
    }

    public String getAccountNo() {
        return bizContent.accountNo;
    }

    public AlipayEcoMycarParkingConfigSetRequestBuilder setAccountNo(String accountNo) {
        bizContent.accountNo = accountNo;
        return this;
    }

    public List<InterfaceInfo> getInterfaceInfoList() {
        return bizContent.interfaceInfoList;
    }

    public AlipayEcoMycarParkingConfigSetRequestBuilder setInterfaceInfoList(List<InterfaceInfo> interfaceInfoList) {
        bizContent.interfaceInfoList = interfaceInfoList;
        return this;
    }

    public String getMerchantLogo() {
        return bizContent.merchantLogo;
    }

    public AlipayEcoMycarParkingConfigSetRequestBuilder setMerchantLogo(String merchantLogo) {
        bizContent.merchantLogo = merchantLogo;
        return this;
    }
}
