package com.jiuye.sona.common.Lock;

import org.I0Itec.zkclient.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 该版本为zk分布式锁的升级版本，正确规避惊群效应
 *
 * @Author: xinjian.hu
 * @Date: 2020/8/25 18:10
 * @Email: huxinjian@jiuyescm.com
 */
public class ZkLockSuper implements Lock {


    private static final Logger log = LoggerFactory.getLogger(ZkLock.class);

    /**
     * 锁路径父节点
     */
    private String lockPath;

    /**
     * zk 客户端，对zk进行操作完成锁操作
     */
    private ZkClient client;

    /**
     * 服务器路径
     *
     */
    private static final String serverPath = "localhost:2181";

    /**
     * 使用锁的入口
     */
    @Override
    public void lock() {

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
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
