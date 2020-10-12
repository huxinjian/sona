package com.jiuye.sona.design.visitor;

import java.math.BigDecimal;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/12 17:33
 * @Email: huxinjian@jiuyescm.com
 */
public class Teacher extends User {


    public Teacher(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    /**
     * 升本率
     *
     * @return
     */
    public double entranceRatio() {
        return BigDecimal.valueOf(Math.random() * 100).setScale(2,
            BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
