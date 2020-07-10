package com.jiuye.sona.common.vo.base;

import lombok.Data;

/**
 * @Author: xinjian.hu
 * @Date: 2020/7/10 15:39
 * @Email: huxinjian@jiuyescm.com
 */
@Data
public class SonaBasicResponseVo<T> {

    /**
     * 成功标识
     */
    private boolean isSuccess;

    /**
     * 返回码
     */
    private String code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 数据体
     */
    private T Data;
}
