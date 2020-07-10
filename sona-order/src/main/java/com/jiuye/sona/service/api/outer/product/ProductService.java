package com.jiuye.sona.service.api.outer.product;

import com.jiuye.sona.common.vo.product.ProductVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: xinjian.hu
 * @Date: 2020/7/10 17:51
 * @Email: huxinjian@jiuyescm.com
 */
@FeignClient
public interface ProductService {

    /**
     * 获取商品信息
     *
     * @param productId
     * @return
     */
    @GetMapping("/product/{productId}")
    ProductVo queryProductInfo(@PathVariable("productId") String productId);


    /**
     * 批量获取商品信息
     *
     * @param productIds
     * @return
     */
    @GetMapping("/product/queryProductList")
    String queryProductInfos(@RequestParam("productIds") String productIds);
}
