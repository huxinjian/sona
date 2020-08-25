package com.jiuye.sona.common.Lock;

import com.alibaba.fastjson.JSON;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkNodeExistsException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 该版本为zk分布式锁容易发生惊群效应
 *
 * @Author: xinjian.hu
 * @Date: 2020/8/25 16:36
 * @Email: huxinjian@jiuyescm.com
 */
public class ZkLock implements Lock {

    private static final Logger log = LoggerFactory.getLogger(ZkLock.class);
    /**
     * 锁路径父节点
     */
    private String lockPath;

    /**
     * zk 客户端，对zk进行操作完成锁操作
     */
    private ZkClient client;


    private static final String serverPath = "localhost:2181";


    public ZkLock(String lockPath) {
        if (StringUtils.isEmpty(lockPath)) {
            throw new IllegalArgumentException("分布式锁的路径为空");
        }
        this.lockPath = lockPath;
        client = new ZkClient(serverPath);
        // 设置序列化器
        client.setZkSerializer(new SonaZkSerializer());
    }

    /**
     * 获取锁
     */
    @Override
    public void lock() {
        if (!tryLock()) {
            // 等待释放锁
            waitForLock();
            // 递归调用自己
            lock();
        }
        log.info("获取分布式锁成功");
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    /**
     * 尝试获取锁
     *
     * @return
     */
    @Override
    public boolean tryLock() {
        try {
            client.createEphemeral(lockPath);
        } catch (ZkNodeExistsException e) {
            return false;
        }
        return true;
    }

    /**
     * 带有超时机制尝试获取锁
     *
     * @param time
     * @param unit
     * @return
     * @throws InterruptedException
     */
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    /**
     * 释放锁
     */
    @Override
    public void unlock() {
        client.delete(lockPath);
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    /**
     * 阻塞等待锁的释放
     */
    private void waitForLock() {
        // 倒序锁存器
        CountDownLatch countDownLatch = new CountDownLatch(1);

        IZkDataListener listener = new IZkDataListener() {

            @Override
            public void handleDataChange(String dataPath, Object data) {
                log.info("收到节点信息改变{},修改信息为{}", dataPath, JSON.toJSONString(data));
            }

            @Override
            public void handleDataDeleted(String dataPath) {
                log.info("收到节点删除, 释放的的锁名称是{}", dataPath);
                countDownLatch.countDown();
            }
        };
        // 监听器与路径进行绑定
        client.subscribeDataChanges(lockPath, listener);

        // 阻塞等待,等待倒序锁存器建到零
        if (this.client.exists(lockPath)) {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 取消注册
        client.unsubscribeDataChanges(lockPath, listener);
    }
}
