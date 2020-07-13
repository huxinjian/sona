package com.jiuye.sona.product.service.product.impl;

import com.jiuye.sona.product.service.product.api.product.IProductService;
import com.jiuye.sona.common.vo.product.ProductVo;
import org.springframework.stereotype.Service;

/**
 * @Author: xinjian.hu
 * @Date: 2020/7/13 11:39
 * @Email: huxinjian@jiuyescm.com
 */
@Service("productService")
public class ProductServiceImpl implements IProductService {

    /**
     *
     * @param productId
     * @return
     */
    @Override
    public ProductVo queryProductInfo(String productId) {
        ProductVo productVo = new ProductVo();
        if(productId.equals("001")) {
            productVo.setProductId("001");
            productVo.setProductName("金华火腿");
            productVo.setSku("001");
        }
        return productVo;
    }
}
