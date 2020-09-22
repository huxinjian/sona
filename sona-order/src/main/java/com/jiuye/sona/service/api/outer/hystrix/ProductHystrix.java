package com.jiuye.sona.service.api.outer.hystrix;

import com.jiuye.sona.common.vo.base.SonaBasicResponseVo;
import com.jiuye.sona.common.vo.product.ProductVo;
import com.jiuye.sona.service.api.outer.product.ProductFeignService;
import org.springframework.stereotype.Component;

/**
 * @Author: xinjian.hu
 * @Date: 2020/9/11 10:06
 * @Email: huxinjian@jiuyescm.com
 */
@Component
public class ProductHystrix implements ProductFeignService {

    /**
     * queryProductInfo降级方法
     *
     * @param productId
     * @return
     */
    @Override
    public SonaBasicResponseVo<ProductVo> queryProductInfo(String productId) {
        SonaBasicResponseVo sonaBasicResponseVo = new SonaBasicResponseVo();
        sonaBasicResponseVo.setCode("500");
        sonaBasicResponseVo.setMessage("获取商品信息数据超时");
        sonaBasicResponseVo.setSuccess(false);
        return sonaBasicResponseVo;
    }

    /**
     * queryProductInfo降级方法
     *
     * @param productIds
     * @return
     */
    @Override
    public String queryProductInfos(String productIds) {
        return "获取商品数据超时";
    }
}
