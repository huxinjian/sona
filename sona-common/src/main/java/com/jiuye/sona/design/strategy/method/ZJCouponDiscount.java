package com.jiuye.sona.design.strategy.method;

import java.math.BigDecimal;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/12 16:44
 * @Email: huxinjian@jiuyescm.com
 */
public class ZJCouponDiscount implements ICouponDiscount<Double> {

    /**
     *  直减计算
     * 1. 使⽤商品价格减去优惠价格
     * 2. 最低⽀付⾦额1元
     */
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(couponInfo));
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) {
            return BigDecimal.ONE;
        }
        return discountAmount;
    }
}
