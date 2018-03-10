package com.bocs.alipay.model.builder;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.StringUtils;

/**
 * Description:<p>ISV订单修改请求。
 * 【场景】在用户对停车订单有疑议而产生申诉，退款完成的场景下，ISV订单状态发生改变，
 * 为确保订单状态的一致性，ISV需要修改交易状态为支付成功的订单，
 * 通过接口alipay.eco.mycar.parking.order.update，将订单的状态变化信息同步到停车平台。</p>
 * Created by songqi on 2018/3/10.
 */
public class AlipayEcoMycarParkingOrderUpdateRequestBuilder extends RequestBuilder{

    private BizContent bizContent = new BizContent();

    @Override
    public boolean validate() {
        if (StringUtils.isEmpty(bizContent.userId)) {
            throw new NullPointerException("user_id should not be NULL!");
        }
        if (StringUtils.isEmpty(bizContent.orderNo)) {
            throw new NullPointerException("order_no should not be NULL!");
        }
        if (StringUtils.isEmpty(bizContent.orderStatus)) {
            throw new NullPointerException("order_status should not be NULL!");
        }
        return true;
    }

    @Override
    public BizContent getBizContent() {
        return bizContent;
    }

    @Override
    public AlipayEcoMycarParkingOrderUpdateRequestBuilder setAppAuthToken(String appAuthToken) {
        return (AlipayEcoMycarParkingOrderUpdateRequestBuilder) super.setAppAuthToken(appAuthToken);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AlipayEcoMycarParkingOrderUpdateRequestBuilder{");
        sb.append(bizContent);
        sb.append(", commonParams=").append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    public String getUserId() {
        return bizContent.userId;
    }

    public AlipayEcoMycarParkingOrderUpdateRequestBuilder setUserId(String userId) {
        bizContent.userId = userId;
        return this;
    }

    public String getOrderNo() {
        return bizContent.orderNo;
    }

    public AlipayEcoMycarParkingOrderUpdateRequestBuilder setOrderNo(String orderNo) {
        bizContent.orderNo = orderNo;
        return this;
    }

    public String getOrderStatus() {
        return bizContent.orderStatus;
    }

    public AlipayEcoMycarParkingOrderUpdateRequestBuilder setOrderStatus(String orderStatus) {
        bizContent.orderStatus = orderStatus;
        return this;
    }


    public static class BizContent{
        /**
         * 停车缴费支付宝用户的ID，请ISV保证用户ID的正确性，
         * 以免导致用户在停车平台查询不到相关的订单信息
         */
        @SerializedName("user_id")
        private String userId;

        /**
         * 支付宝支付流水号，系统唯一
         */
        @SerializedName("order_no")
        private String orderNo;

        /**
         * 用户停车订单状态，0：成功，1：失败
         */
        @SerializedName("order_status")
        private String orderStatus;



        @Override
        public String toString() {
            return "{" +
                    "userId='" + userId + '\'' +
                    ", orderNo='" + orderNo + '\'' +
                    ", orderStatus='" + orderStatus + '\'' +
                    '}';
        }
    }
}
