package com.bocs.sys.model;

import com.bocs.core.base.BaseModel;

import java.time.LocalDateTime;

/**
 * Description:<p> 停车订单信息 </p>
 * Created by songqi on 2018/3/20.
 */
public class ParkingOrderInfo extends BaseModel{

    /**
     * 停车场ID
     */
    private Long parkinglotId;

    /**
     * 收银系统订单号。
     */
    private String orderNo;

    /**
     * 车牌
     */
    private String carNumber;

    /**
     * 入场时间
     */
    private LocalDateTime inTime;

    /**
     * 出场时间
     */
    private LocalDateTime outTime;


    /**
     * 停车时长。格式*时*分*秒
     */
    private String parkingDuration;


    /**
     * 停车费用。保留小数点后两位
     */
    private double parkingFee;

    /**
     * 支付状态:
     * unpay-未支付
     * paying-正在支付中，
     * payfailed-支付失败，
     * paid-已支付
     */
    private String payStatus;


    /**
     * 支付成功时间
     */
    private LocalDateTime payTime;

    /**
     * 支付方式：weipay,alipay
     */
    private String payType;


    /**
     * 支付系统返回的订单号。
     */
    private String outOrderNo;


    public Long getParkinglotId() {
        return parkinglotId;
    }

    public void setParkinglotId(Long parkinglotId) {
        this.parkinglotId = parkinglotId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public LocalDateTime getInTime() {
        return inTime;
    }

    public void setInTime(LocalDateTime inTime) {
        this.inTime = inTime;
    }

    public LocalDateTime getOutTime() {
        return outTime;
    }

    public void setOutTime(LocalDateTime outTime) {
        this.outTime = outTime;
    }

    public String getParkingDuration() {
        return parkingDuration;
    }

    public void setParkingDuration(String parkingDuration) {
        this.parkingDuration = parkingDuration;
    }

    public double getParkingFee() {
        return parkingFee;
    }

    public void setParkingFee(double parkingFee) {
        this.parkingFee = parkingFee;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public LocalDateTime getPayTime() {
        return payTime;
    }

    public void setPayTime(LocalDateTime payTime) {
        this.payTime = payTime;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }
}
