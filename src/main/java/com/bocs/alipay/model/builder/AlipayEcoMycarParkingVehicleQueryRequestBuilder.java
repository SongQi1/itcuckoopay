package com.bocs.alipay.model.builder;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.StringUtils;

/**
 * Description:<p>根据车辆ID查询车牌请求</p>
 * Created by songqi on 2018/2/27.
 */
public class AlipayEcoMycarParkingVehicleQueryRequestBuilder extends RequestBuilder{

    private BizContent bizContent = new BizContent();

    @Override
    public boolean validate() {
        if(StringUtils.isEmpty(bizContent.carId)){
            throw new NullPointerException("car_id should not be NULL!");
        }
        return true;
    }

    @Override
    public BizContent getBizContent() {
        return bizContent;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AlipayEcoMycarParkingVehicleQueryRequestBuilder{");
        sb.append(bizContent);
        sb.append(", commonParams=").append(super.toString());
        sb.append('}');
        return sb.toString();
    }


    @Override
    public AlipayEcoMycarParkingVehicleQueryRequestBuilder setAppAuthToken(String appAuthToken) {
        return (AlipayEcoMycarParkingVehicleQueryRequestBuilder) super.setAppAuthToken(appAuthToken);
    }

    @Override
    public AlipayEcoMycarParkingVehicleQueryRequestBuilder setAccessToken(String accessToken) {
        return (AlipayEcoMycarParkingVehicleQueryRequestBuilder) super.setAccessToken(accessToken);
    }

    public String getCarId() {
        return bizContent.carId;
    }

    public AlipayEcoMycarParkingVehicleQueryRequestBuilder setCarId(String carId) {
        bizContent.carId = carId;
        return this;
    }

    public static class BizContent{

        /**
         * 支付宝用户车辆ID，系统唯一。
         * （该参数会在停车平台用户点击查询缴费，跳转到ISV停车缴费查询页面时，
         * 从请求中传递）
         */
        @SerializedName("car_id")
        private String carId;

        @Override
        public String toString() {
            return "{" +
                    "carId='" + carId + '\'' +
                    '}';
        }


    }
}
