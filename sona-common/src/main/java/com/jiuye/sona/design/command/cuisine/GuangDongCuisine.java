package com.jiuye.sona.design.command.cuisine;

import com.jiuye.sona.design.command.cook.ICook;

/**
 * 广东菜品
 *
 * @Author: xinjian.hu
 * @Date: 2020/10/9 17:39
 * @Email: huxinjian@jiuyescm.com
 */
public class GuangDongCuisine implements ICuisine {


    private ICook cook;

    public GuangDongCuisine(ICook cook) {
        this.cook = cook;
    }

    /**
     * 厨师烹饪广东菜
     */
    @Override
    public void cook() {
        cook.doCooking();
    }
}
