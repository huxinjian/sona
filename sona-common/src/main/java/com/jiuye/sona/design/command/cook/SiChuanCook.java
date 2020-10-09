package com.jiuye.sona.design.command.cook;

import com.jiuye.sona.design.command.cook.ICook;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/9 17:55
 * @Email: huxinjian@jiuyescm.com
 */
public class SiChuanCook implements ICook {

    @Override
    public void doCooking() {
        System.out.println("四川厨师，烹饪川菜，中国最有特⾊的菜系，也是⺠间最⼤菜系。");
    }
}
