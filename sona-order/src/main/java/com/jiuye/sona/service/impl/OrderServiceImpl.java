package com.jiuye.sona.service;

import com.jiuye.sona.common.vo.product.ProductVo;
import com.jiuye.sona.entity.OrderDetailEntity;
import com.jiuye.sona.entity.OrderEntity;
import com.jiuye.sona.service.api.outer.product.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xinjian.hu
 * @Date: 2020/7/10 15:46
 * @Email: huxinjian@jiuyescm.com
 */
@Slf4j
@Service("orderService")
public class OrderServiceImpl {

    @Autowired
    private ProductService productService;

    public void createOrder(OrderEntity orderEntity) {

        List<OrderDetailEntity> orderDetailEntityList = orderEntity.getOrderDetail();
        for (OrderDetailEntity orderDetailEntity : orderDetailEntityList) {
            String productId = orderDetailEntity.getProductId();
            ProductVo productInfo = productService.queryProductInfo(productId);
        }

    }
}
