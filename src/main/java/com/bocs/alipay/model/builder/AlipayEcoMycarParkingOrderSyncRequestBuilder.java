package com.bocs.alipay.model.builder;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.StringUtils;

/**
 * Description:<p>ISV收到停车支付成功的通知后需要将停车订单信息通过接口
 * alipay.eco.mycar.parking.order.sync进行订单同步。 </p>
 * Created by songqi on 2018/3/10.
 */
public class AlipayEcoMycarParkingOrderSyncRequestBuilder extends RequestBuilder{

    private BizContent bizContent = new BizContent();

    @Override
    public boolean validate() {
        if (StringUtils.isEmpty(bizContent.userId)) {
            throw new NullPointerException("user_id should not be NULL!");
        }
        if (StringUtils.isEmpty(bizContent.outParkingId)) {
            throw new NullPointerException("out_parking_id should not be NULL!");
        }
        if (StringUtils.isEmpty(bizContent.parkingName)) {
            throw new NullPointerException("parking_name should not be NULL!");
        }
        if (StringUtils.isEmpty(bizContent.carNumber)) {
            throw new NullPointerException("car_number should not be NULL!");
        }
        if (StringUtils.isEmpty(bizContent.outOrderNo)) {
            throw new NullPointerException("out_order_no should not be NULL!");
        }
        if (StringUtils.isEmpty(bizContent.orderStatus)) {
            throw new NullPointerException("order_status should not be NULL!");
        }
        if (StringUtils.isEmpty(bizContent.orderTime)) {
            throw new NullPointerException("order_time should not be NULL!");
        }
        if (StringUtils.isEmpty(bizContent.orderNo)) {
            throw new NullPointerException("order_no should not be NULL!");
        }
        if (StringUtils.isEmpty(bizContent.payTime)) {
            throw new NullPointerException("pay_time should not be NULL!");
        }
        if (StringUtils.isEmpty(bizContent.payType)) {
            throw new NullPointerException("pay_type should not be NULL!");
        }
        if (StringUtils.isEmpty(bizContent.payMoney)) {
            throw new NullPointerException("pay_money should not be NULL!");
        }
        if (StringUtils.isEmpty(bizContent.inTime)) {
            throw new NullPointerException("in_time should not be NULL!");
        }
        if (StringUtils.isEmpty(bizContent.parkingId)) {
            throw new NullPointerException("parking_id should not be NULL!");
        }
        if (StringUtils.isEmpty(bizContent.inDuration)) {
            throw new NullPointerException("in_duration should not be NULL!");
        }
        if (StringUtils.isEmpty(bizContent.cardNumber)) {
            throw new NullPointerException("card_number should not be NULL!");
        }
        return true;
    }

