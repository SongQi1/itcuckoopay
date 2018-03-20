package com.bocs.sys.model;

import com.bocs.core.base.BaseModel;

/**
 * Description:<p> 停车场信息 </p>
 * Created by songqi on 2018/3/15.
 */
public class Parkinglot extends BaseModel{

    /**
     * 停车场对应商户的ID
     */
    private Long merchantId;

    /**
     * ISV停车场ID，由ISV提供，同一个isv或商户范围内唯一
     * 注意：在创建订单接口时，此参数的值可传入store_id。
     */
    private String outParkingId;

    /**
     * 支付宝返回停车场id，系统唯一
     */
    private String parkingId;

    /**
     * 停车场地址
     */
    private String parkingAddress;

    /**
     * 停车场类型，1为小区停车场、2为商圈停车场、3为路面停车场、4为园区停车场、5为写字楼停车场、6为私人停车场
     */
    private String parkinglotType;

    /**
     * 高德地图唯一标识
     */
    private String parkingPoiid;

    /**
     * 停车场客服电话
     */
    private String parkingMobile;

    /**
     * 支付方式（1为支付宝在线缴费，2为支付宝代扣缴费，3当面付)，如支持多种方式以','进行间隔
     */
    private String payType;

    /**
     * 商圈id
     */
    private String shopingmallId;


    /**
     * 收费规则ID
     */
    private long parkingFeeRuleId;

    /**
     * 收费说明
     */
    private String parkingFeeDescription;

    /**
     * 停车场名称
     */
    private String parkingName;

    /**
     * 用户支付未离场的超时时间(以分钟为单位)
     */
    private String timeOut;

    /**
     * 停车场联系人
     */
    private String parkinglotContact;

    /**
     * 停车场联系人电话
     */
    private String parkinglotContactPhone;


    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getOutParkingId() {
        return outParkingId;
    }

    public void setOutParkingId(String outParkingId) {
        this.outParkingId = outParkingId;
    }

    public String getParkingId() {
        return parkingId;
    }

    public void setParkingId(String parkingId) {
        this.parkingId = parkingId;
    }

    public String getParkingAddress() {
        return parkingAddress;
    }

    public void setParkingAddress(String parkingAddress) {
        this.parkingAddress = parkingAddress;
    }

    public String getParkinglotType() {
        return parkinglotType;
    }

    public void setParkinglotType(String parkinglotType) {
        this.parkinglotType = parkinglotType;
    }

    public String getParkingPoiid() {
        return parkingPoiid;
    }

    public void setParkingPoiid(String parkingPoiid) {
        this.parkingPoiid = parkingPoiid;
    }

    public String getParkingMobile() {
        return parkingMobile;
    }

    public void setParkingMobile(String parkingMobile) {
        this.parkingMobile = parkingMobile;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getShopingmallId() {
        return shopingmallId;
    }

    public void setShopingmallId(String shopingmallId) {
        this.shopingmallId = shopingmallId;
    }

    public long getParkingFeeRuleId() {
        return parkingFeeRuleId;
    }

    public void setParkingFeeRuleId(long parkingFeeRuleId) {
        this.parkingFeeRuleId = parkingFeeRuleId;
    }

    public String getParkingFeeDescription() {
        return parkingFeeDescription;
    }

    public void setParkingFeeDescription(String parkingFeeDescription) {
        this.parkingFeeDescription = parkingFeeDescription;
    }

    public String getParkingName() {
        return parkingName;
    }

    public void setParkingName(String parkingName) {
        this.parkingName = parkingName;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public String getParkinglotContact() {
        return parkinglotContact;
    }

    public void setParkinglotContact(String parkinglotContact) {
        this.parkinglotContact = parkinglotContact;
    }

    public String getParkinglotContactPhone() {
        return parkinglotContactPhone;
    }

    public void setParkinglotContactPhone(String parkinglotContactPhone) {
        this.parkinglotContactPhone = parkinglotContactPhone;
    }
}
