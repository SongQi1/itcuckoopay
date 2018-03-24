package com.bocs.alipay.config;

/**
 * Created by liuyangkly on 15/7/29.
 */
public class Constants {

    private Constants() {
        // No Constructor.
    }

    /**
     * 支付宝接口调用成功。调用结果请参考具体的API文档所对应的业务返回参数
     */
    public static final String SUCCESS = "10000";

    /**
     * 支付宝返回用户支付中
     */
    public static final String PAYING  = "10003";

    /**
     * 支付宝业务处理失败。对应业务错误码，明细错误码和解决方案请参见具体的API接口文档
     */
    public static final String FAILED  = "40004";

    /**
     * 服务不可用。具体的异常原因参考接口返回的sub_code
     */
    public static final String ERROR   = "20000";

    /**
     * isv信息查询url
     */
    public static final String INTERFACE_URL = "https://www.itcuckoo.com/infoquery";
}
