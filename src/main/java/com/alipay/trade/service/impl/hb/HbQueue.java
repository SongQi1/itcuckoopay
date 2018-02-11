package com.alipay.trade.service.impl.hb;

import com.alipay.trade.model.hb.SysTradeInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 存放交易的阻塞队列，用来向支付宝同步交易信息，为商家提供交易监控
 * @author songqi
 * @Date 2018/2/8
 */
public class HbQueue {
    private static Log log = LogFactory.getLog(HbQueue.class);

    /**
     * 最多同时保存300条交易记录
     */
    public static final int QUEUE_SIZE = 300;
    private static final BlockingQueue<SysTradeInfo> queue = new ArrayBlockingQueue<>(QUEUE_SIZE);

    public synchronized static void offer(SysTradeInfo info) {
        // blockingQueue不需要考虑队列满的情况，生产者会被阻塞直到队列被消耗
        if (info != null) {
            try {
                // 使用阻塞put
                queue.put(info);
            } catch (InterruptedException e) {
                log.warn("interrupted for tradeInfo:" + info);
                e.printStackTrace();
            }
        }
    }

    public synchronized static List<SysTradeInfo> poll() {
        if (queue.isEmpty()) {
            // 如果队列为空，则直接返回
            return null;
        }

        int size = 30;
        List<SysTradeInfo> tradeInfoList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            // 使用非阻塞poll
            SysTradeInfo info = queue.poll();
            if (info == null) {
                break;
            }
            tradeInfoList.add(info);
        }
        return tradeInfoList;
    }
}
