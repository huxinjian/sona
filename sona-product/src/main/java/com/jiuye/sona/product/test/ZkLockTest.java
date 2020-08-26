package com.jiuye.sona.product.test;

import com.jiuye.sona.common.Lock.ZkLockSuper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

/**
 * @Author: xinjian.hu
 * @Date: 2020/8/26 14:44
 * @Email: huxinjian@jiuyescm.com
 */
public class ZkLockTest {

    Lock zkLock = new ZkLockSuper("/zk-test");


    public void calculate(Map<String, Integer> map) {
        zkLock.lock();
        try {
            map.put("test",  map.get("test") +1);
        } finally {
            zkLock.unlock();
        }
    }

    public void calculate2(Map<String, Integer> map) {
       map.put("test",  map.get("test") +1);
    }

    public static void main(String[] args) throws InterruptedException {
        Map<String, Integer> map = new HashMap<>();
        map.put("test", 0);
//        ZkLockTest server1 = new ZkLockTest();
//        server1.calculate2(map);
//        System.out.println("计算后的结果是："+ map.get("test"));
//        int a = 0;
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            ZkLockTest server1 = new ZkLockTest();
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    server1.calculate(map);
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("计算后的结果是：" + map.get("test"));
    }
}
