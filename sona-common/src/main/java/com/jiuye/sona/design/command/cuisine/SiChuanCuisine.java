package com.jiuye.sona.design.command.cuisine;

import com.jiuye.sona.design.command.cook.ICook;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/9 17:49
 * @Email: huxinjian@jiuyescm.com
 */
public class SiChuanCuisine implements ICuisine {

    private ICook cook;

    public SiChuanCuisine(ICook cook) {
        this.cook = cook;
    }

    @Override
    public void cook() {
        cook.doCooking();
    }
}
