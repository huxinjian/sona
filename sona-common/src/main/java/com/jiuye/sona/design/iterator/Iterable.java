package com.jiuye.sona.design.iterator;

/**
 * 可迭代的接口
 *
 * @Author: xinjian.hu
 * @Date: 2020/10/10 15:02
 * @Email: huxinjian@jiuyescm.com
 */
public interface Iterable<E> {

    /**
     * 获取迭代器
     * 
     * @return
     */
    Iterator<E> iterator();
}
