package com.jiuye.sona.rest.entity;

import lombok.Data;

/**
 * @Author: xinjian.hu
 * @Date: 2021/1/6 15:31
 * @Email: huxinjian@jiuyescm.com
 */
@Data
public class CipherData {

    private Long id;
    /**
     * 初始化向量
     */
    private String iv;
    /**
     * 密钥
     */
    private String secureKey;
}
