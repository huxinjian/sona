package com.jiuye.sona.design.visitor;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/12 17:34
 * @Email: huxinjian@jiuyescm.com
 */
public class Student extends User {

    public Student(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int ranking() {
        return (int) (Math.random() * 100);
    }
}
