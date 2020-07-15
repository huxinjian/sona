package com.jiuye.sona.product.service.product.impl;

import com.jiuye.sona.product.dao.ProductDao;
import com.jiuye.sona.product.entity.ProductEntity;
import com.jiuye.sona.product.service.product.api.product.IProductService;
import com.jiuye.sona.common.vo.product.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @Author: xinjian.hu
 * @Date: 2020/7/13 11:39
 * @Email: huxinjian@jiuyescm.com
 */
@Service("productService")
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductDao productDao;

    /**
     * @param productId
     * @return
     */
    @Override
    public ProductVo queryProductInfo(String productId) {
        ProductVo productVo = new ProductVo();
        ProductEntity productEntity = productDao.queryProduct(productId);
        if (!Objects.isNull(productEntity)) {
            productVo.setProductId(productEntity.getProductId());
            productVo.setProductName(productEntity.getProductName());
            productVo.setSku(productEntity.getSku());
        }
        return productVo;
    }
}
