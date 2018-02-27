package com.bocs.alipay.model.builder;

/**
 * Description:<p>车牌查询请求</p>
 * Created by songqi on 2018/2/27.
 */
public class AlipayEcoMycarParkingVehicleQueryRequestBuilder extends RequestBuilder{

    private BizContent bizContent = new BizContent();

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public Object getBizContent() {
        return null;
    }

    public static class BizContent{

    }
}
