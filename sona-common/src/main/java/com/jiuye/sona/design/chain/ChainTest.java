package com.jiuye.sona.design.chain;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Date;

/**
 * @Author: xinjian.hu
 * @Date: 2020/9/27 19:19
 * @Email: huxinjian@jiuyescm.com
 */
public class ChainTest {

    private static Logger logger = LoggerFactory.getLogger(ChainTest.class);

    public static void main(String[] args) throws ParseException {

        AuthLink authLink = new Level3AuthLink("1000013", "王⼯")
            .appendNext(new Level2AuthLink("1000012", "张经理")
                .appendNext(new Level1AuthLink("1000011", "段总")));

        System.out.println("测试结果： {}"+ JSON.toJSONString(authLink.doAuth("⼩傅哥",
            "1000998004813441", new Date())));
        // 模拟三级负责⼈审批
        AuthService.auth("1000013", "1000998004813441");
        System.out.println("测试结果： {}"+ "模拟三级负责⼈审批，王⼯");
        System.out.println("测试结果： {}" + JSON.toJSONString(authLink.doAuth("⼩傅哥",
            "1000998004813441", new Date())));
        // 模拟⼆级负责⼈审批
        AuthService.auth("1000012", "1000998004813441");
        System.out.println("测试结果： {}"+ "模拟⼆级负责⼈审批，张经理");
        System.out.println("测试结果： {}"+ JSON.toJSONString(authLink.doAuth("⼩傅哥",
            "1000998004813441", new Date())));
        // 模拟⼀级负责⼈审批
        AuthService.auth("1000011", "1000998004813441");
        System.out.println("测试结果： {}" + "模拟⼀级负责⼈审批，段总");
        System.out.println("测试结果： {}" + JSON.toJSONString(authLink.doAuth("⼩傅哥",
            "1000998004813441", new Date())));
    }
}
