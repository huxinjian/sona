package com.jiuye.sona.design.visitor;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/12 17:30
 * @Email: huxinjian@jiuyescm.com
 */
public abstract class User {
    /**
     * 姓名
     */
    public String name;
    /**
     *  身份；重点班、普通班 | 特级教师、普通教师、实习教师
     */
    public String identity;
    /**
     * 班级
     */
    public String clazz;

    public User(String name, String identity, String clazz) {
        this.name = name;
        this.identity = identity;
        this.clazz = clazz;
    }

    /**
     * 核⼼访问⽅法
     *
     * @param visitor
     */
    public abstract void accept(Visitor visitor);
}
