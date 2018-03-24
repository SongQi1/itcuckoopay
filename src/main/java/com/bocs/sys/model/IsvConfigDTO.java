package com.bocs.sys.model;

import java.io.Serializable;

/**
 * Created by wangpd on 2018/3/20.
 */
public class IsvConfigDTO implements Serializable{
    private static final long serialVersionUID = 4463105714393182811L;

    /**
     * 签约支付宝账号
     */
    private String accountNo;

    /**
     * LOGO
     */
    private String merchantLogo;

    /**
     * 商户简称
     */
    private String merchantName;

    /**
     * 商户客服电话
     */
    private String merchantServicePhone;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getMerchantLogo() {
        return merchantLogo;
    }

    public void setMerchantLogo(String merchantLogo) {
        this.merchantLogo = merchantLogo;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantServicePhone() {
        return merchantServicePhone;
    }

    public void setMerchantServicePhone(String merchantServicePhone) {
        this.merchantServicePhone = merchantServicePhone;
    }
}
