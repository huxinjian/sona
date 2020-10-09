package com.jiuye.sona.design.command.cuisine;

import com.jiuye.sona.design.command.cook.ICook;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/9 17:48
 * @Email: huxinjian@jiuyescm.com
 */
public class ShanDongCuisine implements ICuisine {

    private ICook cook;

    public ShanDongCuisine(ICook cook) {
        this.cook = cook;
    }

    @Override
    public void cook() {
        cook.doCooking();
    }
}
