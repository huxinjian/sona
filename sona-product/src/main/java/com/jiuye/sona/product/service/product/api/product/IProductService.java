package com.jiuye.sona.product.service.product.api.product;

import com.jiuye.sona.common.vo.product.ProductVo;

/**
 * @Author: xinjian.hu
 * @Date: 2020/7/13 11:40
 * @Email: huxinjian@jiuyescm.com
 */
public interface IProductService {


    ProductVo queryProductInfo(String productId);
}
