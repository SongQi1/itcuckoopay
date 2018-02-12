package com.bocs.alipay.utils;

import com.bocs.alipay.model.hb.ExceptionInfo;
import com.bocs.alipay.model.hb.ExceptionInfoAdapter;
import com.bocs.alipay.model.hb.TradeInfo;
import com.bocs.alipay.model.hb.TradeInfoAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by liuyangkly on 15/6/26.
 * 使用google gson作为json序列化反序列化工具
 */
public class GsonFactory {

    private static class GsonHolder {
        private static Type exceptionListType = new TypeToken<List<ExceptionInfo>>(){}.getType();
        private static Type tradeInfoListType = new TypeToken<List<TradeInfo>>(){}.getType();

        private static Gson gson = new GsonBuilder()
                                .registerTypeAdapter(exceptionListType, new ExceptionInfoAdapter())
                                .registerTypeAdapter(tradeInfoListType, new TradeInfoAdapter())
                                .create();
    }

    public static Gson getGson() {
        return GsonHolder.gson;
    }
}
