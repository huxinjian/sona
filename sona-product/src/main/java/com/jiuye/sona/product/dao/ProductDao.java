package com.jiuye.sona.product.dao;

import com.jiuye.sona.product.entity.ProductEntity;

/**
 * @Author: xinjian.hu
 * @Date: 2020/7/14 17:31
 * @Email: huxinjian@jiuyescm.com
 */
public interface ProductDao {

    /**
     * 查询商品信息
     *
     * @param productId
     * @return
     */
    ProductEntity queryProduct(String productId);
}
