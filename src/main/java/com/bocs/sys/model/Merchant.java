package com.bocs.sys.model;

import com.bocs.core.base.BaseModel;

import java.time.LocalDate;

/**
 * Description:<p>商户信息 </p>
 * Created by songqi on 2018/3/15.
 */
public class Merchant extends BaseModel {

    /**
     * 商户名称
     */
    private String merchantName;

    /**
     * 商户类型
     */
    private String merchantType;

    /**
     * 商户联系人
     */
    private String merchantContact;

    /**
     * 商户联系人电话
     */
    private String merchantContactPhone;

    /**
     * 商户地址
     */
    private String merchantAddress;

    /**
     * 商户支付宝PID
     */
    private String userId;

    /**
     * 商户支付宝账号
     */
    private String alipayAccount;

    /**
     * 签约日期
     */
    private LocalDate contractDate;



    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantType() {
        return merchantType;
    }

    public void setMerchantType(String merchantType) {
        this.merchantType = merchantType;
    }

    public String getMerchantContact() {
        return merchantContact;
    }

    public void setMerchantContact(String merchantContact) {
        this.merchantContact = merchantContact;
    }

    public String getMerchantContactPhone() {
        return merchantContactPhone;
    }

    public void setMerchantContactPhone(String merchantContactPhone) {
        this.merchantContactPhone = merchantContactPhone;
    }

    public String getMerchantAddress() {
        return merchantAddress;
    }

    public void setMerchantAddress(String merchantAddress) {
        this.merchantAddress = merchantAddress;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAlipayAccount() {
        return alipayAccount;
    }

    public void setAlipayAccount(String alipayAccount) {
        this.alipayAccount = alipayAccount;
    }

    public LocalDate getContractDate() {
        return contractDate;
    }

    public void setContractDate(LocalDate contractDate) {
        this.contractDate = contractDate;
    }
}
