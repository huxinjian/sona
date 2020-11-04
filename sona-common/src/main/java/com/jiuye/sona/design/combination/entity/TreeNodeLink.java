package com.jiuye.sona.design.combination.entity;

import lombok.Data;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/30 15:11
 * @Email: huxinjian@jiuyescm.com
 */
@Data
public class TreeNodeLink {


    private long nodeIdFrom;

    private long nodeIdTo;

    /**
     * 节点对比方式
     */
    private int ruleLimitType;

    /**
     * 节点对比值
     */
    private String ruleLimitValue;

}
