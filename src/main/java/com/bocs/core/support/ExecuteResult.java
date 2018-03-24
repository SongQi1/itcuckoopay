package com.bocs.core.support;/**
 * Created by wangpd on 2018/3/22.
 */

import java.io.Serializable;

/**
 * 执行结果封装
 *
 * @author Wangpeidong
 * @create 2018-03-22 20:44
 **/
public class ExecuteResult implements Serializable {
    private static final long serialVersionUID = 571805995465193748L;

    /** 执行结果代码 */
    private String code = "1";
    /** 执行结果描述 */
    private String msg;
    /** 执行结果数据 */
    private Object result;

    /**
     * 返回正确
     * @param result
     * @return
     */
    public static ExecuteResult successResult(Object result){
        ExecuteResult executeResult = new ExecuteResult();
        executeResult.setResult(result);
        return executeResult;
    }

    /**
     * 返回正确
     * @param result
     * @return
     */
    public static ExecuteResult successResult(){
        ExecuteResult executeResult = new ExecuteResult();
        executeResult.setMsg("操作成功");
        return executeResult;
    }

    /**
     * 返回错误
     * @param msg
     * @return
     */
    public static ExecuteResult errorResult(String msg) {
        ExecuteResult executeResult = new ExecuteResult();
        executeResult.setCode("0");
        executeResult.setMsg(msg);
        return executeResult;
    }


    public boolean isSuccess() {
        return "1".equals(this.code);
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
