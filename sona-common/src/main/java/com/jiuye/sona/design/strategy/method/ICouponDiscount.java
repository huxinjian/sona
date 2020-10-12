package com.jiuye.sona.design.strategy.method;

import java.math.BigDecimal;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/12 16:40
 * @Email: huxinjian@jiuyescm.com
 */
public interface ICouponDiscount<T> {

    /**
     * 优惠券⾦额计算
     * @param couponInfo 券折扣信息；直减、满减、折扣、 N元购
     * @param skuPrice sku⾦额
     * @return 优惠后⾦额
     */
    BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice);
}
