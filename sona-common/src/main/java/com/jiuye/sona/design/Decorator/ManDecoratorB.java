package com.jiuye.sona.design.Decorator;

/**
 * @Author: xinjian.hu
 * @Date: 2020/9/24 18:06
 * @Email: huxinjian@jiuyescm.com
 */
public class ManDecoratorB extends Decorator {
    public ManDecoratorB(Person person) {
        super(person);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("再吃一顿饭,加鱼");
        System.out.println("ManDecoratorB类");
    }
}
