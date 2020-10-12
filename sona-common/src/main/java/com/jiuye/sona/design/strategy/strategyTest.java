package com.jiuye.sona.design.strategy;

import com.jiuye.sona.design.strategy.method.ZJCouponDiscount;

import java.math.BigDecimal;

/**
 * 策略模式测试
 *
 * @Author: xinjian.hu
 * @Date: 2020/10/12 16:50
 * @Email: huxinjian@jiuyescm.com
 */
public class strategyTest {

    public static void main(String[] args) {
        // 直减； 100-10，商品100元
        Context<Double> context = new Context<>(new ZJCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(10D, new BigDecimal(100));
        System.out.println("测试结果：直减优惠后⾦额" + discountAmount);
    }
}
