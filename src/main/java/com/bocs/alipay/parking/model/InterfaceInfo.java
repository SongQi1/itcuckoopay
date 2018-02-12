package com.bocs.alipay.parking.model;

import com.google.gson.annotations.SerializedName;

/**
 * 描述:<p> </p>
 *
 * @Author: songqi
 * @Date: 2018/2/9 15:49
 */
public class InterfaceInfo {

    /**
     *
     */
    @SerializedName("interface_name")
    private String interfaceName;

    /**
     *
     */
    @SerializedName("interface_type")
    private String interfaceType;


    @SerializedName("interface_url")
    private String interfaceUrl;



    public static InterfaceInfo newInstance(String interfaceName, String interfaceType, String interfaceUrl){
        InterfaceInfo interfaceInfo = new InterfaceInfo();
        interfaceInfo.setInterfaceName(interfaceName)
                .setInterfaceType(interfaceType)
                .setInterfaceUrl(interfaceUrl);
        return interfaceInfo;
    }

    @Override
    public String toString() {
        return "InterfaceInfo{" +
                "interfaceName='" + interfaceName + '\'' +
                ", interfaceType='" + interfaceType + '\'' +
                ", interfaceUrl='" + interfaceUrl + '\'' +
                '}';
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public InterfaceInfo setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
        return this;
    }

    public String getInterfaceType() {
        return interfaceType;
    }

    public InterfaceInfo setInterfaceType(String interfaceType) {
        this.interfaceType = interfaceType;
        return this;
    }

    public String getInterfaceUrl() {
        return interfaceUrl;
    }

    public InterfaceInfo setInterfaceUrl(String interfaceUrl) {
        this.interfaceUrl = interfaceUrl;
        return this;
    }



}
