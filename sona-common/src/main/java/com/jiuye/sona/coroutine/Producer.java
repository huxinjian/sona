package com.jiuye.sona.coroutine;


import kilim.Fiber;
import kilim.Mailbox;
import kilim.Task;

/**
 * @Author: xinjian.hu
 * @Date: 2020/12/29 17:26
 * @Email: huxinjian@jiuyescm.com
 */
public class Producer extends Task<Object> {

    Integer count = null;

    Mailbox<Integer> mb = null;

    public Producer(Integer count, Mailbox<Integer> mb) {
        this.count = count;
        this.mb = mb;
    }

    @Override
    public void execute() throws Exception {
        count = count * 10;
        for (int i = 0; i < 10; i++) {
            mb.put(count);
            System.out.println(Thread.currentThread().getName() + "生产者生产， 目前总共有" + mb.size());
            count++;
        }
    }
}
