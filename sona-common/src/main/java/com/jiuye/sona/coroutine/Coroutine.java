package com.jiuye.sona.coroutine;

import kilim.Mailbox;
import kilim.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Author: xinjian.hu
 * @Date: 2020/12/29 17:23
 * @Email: huxinjian@jiuyescm.com
 */
public class Coroutine {

    static Map<Integer, Mailbox<Integer>> mailMap = new HashMap<>();

    public static void main(String[] args) {
        if (kilim.tools.Kilim.trampoline(false, args))
        {return;}
        Properties properties = new Properties();
        properties.setProperty("kilim.Scheduler.numsThreads", "4");
        System.setProperties(properties);
        // 一千个协程生产消息
        for(int i = 0; i < 1000; i++) {
            Mailbox<Integer> mb = new Mailbox<>(1, 10);
            new Producer(i, mb).start();
            mailMap.put(i, mb);
        }

        // 一千个协程消费消息
        for(int i = 0; i < 1000; i++) {
            new Consumer(mailMap.get(i)).start();
        }
        Task.idledown();

    }
}
