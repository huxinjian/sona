package com.jiuye.sona.service;

import com.alibaba.fastjson.JSON;
import com.jiuye.sona.common.vo.base.SonaBasicResponseVo;
import com.jiuye.sona.common.vo.product.ProductVo;
import com.jiuye.sona.entity.OrderDetailEntity;
import com.jiuye.sona.entity.OrderEntity;
import com.jiuye.sona.service.api.order.IOrderService;
import com.jiuye.sona.service.api.outer.product.ProductFeignService;
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
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private ProductFeignService productFeignService;

    /**
     * 生成订单逻辑
     *
     * @param orderEntity
     */
    @Override
    public void createOrder(OrderEntity orderEntity) {

        List<OrderDetailEntity> orderDetailEntityList = orderEntity.getOrderDetail();
        for (OrderDetailEntity orderDetailEntity : orderDetailEntityList) {
            String productId = orderDetailEntity.getProductId();
            SonaBasicResponseVo<ProductVo> sonaBasicResponseVo = productFeignService.queryProductInfo(productId);
            log.info("获取商品信息的返回结果是：" + JSON.toJSONString(sonaBasicResponseVo));
        }
    }
}
