package com.jiuye.sona.design.iterator;

import lombok.Data;

/**
 * 雇员实体类
 *
 * @Author: xinjian.hu
 * @Date: 2020/10/10 14:54
 * @Email: huxinjian@jiuyescm.com
 */
@Data
public class Employee {
    /**
     * ID
     */
    private String uId;
    /**
     *  姓名
     */
    private String name;
    /**
     * 备注
     */
    private String desc;

    public Employee(String uId, String name, String desc){
        this.uId = uId;
        this.name = name;
        this.desc = desc;
    }
}
