package com.jiuye.sona.design.chain;

import java.util.Date;

/**
 * @Author: xinjian.hu
 * @Date: 2020/9/27 19:01
 * @Email: huxinjian@jiuyescm.com
 */
public class Level1AuthLink extends AuthLink {


    public Level1AuthLink(String levelUserId, String levelUserName) {
        super(levelUserId, levelUserName);
    }

    @Override
    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(levelUserId, orderId);
        if (null == date) {
            return new AuthInfo("0001", "单号： ", orderId, " 状态：待⼀级审批 负责⼈ ", levelUserName);
        }
        AuthLink next = super.next();
        if (null == next) {
            return new AuthInfo("0000", "单号： ", orderId, " 状态：⼀级审批完 成负责⼈", " 时间： ", sdf.format(date), " 审批⼈： ", levelUserName);
        }
        return next.doAuth(uId, orderId, authDate);
    }
}
