package com.jiuye.sona.controller;

import com.jiuye.sona.common.vo.base.SonaBasicResponseVo;
import com.jiuye.sona.entity.OrderDetailEntity;
import com.jiuye.sona.entity.OrderEntity;
import com.jiuye.sona.service.api.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xinjian.hu
 * @Date: 2020/7/8 14:52
 * @Email: huxinjian@jiuyescm.com
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    /**
     * 创建订单
     *
     * @return
     */
    @GetMapping("/createOrder")
    public SonaBasicResponseVo creatOrder(){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setProductNum(new BigDecimal(5));
        orderEntity.setReceiveAddress("12312312");
        orderEntity.setReceivePerson("hxj");
        orderEntity.setReceivePhone("13111112222");
        List<OrderDetailEntity> orderDetailEntityList = new ArrayList<>();
        OrderDetailEntity orderDetailEntity1 =  new OrderDetailEntity();
        orderDetailEntity1.setProductId("001");
        orderDetailEntityList.add(orderDetailEntity1);

        OrderDetailEntity orderDetailEntity2 =  new OrderDetailEntity();
        orderDetailEntity2.setProductId("002");
        orderDetailEntityList.add(orderDetailEntity2);

        OrderDetailEntity orderDetailEntity3 =  new OrderDetailEntity();
        orderDetailEntity3.setProductId("003");
        orderDetailEntityList.add(orderDetailEntity3);
        orderEntity.setOrderDetail(orderDetailEntityList);
        orderService.createOrder(orderEntity);

        SonaBasicResponseVo sonaBasicResponse = new SonaBasicResponseVo();
        sonaBasicResponse.setCode("失败");
        sonaBasicResponse.setMessage("成功");
        sonaBasicResponse.setSuccess(true);
        return sonaBasicResponse;
    }
}