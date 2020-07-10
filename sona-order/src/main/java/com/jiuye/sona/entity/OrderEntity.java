package com.jiuye.sona.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: xinjian.hu
 * @Date: 2020/7/8 14:54
 * @Email: huxinjian@jiuyescm.com
 */
@Data
public class OrderEntity {

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 商品数量
     */
    private BigDecimal productNum;

    /**
     * 收件人收机号
     */
    private String receivePhone;

    /**
     * 收件人姓名
     */
    private String receivePerson;

    /**
     * 收件地址
     */
    private String receiveAddress;

    /**
     * 发件人
     */
    private String sendPerson;

    /**
     * 发件人手机号
     */
    private String sendPhone;

    /**
     * 发件人地址
     */
    private String sendAddress;

    /**
     * 总价格
     */
    private BigDecimal totalMoney;

    /**
     * 商品id
     */
    private List<OrderDetailEntity> OrderDetail;
}
