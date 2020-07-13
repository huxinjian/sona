package com.jiuye.sona.product.controller;

import com.jiuye.sona.common.vo.base.SonaBasicResponseVo;
import com.jiuye.sona.common.vo.product.ProductVo;
import com.jiuye.sona.product.service.product.api.product.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xinjian.hu
 * @Date: 2020/7/13 13:08
 * @Email: huxinjian@jiuyescm.com
 */
@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/{productId}")
    public SonaBasicResponseVo<ProductVo> queryProductInfo(@PathVariable("productId") String productId) {
        SonaBasicResponseVo<ProductVo> sonaBasicResponseVo = new SonaBasicResponseVo<>();
        try {
            ProductVo productVo = productService.queryProductInfo(productId);
            sonaBasicResponseVo.setSuccess(true);
            sonaBasicResponseVo.setMessage("成功");
            sonaBasicResponseVo.setCode("200");
            sonaBasicResponseVo.setData(productVo);
        } catch (Exception e) {
            log.error("获取运单号失败", e);
            sonaBasicResponseVo.setSuccess(false);
            sonaBasicResponseVo.setMessage("失败");
            sonaBasicResponseVo.setCode("500");
        }
        return sonaBasicResponseVo;

    }

}
