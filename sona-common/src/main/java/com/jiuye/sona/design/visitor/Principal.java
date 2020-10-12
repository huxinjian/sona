package com.jiuye.sona.design.visitor;

/**
 * 访问者校长
 *
 * @Author: xinjian.hu
 * @Date: 2020/10/12 17:35
 * @Email: huxinjian@jiuyescm.com
 */
public class Principal implements Visitor {

    /**
     * 访问学生
     *
     * @param student
     */
    @Override
    public void visit(Student student) {
        System.out.println("学⽣信息 姓名："+ student.name +"班级： {}" + student.clazz);
    }

    /**
     * 访问老师
     *
     * @param teacher
     */
    @Override
    public void visit(Teacher teacher) {
        System.out.println("学⽣信息 姓名："+ teacher.name +" 班级：" + teacher.clazz + " 升学率：" + teacher.entranceRatio());
    }
}