    @Override
    public BizContent getBizContent() {
        return bizContent;
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AlipayEcoMycarParkingOrderSyncRequestBuilder{");
        sb.append(bizContent);
        sb.append(", commonParams=").append(super.toString());
        sb.append('}');
        return sb.toString();
    }


    @Override
    public RequestBuilder setAppAuthToken(String appAuthToken) {
        return super.setAppAuthToken(appAuthToken);
    }

    public String getUserId() {
        return bizContent.userId;
    }

    public AlipayEcoMycarParkingOrderSyncRequestBuilder setUserId(String userId) {
        bizContent.userId = userId;
        return this;
    }

    public String getOutParkingId() {
        return bizContent.outParkingId;
    }

    public AlipayEcoMycarParkingOrderSyncRequestBuilder setOutParkingId(String outParkingId) {
        bizContent.outParkingId = outParkingId;
        return this;
    }

    public String getParkingName() {
        return bizContent.parkingName;
    }

    public AlipayEcoMycarParkingOrderSyncRequestBuilder setParkingName(String parkingName) {
        bizContent.parkingName = parkingName;
        return this;
    }

    public String getCarNumber() {
        return bizContent.carNumber;
    }

    public AlipayEcoMycarParkingOrderSyncRequestBuilder setCarNumber(String carNumber) {
        bizContent.carNumber = carNumber;
        return this;
    }

    public String getOutOrderNo() {
        return bizContent.outOrderNo;
    }

    public AlipayEcoMycarParkingOrderSyncRequestBuilder setOutOrderNo(String outOrderNo) {
        bizContent.outOrderNo = outOrderNo;
        return this;
    }

    public String getOrderStatus() {
        return bizContent.orderStatus;
    }

    public AlipayEcoMycarParkingOrderSyncRequestBuilder setOrderStatus(String orderStatus) {
        bizContent.orderStatus = orderStatus;
        return this;
    }

    public String getOrderTime() {
        return bizContent.orderTime;
    }

    public AlipayEcoMycarParkingOrderSyncRequestBuilder setOrderTime(String orderTime) {
        bizContent.orderTime = orderTime;
        return this;
    }

    public String getOrderNo() {
        return bizContent.orderNo;
    }

    public AlipayEcoMycarParkingOrderSyncRequestBuilder setOrderNo(String orderNo) {
        bizContent.orderNo = orderNo;
        return this;
    }

    public String getPayTime() {
        return bizContent.payTime;
    }

    public AlipayEcoMycarParkingOrderSyncRequestBuilder setPayTime(String payTime) {
        bizContent.payTime = payTime;
        return this;
    }

    public String getPayType() {
        return bizContent.payType;
    }

    public AlipayEcoMycarParkingOrderSyncRequestBuilder setPayType(String payType) {
        bizContent.payType = payType;
        return this;
    }

    public String getPayMoney() {
        return bizContent.payMoney;
    }

    public AlipayEcoMycarParkingOrderSyncRequestBuilder setPayMoney(String payMoney) {
        bizContent.payMoney = payMoney;
        return this;
    }

    public String getInTime() {
        return bizContent.inTime;
    }

    public AlipayEcoMycarParkingOrderSyncRequestBuilder setInTime(String inTime) {
        bizContent.inTime = inTime;
        return this;
    }

    public String getParkingId() {
        return bizContent.parkingId;
    }

    public AlipayEcoMycarParkingOrderSyncRequestBuilder setParkingId(String parkingId) {
        bizContent.parkingId = parkingId;
        return this;
    }

    public String getInDuration() {
        return bizContent.inDuration;
    }

    public AlipayEcoMycarParkingOrderSyncRequestBuilder setInDuration(String inDuration) {
        bizContent.inDuration = inDuration;
        return this;
    }

    public String getCardNumber() {
        return bizContent.cardNumber;
    }

    public AlipayEcoMycarParkingOrderSyncRequestBuilder setCardNumber(String cardNumber) {
        bizContent.cardNumber = cardNumber;
        return this;
    }

    public static class BizContent {

        /**
         * 停车缴费支付宝用户的ID，请ISV保证用户ID的正确性，
         * 以免导致用户在停车平台查询不到相关的订单信息
         */
        @SerializedName("user_id")
        private String userId;

        /**
         * ISV停车场ID，由ISV提供，同一个isv或商户范围内唯一
         */
        @SerializedName("out_parking_id")
        private String outParkingId;

        /**
         * 停车场名称，由ISV定义，尽量与高德地图上的一致
         */
        @SerializedName("parking_name")
        private String parkingName;

        /**
         * 车牌
         */
        @SerializedName("car_number")
        private String carNumber;

        /**
         * 设备商订单号，由ISV系统生成
         */
        @SerializedName("out_order_no")
        private String outOrderNo;

        /**
         * 设备商订单状态，0：成功，1：失败
         */
        @SerializedName("order_status")
        private String orderStatus;

        /**
         * 订单创建时间，格式"YYYY-MM-DD HH:mm:ss"，24小时制
         */
        @SerializedName("order_time")
        private String orderTime;

        /**
         * 支付宝支付流水，系统唯一
         */
        @SerializedName("order_no")
        private String orderNo;

        /**
         * 缴费时间, 格式"YYYYMM-DD HH:mm:ss"，24小时制
         */
        @SerializedName("pay_time")
        private String payTime;

        /**
         * 付款方式，1：支付宝在线缴费 ，2：支付宝代扣缴费
         */
        @SerializedName("pay_type")
        private String payType;

        /**
         * 缴费金额，保留小数点后两位
         */
        @SerializedName("pay_money")
        private String payMoney;

        /**
         * 入场时间，格式"YYYY-MM-DD HH:mm:ss"，24小时制
         */
        @SerializedName("in_time")
        private String inTime;

        /**
         * 支付宝停车场id，系统唯一
         */
        @SerializedName("parking_id")
        private String parkingId;

        /**
         * 停车时长（以分为单位）
         */
        @SerializedName("in_duration")
        private String inDuration;

        /**
         * 如果是停车卡缴费，则填入停车卡卡号，否则为'*'
         */
        @SerializedName("card_number")
        private String cardNumber;


        @Override
        public String toString() {
            return "{" +
                    "userId='" + userId + '\'' +
                    ", outParkingId='" + outParkingId + '\'' +
                    ", parkingName='" + parkingName + '\'' +
                    ", carNumber='" + carNumber + '\'' +
                    ", outOrderNo='" + outOrderNo + '\'' +
                    ", orderStatus='" + orderStatus + '\'' +
                    ", orderTime='" + orderTime + '\'' +
                    ", orderNo='" + orderNo + '\'' +
                    ", payTime='" + payTime + '\'' +
                    ", payType='" + payType + '\'' +
                    ", payMoney='" + payMoney + '\'' +
                    ", inTime='" + inTime + '\'' +
                    ", parkingId='" + parkingId + '\'' +
                    ", inDuration='" + inDuration + '\'' +
                    ", cardNumber='" + cardNumber + '\'' +
                    '}';
        }


    }
}
