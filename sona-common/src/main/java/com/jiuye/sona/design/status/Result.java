package com.jiuye.sona.design.status;

import lombok.Data;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/12 15:50
 * @Email: huxinjian@jiuyescm.com
 */
@Data
public class Result {

    private String code;

    private String msg;

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
