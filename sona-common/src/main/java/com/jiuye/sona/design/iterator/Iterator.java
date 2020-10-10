package com.jiuye.sona.design.iterator;

/**
 * 迭代器定义
 *
 * @Author: xinjian.hu
 * @Date: 2020/10/10 15:00
 * @Email: huxinjian@jiuyescm.com
 */
public interface Iterator<E> {
    /**
     * 是否有下一个
     *
     * @return
     */
    boolean hasNext();

    /**
     * 下一个元素
     *
     * @return
     */
    E next();
}
