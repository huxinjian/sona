package com.jiuye.sona.design.command.cook;

import com.jiuye.sona.design.command.cook.ICook;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/9 17:53
 * @Email: huxinjian@jiuyescm.com
 */
public class ShanDongCook implements ICook {

    @Override
    public void doCooking() {
        System.out.println("⼭东厨师，烹饪鲁菜，宫廷最⼤菜系，以孔府⻛味为⻰头");
    }
}
