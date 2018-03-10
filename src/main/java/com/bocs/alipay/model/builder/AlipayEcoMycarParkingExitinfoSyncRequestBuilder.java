package com.bocs.alipay.model.builder;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.StringUtils;

/**
 * Description:<p>同步车辆离开停车场信息到支付宝接口请求 </p>
 * Created by songqi on 2018/3/10.
 */
public class AlipayEcoMycarParkingExitinfoSyncRequestBuilder extends RequestBuilder{

    private BizContent bizContent = new BizContent();

    @Override
    public boolean validate() {
        if(StringUtils.isEmpty(bizContent.parkingId)){
            throw new NullPointerException("parking_id should not be NULL!");
        }
        if(StringUtils.isEmpty(bizContent.carNumber)){
            throw new NullPointerException("car_number should not be NULL!");
        }
        return true;
    }

    @Override
    public BizContent getBizContent() {
        return bizContent;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AlipayEcoMycarParkingExitinfoSyncRequestBuilder{");
        sb.append(bizContent);
        sb.append(", commonParams=").append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public AlipayEcoMycarParkingExitinfoSyncRequestBuilder setAppAuthToken(String appAuthToken) {
        return (AlipayEcoMycarParkingExitinfoSyncRequestBuilder) super.setAppAuthToken(appAuthToken);
    }

    public String getParkingId() {
        return bizContent.parkingId;
    }

    public AlipayEcoMycarParkingExitinfoSyncRequestBuilder setParkingId(String parkingId) {
        bizContent.parkingId = parkingId;
        return this;
    }

    public String getCarNumber() {
        return bizContent.carNumber;
    }

    public AlipayEcoMycarParkingExitinfoSyncRequestBuilder setCarNumber(String carNumber) {
        bizContent.carNumber = carNumber;
        return this;
    }

    public String getOutTime() {
        return bizContent.outTime;
    }

    public AlipayEcoMycarParkingExitinfoSyncRequestBuilder setOutTime(String outTime) {
        bizContent.outTime = outTime;
        return this;
    }



    public static class BizContent {

        /**
         * 支付宝停车场ID
         */
        @SerializedName("parking_id")
        private String parkingId;

        /**
         * 车牌号
         */
        @SerializedName("car_number")
        private String carNumber;


        /**
         * 车辆离场时间，格式"YYYYMM-DD HH:mm:ss"，24小时制，
         * 请保证车辆的出场时间比入场时间要晚
         */
        @SerializedName("out_time")
        private String outTime;


        @Override
        public String toString() {
            return "{" +
                    "parkingId='" + parkingId + '\'' +
                    ", carNumber='" + carNumber + '\'' +
                    ", outTime='" + outTime + '\'' +
                    '}';
        }


    }
}
