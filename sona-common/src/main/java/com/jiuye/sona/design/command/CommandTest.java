package com.jiuye.sona.design.command;

import com.jiuye.sona.design.command.cook.GuangDongCook;
import com.jiuye.sona.design.command.cook.JiangSuCook;
import com.jiuye.sona.design.command.cook.ShanDongCook;
import com.jiuye.sona.design.command.cook.SiChuanCook;
import com.jiuye.sona.design.command.cuisine.*;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/9 18:02
 * @Email: huxinjian@jiuyescm.com
 */
public class CommandTest {

    public static void main(String[] args) {
        // 菜系 + 厨师；⼴东（粤菜）、江苏（苏菜）、⼭东（鲁菜）、四川（川菜）
        ICuisine guangDoneCuisine = new GuangDongCuisine(new GuangDongCook());
        ICuisine jiangSuCuisine = new JiangSuCuisine(new JiangSuCook());
        ICuisine shanDongCuisine = new ShanDongCuisine(new ShanDongCook());
        ICuisine siChuanCuisine = new SiChuanCuisine(new SiChuanCook());
        // 点菜
        XiaoEr xiaoEr = new XiaoEr();
        xiaoEr.order(guangDoneCuisine);
        xiaoEr.order(jiangSuCuisine);
        xiaoEr.order(shanDongCuisine);
        xiaoEr.order(siChuanCuisine);
        // 下单
        xiaoEr.placeOrder();
    }
}
