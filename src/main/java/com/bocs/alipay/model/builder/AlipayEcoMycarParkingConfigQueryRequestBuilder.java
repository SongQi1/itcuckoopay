package com.bocs.alipay.model.builder;

import com.bocs.alipay.model.PartnerRole;
import com.bocs.core.util.PropertiesUtil;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.StringUtils;

/**
 * 描述:<p>ISV系统配置查询请求构造器 </p>
 *
 * @Author: songqi
 * @Date: 2018/2/23 13:49
 */
public class AlipayEcoMycarParkingConfigQueryRequestBuilder extends RequestBuilder {

    private BizContent bizContent = new BizContent();


    public AlipayEcoMycarParkingConfigQueryRequestBuilder(){
        bizContent.interfaceName = "alipay.eco.mycar.parking.userpage.query";
        bizContent.interfaceType = "interface_page";
    }

    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public BizContent getBizContent() {
        return bizContent;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AlipayEcoMycarParkingConfigQueryRequestBuilder{");
        sb.append("bizContent=").append(bizContent);
        sb.append(", commonParams=").append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public AlipayEcoMycarParkingConfigQueryRequestBuilder setAppAuthToken(String appAuthToken) {
        return (AlipayEcoMycarParkingConfigQueryRequestBuilder)super.setAppAuthToken(appAuthToken);
    }




    public static class BizContent{

        /**
         * 传入参数固定值:alipay.eco.mycar.parking.userpage.query
         */
        @SerializedName("interface_name")
        private String interfaceName;

        /**
         * 传入参数固定值:interface_page
         */
        @SerializedName("interface_type")
        private String interfaceType;

        @Override
        public String toString() {
            return "{" +
                    "interfaceName='" + interfaceName + '\'' +
                    ", interfaceType='" + interfaceType + '\'' +
                    '}';
        }
    }


    public String getInterfaceName() {
        return bizContent.interfaceName;
    }

    public AlipayEcoMycarParkingConfigQueryRequestBuilder setInterfaceName(String interfaceName) {
        bizContent.interfaceName = interfaceName;
        return this;
    }

    public String getInterfaceType() {
        return bizContent.interfaceType;
    }

    public AlipayEcoMycarParkingConfigQueryRequestBuilder setInterfaceType(String interfaceType) {
        bizContent.interfaceType = interfaceType;
        return this;
    }
}
