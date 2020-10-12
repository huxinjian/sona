package com.jiuye.sona.design.strategy.method;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/12 16:42
 * @Email: huxinjian@jiuyescm.com
 */
public class MJCouponDiscount implements ICouponDiscount<Map<String, String>> {

    /**
     * 满减计算
     * @param couponInfo 券折扣信息；直减、满减、折扣、 N元购
     * @param skuPrice sku⾦额
     * @return
     */
    @Override
    public BigDecimal discountAmount(Map<String, String> couponInfo, BigDecimal skuPrice) {
        String x = couponInfo.get("x");
        String o = couponInfo.get("n");
        // ⼩于商品⾦额条件的，直接返回商品原价
        if (skuPrice.compareTo(new BigDecimal(x)) < 0) {
            return skuPrice;
        }
        // 减去优惠⾦额判断
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(o));
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) {
            return BigDecimal.ONE;
        }
        return discountAmount;
    }
}
