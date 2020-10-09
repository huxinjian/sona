package com.jiuye.sona.design.Decorator;

/**
 * @Author: xinjian.hu
 * @Date: 2020/9/24 18:02
 * @Email: huxinjian@jiuyescm.com
 */
public abstract class Decorator implements Person {

    private Person person;

    public Decorator(Person person) {
        this.person = person;
    }

    /**
     * 吃饭抽象修饰类
     */
    @Override
    public void eat() {
        person.eat();
    }
}
