package com.bocs.core.util;

import java.io.Serializable;

/**
 * Created by wangpd on 2018/3/20.
 */
public class ExcuteResult implements Serializable {
    private static final long serialVersionUID = 5994327650207423147L;

    private String code;

    private String msg;

    private Object result;


    public static ExcuteResult successResult() {
        ExcuteResult excuteResult = new ExcuteResult();
        excuteResult.setCode("1");
        excuteResult.setMsg("操作成功");
        return excuteResult;
    }

    public static ExcuteResult successResult(Object result) {
        ExcuteResult excuteResult = new ExcuteResult();
        excuteResult.setCode("1");
        excuteResult.setResult(result);
        return excuteResult;
    }

    public static ExcuteResult errorResult() {
        ExcuteResult excuteResult = new ExcuteResult();
        excuteResult.setCode("0");
        return excuteResult;
    }
    public static ExcuteResult errorResult(String msg) {
        ExcuteResult excuteResult = new ExcuteResult();
        excuteResult.setCode("0");
        excuteResult.setMsg(msg);
        return excuteResult;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
