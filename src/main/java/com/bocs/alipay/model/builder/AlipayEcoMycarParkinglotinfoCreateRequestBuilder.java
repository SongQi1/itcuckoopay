package com.bocs.alipay.model.builder;


import com.google.gson.annotations.SerializedName;

/**
 * 描述:<p> </p>
 *
 * @Author: songqi
 * @Date: 2018/2/23 16:09
 */
public class AlipayEcoMycarParkinglotinfoCreateRequestBuilder extends RequestBuilder{

    private BizContent bizContent = new BizContent();

    @Override
    public boolean validate() {
        return false;
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
    public AlipayEcoMycarParkinglotinfoCreateRequestBuilder setAppAuthToken(String appAuthToken) {
        return (AlipayEcoMycarParkinglotinfoCreateRequestBuilder) super.setAppAuthToken(appAuthToken);
    }


    public String getOutParkingId() {
        return bizContent.outParkingId;
    }

    public AlipayEcoMycarParkinglotinfoCreateRequestBuilder setOutParkingId(String outParkingId) {
        bizContent.outParkingId = outParkingId;
        return this;
    }

    public String getParkingAddress() {
        return bizContent.parkingAddress;
    }

    public AlipayEcoMycarParkinglotinfoCreateRequestBuilder setParkingAddress(String parkingAddress) {
        bizContent.parkingAddress = parkingAddress;
        return this;
    }

    public String getParkinglotType() {
        return bizContent.parkinglotType;
    }

    public AlipayEcoMycarParkinglotinfoCreateRequestBuilder setParkinglotType(String parkinglotType) {
        bizContent.parkinglotType = parkinglotType;
        return this;
    }

    public String getParkingPoiId() {
        return bizContent.parkingPoiId;
    }

    public AlipayEcoMycarParkinglotinfoCreateRequestBuilder setParkingPoiId(String parkingPoiId) {
        bizContent.parkingPoiId = parkingPoiId;
        return this;
    }

    public String getParkingMobile() {
        return bizContent.parkingMobile;
    }

    public AlipayEcoMycarParkinglotinfoCreateRequestBuilder setParkingMobile(String parkingMobile) {
        bizContent.parkingMobile = parkingMobile;
        return this;
    }

    public String getPayType() {
        return bizContent.payType;
    }

    public AlipayEcoMycarParkinglotinfoCreateRequestBuilder setPayType(String payType) {
        bizContent.payType = payType;
        return this;
    }

    public String getShopingmallId() {
        return bizContent.shopingmallId;
    }

    public AlipayEcoMycarParkinglotinfoCreateRequestBuilder setShopingmallId(String shopingmallId) {
        bizContent.shopingmallId = shopingmallId;
        return this;
    }

    public String getParkingFeeDescription() {
        return bizContent.parkingFeeDescription;
    }

    public AlipayEcoMycarParkinglotinfoCreateRequestBuilder setParkingFeeDescription(String parkingFeeDescription) {
        bizContent.parkingFeeDescription = parkingFeeDescription;
        return this;
    }

    public String getParkingName() {
        return bizContent.parkingName;
    }

    public AlipayEcoMycarParkinglotinfoCreateRequestBuilder setParkingName(String parkingName) {
        bizContent.parkingName = parkingName;
        return this;
    }

    public String getTimeOut() {
        return bizContent.timeOut;
    }

    public AlipayEcoMycarParkinglotinfoCreateRequestBuilder setTimeOut(String timeOut) {
        bizContent.timeOut = timeOut;
        return this;
    }

    public static class BizContent {

        /**
         * ISV停车场ID，由ISV提供，同一个isv或商户范围内唯一
         */
        @SerializedName("out_parking_id")
        private String outParkingId;

        /**
         * 停车场地址
         */
        @SerializedName("parking_address")
        private String parkingAddress;

        /**
         * 停车场类型，1为小区停车场、2为商圈停车场、3为路面停车场、4为园区停车场、5为写字楼停车场、6为私人停车场
         */
        @SerializedName("parking_lot_type")
        private String parkinglotType;

        /**
         * 高德地图唯一标识
         */
        @SerializedName("parking_poiid")
        private String parkingPoiId;

        /**
         * 停车场客服电话
         */
        @SerializedName("parking_mobile")
        private String parkingMobile;

        /**
         * 支付方式（1为支付宝在线缴费，2为支付宝代扣缴费，3当面付)，如支持多种方式以','进行间隔
         */
        @SerializedName("pay_type")
        private String payType;

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



        @Override
        public String toString() {
            return "{" +
                    "outParkingId='" + outParkingId + '\'' +
                    ", parkingAddress='" + parkingAddress + '\'' +
                    ", parkinglotType='" + parkinglotType + '\'' +
                    ", parkingPoiId='" + parkingPoiId + '\'' +
                    ", parkingMobile='" + parkingMobile + '\'' +
                    ", payType='" + payType + '\'' +
                    ", shopingmallId='" + shopingmallId + '\'' +
                    ", parkingFeeDescription='" + parkingFeeDescription + '\'' +
                    ", parkingName='" + parkingName + '\'' +
                    ", timeOut='" + timeOut + '\'' +
                    '}';
        }
    }
}
