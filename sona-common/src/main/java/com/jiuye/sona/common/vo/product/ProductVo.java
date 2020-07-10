package com.jiuye.sona.common.vo.product;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Author: xinjian.hu
 * @Date: 2020/7/10 18:10
 * @Email: huxinjian@jiuyescm.com
 */
@Data
public class ProductVo {

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
