package com.jiuye.sona.design.combination;

import java.util.Map;

/**
 * 性别节点
 * @Author: xinjian.hu
 * @Date: 2020/10/30 15:39
 * @Email: huxinjian@jiuyescm.com
 */
public class UserGenderFilter extends BaseLogic {

    /**
     * 获取决策值
     *
     * @param treeId
     * @param userId
     * @param decisionMatter 决策物料
     * @return
     */
    @Override
    public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
        return decisionMatter.get("gender");
    }
}
