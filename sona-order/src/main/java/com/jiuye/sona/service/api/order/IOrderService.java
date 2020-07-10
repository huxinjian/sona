package com.jiuye.sona.service.api.order;

import com.jiuye.sona.entity.OrderEntity;

/**
 * @Author: xinjian.hu
 * @Date: 2020/7/10 17:31
 * @Email: huxinjian@jiuyescm.com
 */
public interface IOrderService {

    /**
     * 创建订单
     *
     * @param orderEntity
     */
    void createOrder(OrderEntity orderEntity);
}
