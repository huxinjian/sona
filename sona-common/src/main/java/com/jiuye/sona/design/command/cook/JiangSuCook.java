package com.jiuye.sona.design.command.cook;

import com.jiuye.sona.design.command.cook.ICook;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/9 17:52
 * @Email: huxinjian@jiuyescm.com
 */
public class JiangSuCook implements ICook {
    @Override
    public void doCooking() {
        System.out.println("江苏厨师，烹饪苏菜，宫廷第⼆⼤菜系，古今国宴上最受⼈欢迎的菜系。");
    }
}
