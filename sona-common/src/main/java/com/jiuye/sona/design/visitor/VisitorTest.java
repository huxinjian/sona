package com.jiuye.sona.design.visitor;

/**
 * 访问者模式测试
 *
 * @Author: xinjian.hu
 * @Date: 2020/10/12 17:57
 * @Email: huxinjian@jiuyescm.com
 */
public class VisitorTest {

    public static void main(String[] args) {

        DataView dataView = new DataView();
        // 家长
        System.out.println("家长视⻆访问： ");
        dataView.show(new Parent());
        // 校长
        System.out.println("校长视⻆访问： ");
        dataView.show(new Principal());

    }
}
