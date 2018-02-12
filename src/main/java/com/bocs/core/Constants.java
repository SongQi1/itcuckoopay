package com.bocs.core;

import com.bocs.core.util.InstanceUtil;

import java.util.Map;

/**
 * 常量表
 *
 * @author ShenHuaJie
 * @version $Id: Constants.java, v 0.1 2014-2-28 上午11:18:28 ShenHuaJie Exp $
 */
public interface Constants {
    /**
     * 异常信息统一头信息<br>
     * 非常遗憾的通知您,程序发生了异常
     */
    String Exception_Head = "OH,MY GOD! SOME ERRORS OCCURED! AS FOLLOWS :";
    /** 缓存键值 */
    Map<Class<?>, String> cacheKeyMap = InstanceUtil.newHashMap();
    /** 操作名称 */
    String OPERATION_NAME = "OPERATION_NAME";
    /** 客户端语言 */
    String USERLANGUAGE = "userLanguage";
    /** 客户端主题 */
    String WEBTHEME = "webTheme";
    /** 当前用户 */
    String CURRENT_USER = "CURRENT_USER";
    /** 客户端信息 */
    String USER_AGENT = "USER-AGENT";
    /** 客户端信息 */
    String USER_IP = "USER_IP";
    /** 上次请求地址 */
    String PREREQUEST = "PREREQUEST";
    /** 上次请求时间 */
    String PREREQUEST_TIME = "PREREQUEST_TIME";
    /** 登录地址 */
    String LOGIN_URL = "/login.html";
    /** 非法请求次数 */
    String MALICIOUS_REQUEST_TIMES = "MALICIOUS_REQUEST_TIMES";
    /** 缓存命名空间 */
    String CACHE_NAMESPACE = "iBase4J:";
    /** 在线用户数量 */
    String ALLUSER_NUMBER = "SYSTEM:" + CACHE_NAMESPACE + "ALLUSER_NUMBER";
    /** TOKEN */
    String TOKEN_KEY = CACHE_NAMESPACE + "TOKEN_KEY";

    int CASH_EXPIRE_TIME = 3000;

    /** 日志表状态 */
    interface JOBSTATE {
        /**
         * 日志表状态，初始状态，插入
         */
        String INIT_STATS = "I";
        /**
         * 日志表状态，成功
         */
        String SUCCESS_STATS = "S";
        /**
         * 日志表状态，失败
         */
        String ERROR_STATS = "E";
        /**
         * 日志表状态，未执行
         */
        String UN_STATS = "N";
    }
}
