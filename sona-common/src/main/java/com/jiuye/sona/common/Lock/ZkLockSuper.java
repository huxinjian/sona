package com.jiuye.sona.common.Lock;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
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
     */
    private static final String serverPath = "localhost:2181";

    /**
     * 子节点（排队票号）
     */
    private ThreadLocal<String> currentPath = new ThreadLocal<String>();
    /**
     * 前一个节点（前一个票号）
     */
    private ThreadLocal<String> beforePath = new ThreadLocal<String>();

    /**
     * 初始化参数
     *
     * @param lockPath
     */
    public ZkLockSuper(String lockPath) {
        if (StringUtils.isEmpty(lockPath)) {
            throw new IllegalArgumentException("锁路径为空，请输入锁路径");
        }
        this.lockPath = lockPath;
        // 创建客户端对象
        client = new ZkClient(serverPath);
        // 设置序列化器
        client.setZkSerializer(new SonaZkSerializer());
        // 创建持久节点
        if (!client.exists(this.lockPath)) {
            client.createPersistent(this.lockPath);
        }
    }

    /**
     * 使用锁的入口
     */
    @Override
    public void lock() {
        if (!tryLock()) {
            // 等待释放锁
            waitForLock();
            // 递归调用自己
            lock();
        }

    }

    /**
     * 尝试获取锁
     *
     * @return
     */
    @Override
    public boolean tryLock() {
        // 当前节点为空则创建临时顺序节点
        if (this.currentPath.get() == null || !client.exists(this.currentPath.get())) {
            String node = this.client.createEphemeralSequential(lockPath + "/", "sona-locked");
            currentPath.set(node);
        }
        // 获取当前节点下所有的子节点
        List<String> children = client.getChildren(lockPath);
        // 对节点进行由小到大排序
        Collections.sort(children);
        String firstChild = lockPath + "/" + children.get(0);
        // 如果当前节点是最小的节点则获取到锁
        if (firstChild.equals(currentPath.get())) {
            return true;
        } else {
            // 得到字节的索引号（获取当前节点的索引序号）
            int curIndex = children.indexOf(currentPath.get().substring(lockPath.length() + 1));
            // 获取前一个索引节点
            String beforeNode = lockPath + "/" + children.get(curIndex - 1);
            beforePath.set(beforeNode);
            return false;
        }
    }

    /**
     * 释放锁的逻辑
     */
    @Override
    public void unlock() {
        if (this.currentPath != null) {
            client.delete(currentPath.get());
            currentPath.set(null);
            log.info("释放锁成功");
        }
    }

    /**
     * 等待释放锁
     */
    private void waitForLock() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        // zk数据节点的监听器
        IZkDataListener dataListener = new IZkDataListener() {
            /**
             * 数据改变执行业务
             * @param dataPath
             * @param data
             * @throws Exception
             */
            @Override
            public void handleDataChange(String dataPath, Object data) {
                log.info("zk数据改变");
            }

            /**
             * 数据删除的执行方法
             * @param dataPath
             * @throws Exception
             */
            @Override
            public void handleDataDeleted(String dataPath) {
                countDownLatch.countDown();
                log.info("zk锁被释放，释放锁的名称是{}", dataPath);
            }
        };
        // 绑定监听节点
        client.subscribeDataChanges(beforePath.get(), dataListener);
        if (this.client.exists(beforePath.get())) {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 解除监听
        client.unsubscribeDataChanges(beforePath.get(), dataListener);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) {
        return false;
    }


    @Override
    public void lockInterruptibly() throws InterruptedException {

    }


    @Override
    public Condition newCondition() {
        return null;
    }
}
