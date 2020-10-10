package com.jiuye.sona.design.iterator;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/10 15:05
 * @Email: huxinjian@jiuyescm.com
 */
public interface Collection<E, L> extends Iterable<E> {

    /**
     * 添加元素
     *
     * @param e
     * @return
     */
    boolean add(E e);

    /**
     * 删除元素
     *
     * @param e
     * @return
     */
    boolean remove(E e);

    /**
     * 添加链路
     *
     * @param key
     * @param l
     * @return
     */
    boolean addLink(String key, L l);

    /**
     * 删除链路
     *
     * @param key
     * @return
     */
    boolean removeLink(String key);
}
