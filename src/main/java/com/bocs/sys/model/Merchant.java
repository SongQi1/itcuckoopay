package com.bocs.sys.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.bocs.core.base.BaseModel;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Description:<p>商户信息 </p>
 * Created by songqi on 2018/3/15.
 */
public class Merchant extends BaseModel {

    /**
     * 商户名称
     */
    @NotEmpty(message="商户名称不能空")
    @TableField("merchant_name")
    private String merchantName;

    /**
     * 商户类型
     */
    @TableField("merchant_type")
    private String merchantType;

    /**
     * 商户联系人
     */
    @TableField("merchant_contact")
    private String merchantContact;

    /**
     * 商户联系人电话
     */
    @TableField("merchant_contact_phone")
    private String merchantContactPhone;

    /**
     * 商户地址
     */
    @TableField("merchant_address")
    private String merchantAddress;

    /**
     * 商户支付宝PID
     */
    @TableField("user_id")
    private String userId;

    /**
     * 商户支付宝账号
     */
    @TableField("alipay_account")
    private String alipayAccount;

    /**
     * 签约日期
     */
    @TableField("contract_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
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
