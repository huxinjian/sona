package com.jiuye.sona.design.iterator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/10 15:17
 * @Email: huxinjian@jiuyescm.com
 */
public class GroupStructure implements Collection<Employee, Link> {

    /**
     * 组织ID，也是⼀个组织链的头部ID
     */
    private String groupId;

    /**
     * 组织名称
     */
    private String groupName;

    /**
     * 雇员列表(key:雇员id，value:雇员信息)
     */
    private Map<String, Employee> employeeMap = new ConcurrentHashMap<>();

    /**
     * 组织架构关系； id->list
     */
    private Map<String, List<Link>> linkMap = new ConcurrentHashMap<>();

    /**
     * 反向关系链（key：后一节点雇员的id，value：前一个节点的雇员id）
     */
    private Map<String, String> invertedMap = new ConcurrentHashMap<>();

    public GroupStructure(String groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    /**
     * 添加元素
     *
     * @param employee
     * @return
     */
    @Override
    public boolean add(Employee employee) {
        return null != employeeMap.put(employee.getUId(), employee);
    }

    /**
     * 删除元素
     *
     * @param employee
     * @return
     */
    @Override
    public boolean remove(Employee employee) {
        return null != employeeMap.remove(employee.getUId());
    }

    /**
     * 添加链路
     *
     * @param key
     * @param link
     * @return
     */
    @Override
    public boolean addLink(String key, Link link) {
        //添加反向关系链
        invertedMap.put(link.getToId(), link.getFromId());
        if (linkMap.containsKey(key)) {
            return linkMap.get(key).add(link);
        } else {
            List<Link> links = new LinkedList<>();
            links.add(link);
            linkMap.put(key, links);
            return true;
        }
    }

    /**
     * 删除链路
     *
     * @param key
     * @return
     */
    @Override
    public boolean removeLink(String key) {
        return null != linkMap.remove(key);
    }

    /**
     * 实现迭代器
     *
     * @return
     */
    @Override
    public Iterator<Employee> iterator() {
        return new Iterator<Employee>() {

            HashMap<String, Integer> keyMap = new HashMap<>();

            int totalIdx = 0;
            // 雇员id, from
            private String fromId = groupId;
            // 雇员id，to
            private String toId = groupId;

            /**
             * 是否有下一条数据
             *
             * @return
             */
            @Override
            public boolean hasNext() {
                return totalIdx < employeeMap.size();
            }

            /**
             * 获取下一条数据
             *
             * @return
             */
            @Override
            public Employee next() {
                List<Link> links = linkMap.get(toId);
                int cursorIdx = getCursorIdx(toId);

                if (links == null) {
                    cursorIdx = getCursorIdx(fromId);
                    links = linkMap.get(fromId);
                }
                // 上级节点扫描
                while (cursorIdx > links.size()-1) {
                    fromId = invertedMap.get(fromId);
                    cursorIdx =getCursorIdx(fromId);
                    links = linkMap.get(fromId);
                }
                // 获取节点
                Link link = links.get(cursorIdx);
                toId = link.getToId();
                fromId = link.getFromId();
                totalIdx++;
                //返回结果
                return employeeMap.get(link.getToId());
            }

            /**
             * 给每个层级定义宽度遍历进度
             *
             * @param key
             * @return
             */
            public int getCursorIdx(String key) {
                int idx = 0;
                if (keyMap.containsKey(key)) {
                    idx = keyMap.get(key);
                    keyMap.put(key, ++idx);
                } else {
                    keyMap.put(key, idx);
                }
                return idx;
            }
        };

    }


    public static void main(String[] args) {
        // 数据填充
        GroupStructure groupStructure = new GroupStructure("1", "⼩傅哥");
        // 雇员信息
        groupStructure.add(new Employee("2", "花花", "⼆级部⻔"));
        groupStructure.add(new Employee("3", "⾖包", "⼆级部⻔"));
        groupStructure.add(new Employee("4", "蹦蹦", "三级部⻔"));
        groupStructure.add(new Employee("5", "⼤烧", "三级部⻔"));
        groupStructure.add(new Employee("6", "⻁哥", "四级部⻔"));
        groupStructure.add(new Employee("7", "玲姐", "四级部⻔"));
        groupStructure.add(new Employee("8", "秋雅", "四级部⻔"));
        // 节点关系 1->(1,2) 2->(4,5)
        groupStructure.addLink("1", new Link("1", "2"));
        groupStructure.addLink("1", new Link("1", "3"));
        groupStructure.addLink("2", new Link("2", "4"));
        groupStructure.addLink("2", new Link("2", "5"));
        groupStructure.addLink("5", new Link("5", "6"));
        groupStructure.addLink("5", new Link("5", "7"));
        groupStructure.addLink("5", new Link("5", "8"));
        Iterator<Employee> iterator = groupStructure.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            System.out.println(employee.getDesc() + ",雇员 Id："+employee.getUId()+",Name:" + employee.getName());
        }
    }
}
