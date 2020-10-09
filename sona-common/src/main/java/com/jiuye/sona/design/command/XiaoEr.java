package com.jiuye.sona.design.command;

import com.jiuye.sona.design.command.cuisine.ICuisine;

import java.util.ArrayList;
import java.util.List;

/**
 * 店小二
 *
 * @Author: xinjian.hu
 * @Date: 2020/10/9 17:58
 * @Email: huxinjian@jiuyescm.com
 */
public class XiaoEr {

    private List<ICuisine> cuisineList = new ArrayList<ICuisine>();

    /**
     * 点菜
     *
     * @param cuisine
     */
    public void order(ICuisine cuisine) {
        cuisineList.add(cuisine);
    }

    /**
     * 下单
     */
    public synchronized void placeOrder() {
        for (ICuisine cuisine : cuisineList) {
            cuisine.cook();
        }
        cuisineList.clear();
    }
}
