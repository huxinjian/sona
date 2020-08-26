package com.jiuye.sona.common.Lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

/**
 * @Author: xinjian.hu
 * @Date: 2020/8/26 14:44
 * @Email: huxinjian@jiuyescm.com
 */
public class ZkLockTest {

    Lock zkLock = new ZkLockSuper("zk-test");


    public void calculate(int a) {
        zkLock.lock();
        try {
            a = a+1;
        } finally {
            zkLock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        int a = 0;
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for(int i = 0; i < 5; i++){
            new Thread(() -> {
                ZkLockTest server1 = new ZkLockTest();
                for(int j= 0; j < 10; j++) {
                    server1.calculate(a);
                }
                countDownLatch.countDown();
            });
            countDownLatch.await();
            System.out.println("计算后的结果是："+ a);
        }
    }
}
