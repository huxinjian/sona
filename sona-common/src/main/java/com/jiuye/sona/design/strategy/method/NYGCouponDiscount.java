package com.jiuye.sona.design.strategy.method;

import java.math.BigDecimal;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/12 16:47
 * @Email: huxinjian@jiuyescm.com
 */
public class NYGCouponDiscount implements ICouponDiscount<Double>  {

    /**
     * n元购购买(⽆论原价多少钱都固定⾦额购买)
     * @param couponInfo 券折扣信息；直减、满减、折扣、 N元购
     * @param skuPrice sku⾦额
     * @return
     */
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        return new BigDecimal(couponInfo);
    }
}
