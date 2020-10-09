package com.jiuye.sona.design.Decorator;

/**
 * @Author: xinjian.hu
 * @Date: 2020/9/24 18:04
 * @Email: huxinjian@jiuyescm.com
 */
public class ManDecoratorA extends Decorator {

    public ManDecoratorA(Person person) {
        super(person);
    }


    @Override
    public void eat() {
        super.eat();
        reEat();
        System.out.println("ManDecoratorA类");
    }

    public void reEat() {
        System.out.println("再吃一顿饭,加肉");
    }
}
