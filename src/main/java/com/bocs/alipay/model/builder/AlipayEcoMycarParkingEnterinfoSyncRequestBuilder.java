package com.bocs.alipay.model.builder;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.StringUtils;

/**
 * 描述:<p>同步车辆驶入信息到支付宝接口请求 </p>
 *
 * @Author: songqi
 * @Date: 2018/2/24 14:16
 */
public class AlipayEcoMycarParkingEnterinfoSyncRequestBuilder extends RequestBuilder{

    private BizContent bizContent = new BizContent();

    @Override
    public boolean validate() {
        if(StringUtils.isEmpty(bizContent.parkingId)){
            throw new NullPointerException("parking_id should not be NULL!");
        }
        if(StringUtils.isEmpty(bizContent.carNumber)){
            throw new NullPointerException("car_number should not be NULL!");
        }
        if(StringUtils.isEmpty(bizContent.inTime)){
            throw new NullPointerException("in_time should not be NULL!");
        }
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AlipayEcoMycarParkingEnterinfoSyncRequestBuilder{");
        sb.append(bizContent);
        sb.append(", commonParams=").append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public BizContent getBizContent() {
        return bizContent;
    }

    @Override
    public AlipayEcoMycarParkingEnterinfoSyncRequestBuilder setAppAuthToken(String appAuthToken) {
        return (AlipayEcoMycarParkingEnterinfoSyncRequestBuilder) super.setAppAuthToken(appAuthToken);
    }


    public String getParkingId() {
        return bizContent.parkingId;
    }

    public AlipayEcoMycarParkingEnterinfoSyncRequestBuilder setParkingId(String parkingId) {
        bizContent.parkingId = parkingId;
        return this;
    }

    public String getCarNumber() {
        return bizContent.carNumber;
    }

    public AlipayEcoMycarParkingEnterinfoSyncRequestBuilder setCarNumber(String carNumber) {
        bizContent.carNumber = carNumber;
        return this;
    }

    public String getInTime() {
        return bizContent.inTime;
    }

    public AlipayEcoMycarParkingEnterinfoSyncRequestBuilder setInTime(String inTime) {
        bizContent.inTime = inTime;
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
         * 车辆入场的时间，格式"YYYY-MM-DD HH:mm:ss"，24小时制
         */
        @SerializedName("in_time")
        private String inTime;


        @Override
        public String toString() {
            return "{" +
                    "parkingId='" + parkingId + '\'' +
                    ", carNumber='" + carNumber + '\'' +
                    ", inTime='" + inTime + '\'' +
                    '}';
        }
    }
}
