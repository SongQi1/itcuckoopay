package com.alipay.demo.trade.model;

/**
 * 描述:<p>合作伙伴角色 </p>
 *
 * @Author: songqi
 * @Date: 2018/2/9 10:20
 */
public enum PartnerRole {

    /**
     * 服务提供商
     */
    ISV("isv")

    /**
     * 普通商户
     */
    ,MERCHANT("merchant");

    private String role;

    PartnerRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
