package com.jiuye.sona.design.visitor;

/**
 * 访问者-家长
 *
 * @Author: xinjian.hu
 * @Date: 2020/10/12 17:39
 * @Email: huxinjian@jiuyescm.com
 */
public class Parent implements Visitor {

    /**
     * 访问学生
     *
     * @param student
     */
    @Override
    public void visit(Student student) {
        System.out.println("学⽣信息 姓名：" + student.name + "班级："+ student.clazz +"排名：" + student.ranking());
    }

    /**
     * 访问老师
     *
     * @param teacher
     */
    @Override
    public void visit(Teacher teacher) {
        System.out.println("⽼师信息 姓名： "+ teacher.name +" 班级： "+ teacher.clazz + "级别：" + teacher.identity);
    }
}
