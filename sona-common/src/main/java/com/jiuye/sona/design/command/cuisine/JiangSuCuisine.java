package com.jiuye.sona.design.command.cuisine;

import com.jiuye.sona.design.command.cook.ICook;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/9 17:47
 * @Email: huxinjian@jiuyescm.com
 */
public class JiangSuCuisine implements ICuisine {

    private ICook cook;

    public JiangSuCuisine(ICook cook) {
        this.cook = cook;
    }

    @Override
    public void cook() {
        cook.doCooking();
    }
}
