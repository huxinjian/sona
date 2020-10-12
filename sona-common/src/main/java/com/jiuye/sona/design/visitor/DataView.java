package com.jiuye.sona.design.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/12 17:45
 * @Email: huxinjian@jiuyescm.com
 */
public class DataView {
    List<User> userList = new ArrayList<User>();

    public DataView() {
        userList.add(new Student("谢⻜机", "᯿点班", "⼀年⼀班"));
        userList.add(new Student("windy", "᯿点班", "⼀年⼀班"));
        userList.add(new Student("⼤⽑", "普通班", "⼆年三班"));
        userList.add(new Student("Shing", "普通班", "三年四班"));
        userList.add(new Teacher("BK", "特级教师", "⼀年⼀班"));
        userList.add(new Teacher("娜娜Goddess", "特级教师", "⼀年⼀班"));
        userList.add(new Teacher("dangdang", "普通教师", "⼆年三班"));
        userList.add(new Teacher("泽东", "实习教师", "三年四班"));
    }


    /**
     * 展示数据
     *
     * @param visitor
     */
    public void show(Visitor visitor) {
        for (User user : userList) {
            user.accept(visitor);
        }
    }

}
