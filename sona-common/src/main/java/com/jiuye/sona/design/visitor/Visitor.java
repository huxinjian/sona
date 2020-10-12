package com.jiuye.sona.design.visitor;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/12 17:31
 * @Email: huxinjian@jiuyescm.com
 */
public interface Visitor {

    /**
     * 访问学⽣信息
     *
     * @param student
     */
    void visit(Student student);

    /**
     * 访问⽼师信息
     * @param teacher
     */
    void visit(Teacher teacher);
}
