package com.jiuye.sona.coroutine;

import kilim.Mailbox;
import kilim.Pausable;
import kilim.Task;

/**
 * @Author: xinjian.hu
 * @Date: 2020/12/29 17:39
 * @Email: huxinjian@jiuyescm.com
 */
public class Consumer extends Task<Object> {

    Mailbox<Integer> mb = null;

    public Consumer(Mailbox<Integer> mb) {
        this.mb = mb;
    }


    @Override
    public void execute() throws Pausable, Exception {
        Integer c = null;
        for(int i = 0; i < 1000; i++) {
            // 获取消息，阻塞协程线程
            c = mb.get();
            if(c == null) {
                System.out.println("计数");
            } else {
                System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有"
                    + mb.size() + "条，取出的数据是：" + c );
            }
        }
    }
}
