package com.jiuye.sona.design.Decorator;

/**
 * 装饰器模式
 *
 * @Author: xinjian.hu
 * @Date: 2020/9/24 18:08
 * @Email: huxinjian@jiuyescm.com
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Man man = new Man();
        ManDecoratorA mdA = new ManDecoratorA(man);
        ManDecoratorB mdB = new ManDecoratorB(mdA);
        mdB.eat();
        System.out.println("装饰器模式执行完毕");
    }
}
