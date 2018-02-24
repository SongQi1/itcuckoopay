package com.bocs.alipay.model.builder;


import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.StringUtils;

import java.util.regex.Pattern;

/**
 * 描述:<p>停车场信息更新请求构造器 </p>
 *
 * @Author: songqi
 * @Date: 2018/2/23 16:09
 */
public class AlipayEcoMycarParkingParkinglotinfoUpdateRequestBuilder extends RequestBuilder{

    private BizContent bizContent = new BizContent();

    @Override
    public boolean validate() {
        if(StringUtils.isEmpty(bizContent.parkingId)){
            throw new NullPointerException("parking_id should not be NULL!");
        }
        if(StringUtils.isEmpty(bizContent.parkingAddress)){
            throw new NullPointerException("parking_address should not be NULL!");
        }
        if(StringUtils.isEmpty(bizContent.parkingName)){
            throw new NullPointerException("parking_name should not be NULL!");
        }

        if(StringUtils.isEmpty(bizContent.parkinglotType)){
            throw new NullPointerException("parking_lot_type should not be NULL!");
        }
        if(StringUtils.isEmpty(bizContent.payType)){
            throw new NullPointerException("pay_type should not be NULL!");
        }

        if(StringUtils.isEmpty(bizContent.parkingPoiid)){
            throw new NullPointerException("parking_poiid should not be NULL!");
        }
        if(StringUtils.isEmpty(bizContent.parkingMobile)){
            throw new NullPointerException("parking_mobile should not be NULL!");
        }
        if (!Pattern.matches("^\\d{11,}$", bizContent.parkingMobile)) {
            throw new IllegalStateException("invalid parking_mobile!");
        }
        return true;
    }

    @Override
    public BizContent getBizContent() {
        return bizContent;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AlipayEcoMycarParkinglotinfoCreateRequestBuilder{");
        sb.append("bizContent=").append(bizContent);
        sb.append(", commonParams=").append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public AlipayEcoMycarParkingParkinglotinfoUpdateRequestBuilder setAppAuthToken(String appAuthToken) {
        return (AlipayEcoMycarParkingParkinglotinfoUpdateRequestBuilder) super.setAppAuthToken(appAuthToken);
    }


    public String getParkingId() {
        return bizContent.parkingId;
    }

    public AlipayEcoMycarParkingParkinglotinfoUpdateRequestBuilder setParkingId(String parkingId) {
        bizContent.parkingId = parkingId;
        return this;
    }

    public String getParkingAddress() {
        return bizContent.parkingAddress;
    }

    public AlipayEcoMycarParkingParkinglotinfoUpdateRequestBuilder setParkingAddress(String parkingAddress) {
        bizContent.parkingAddress = parkingAddress;
        return this;
    }

    public String getParkinglotType() {
        return bizContent.parkinglotType;
    }

    public AlipayEcoMycarParkingParkinglotinfoUpdateRequestBuilder setParkinglotType(String parkinglotType) {
        bizContent.parkinglotType = parkinglotType;
        return this;
    }

    public String getParkingPoiid() {
        return bizContent.parkingPoiid;
    }

    public AlipayEcoMycarParkingParkinglotinfoUpdateRequestBuilder setParkingPoiid(String parkingPoiid) {
        bizContent.parkingPoiid = parkingPoiid;
        return this;
    }

    public String getParkingMobile() {
        return bizContent.parkingMobile;
    }

    public AlipayEcoMycarParkingParkinglotinfoUpdateRequestBuilder setParkingMobile(String parkingMobile) {
        bizContent.parkingMobile = parkingMobile;
        return this;
    }

    public String getPayType() {
        return bizContent.payType;
    }

    public AlipayEcoMycarParkingParkinglotinfoUpdateRequestBuilder setPayType(String payType) {
        bizContent.payType = payType;
        return this;
    }

    public String getShopingmallId() {
        return bizContent.shopingmallId;
    }

    public AlipayEcoMycarParkingParkinglotinfoUpdateRequestBuilder setShopingmallId(String shopingmallId) {
        bizContent.shopingmallId = shopingmallId;
        return this;
    }

    public String getParkingFeeDescription() {
        return bizContent.parkingFeeDescription;
    }

    public AlipayEcoMycarParkingParkinglotinfoUpdateRequestBuilder setParkingFeeDescription(String parkingFeeDescription) {
        bizContent.parkingFeeDescription = parkingFeeDescription;
        return this;
    }

    public String getParkingName() {
        return bizContent.parkingName;
    }

    public AlipayEcoMycarParkingParkinglotinfoUpdateRequestBuilder setParkingName(String parkingName) {
        bizContent.parkingName = parkingName;
        return this;
    }

    public String getTimeOut() {
        return bizContent.timeOut;
    }

    public AlipayEcoMycarParkingParkinglotinfoUpdateRequestBuilder setTimeOut(String timeOut) {
        bizContent.timeOut = timeOut;
        return this;
    }

    public static class BizContent {

        /**
         * 支付宝返回停车场id，系统唯一
         */
        @SerializedName("parking_id")
        private String parkingId;

        /**
         * 停车场地址
         */
        @SerializedName("parking_address")
        private String parkingAddress;


        /**
         * 停车场名称
         */
        @SerializedName("parking_name")
        private String parkingName;

        /**
         * 用户支付未离场的超时时间(以分钟为单位)
         */
        @SerializedName("time_out")
        private String timeOut;



        /**
         * 停车场类型，1为小区停车场、2为商圈停车场、3为路面停车场、4为园区停车场、5为写字楼停车场、6为私人停车场
         */
        @SerializedName("parking_lot_type")
        private String parkinglotType;

        /**
         * 支付方式（1为支付宝在线缴费，2为支付宝代扣缴费，3当面付)，如支持多种方式以','进行间隔
         */
        @SerializedName("pay_type")
        private String payType;


        /**
         * 高德地图唯一标识
         */
        @SerializedName("parking_poiid")
        private String parkingPoiid;

        /**
         * 停车场客服电话
         */
        @SerializedName("parking_mobile")
        private String parkingMobile;



        /**
         * 商圈id
         */
        @SerializedName("shopingmall_id")
        private String shopingmallId;

        /**
         * 收费说明
         */
        @SerializedName("parking_fee_description")
        private String parkingFeeDescription;


        @Override
        public String toString() {
            return "{" +
                    "parkingId='" + parkingId + '\'' +
                    ", parkingAddress='" + parkingAddress + '\'' +
                    ", parkingName='" + parkingName + '\'' +
                    ", timeOut='" + timeOut + '\'' +
                    ", parkinglotType='" + parkinglotType + '\'' +
                    ", payType='" + payType + '\'' +
                    ", parkingPoiid='" + parkingPoiid + '\'' +
                    ", parkingMobile='" + parkingMobile + '\'' +
                    ", shopingmallId='" + shopingmallId + '\'' +
                    ", parkingFeeDescription='" + parkingFeeDescription + '\'' +
                    '}';
        }
    }
}
