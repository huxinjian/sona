package com.jiuye.sona.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @Author: xinjian.hu
 * @Date: 2020/7/10 15:28
 * @Email: huxinjian@jiuyescm.com
 */
@Data
public class OrderDetailEntity {

    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 订单行号
     */
    private String orderItemNo;

    /**
     * 商品数量
     */
    private BigDecimal productNum;

    /**
     * sku
     */
    private String sku;

    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 批次号
     */
    private String batchCode;

    /**
     * 过期日期
     */
    private Timestamp expireDate;
}
