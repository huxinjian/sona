package com.jiuye.sona.design.strategy;

import com.jiuye.sona.design.strategy.method.ICouponDiscount;

import java.math.BigDecimal;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/12 16:49
 * @Email: huxinjian@jiuyescm.com
 */
public class Context<T> {

    private ICouponDiscount<T> couponDiscount;

    public Context(ICouponDiscount<T> couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    /**
     * 执行折扣
     *
     * @param couponInfo
     * @param skuPrice
     * @return
     */
    public BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice) {
        return couponDiscount.discountAmount(couponInfo, skuPrice);
    }
}
