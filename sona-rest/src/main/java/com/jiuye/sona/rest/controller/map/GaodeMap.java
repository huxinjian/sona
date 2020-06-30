package com.jiuye.sona.rest.controller.map;

import com.jiuye.sona.common.HttpUtil.HttpClientUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xinjian.hu
 * @Date: 2020/6/23 17:02
 * @Email: huxinjian@jiuyescm.com
 */
@RequestMapping("gaode")
@Controller
public class GaodeMap {

    /**
     * 获取高德四级地址
     *
     * @return
     */
    @GetMapping("queryAddressInfo")
    public Object getAddressInfo() throws Exception {
        String url = "https://restapi.amap.com/v3/config/district";
        Map<String, String> params = new HashMap<>();
        params.put("key","cfeb6351758c42fa131477235cfde233");
        params.put("output", "JSON");
        // String result = null;
        String result = HttpClientUtil.doGet(url, params);
        return result;
    }
}
