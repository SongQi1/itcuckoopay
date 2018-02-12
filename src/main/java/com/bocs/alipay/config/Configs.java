package com.bocs.alipay.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author songqi
 * @date 2018/02/06
 */
@Configuration
@ConfigurationProperties(prefix = "alipay.info")
public class Configs {
    private static  Log log = LogFactory.getLog(Configs.class);

    /**
     * 支付宝openapi域名
     */
    private String openApiDomain;

    /**
     * 支付宝mcloudmonitor域名
     */
    private String mcloudApiDomain;

    /**
     * 商户partner id
     */
    private String pid;

    /**
     * 商户应用id
     */
    private String appid;
    /**
     * RSA私钥，用于对商户请求报文加签
     */
    private String privateKey;
    /**
     * RSA公钥，仅用于验证开发者网关
     */
    private String publicKey;
    /**
     * 支付宝RSA公钥，用于验签支付宝应答
     */
    private String alipayPublicKey;



    @Bean
    public AlipayClient alipayClient(){
        return new DefaultAlipayClient(openApiDomain, appid, privateKey,
                "json", "utf-8", alipayPublicKey, "RSA2");
    }


    public String getOpenApiDomain() {
        return openApiDomain;
    }

    public void setOpenApiDomain(String openApiDomain) {
        this.openApiDomain = openApiDomain;
    }

    public String getMcloudApiDomain() {
        return mcloudApiDomain;
    }

    public void setMcloudApiDomain(String mcloudApiDomain) {
        this.mcloudApiDomain = mcloudApiDomain;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }


}

