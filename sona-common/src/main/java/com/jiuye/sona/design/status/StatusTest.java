package com.jiuye.sona.design.status;

import com.alibaba.fastjson.JSON;
import com.jiuye.sona.design.status.activity.StateHandler;

/**
 * 状态模式测试
 *
 * @Author: xinjian.hu
 * @Date: 2020/10/12 16:22
 * @Email: huxinjian@jiuyescm.com
 */
public class StatusTest {


    public static void main(String[] args) {
        String activityId = "100001";
        ActivityService.init(activityId, Status.Editing);
        StateHandler stateHandler = new StateHandler();
        Result result = stateHandler.arraignment(activityId, Status.Editing);
        System.out.println("测试结果(编辑中To提审活动)：" + JSON.toJSONString(result));
        System.out.println("活动信息:" + JSON.toJSONString(ActivityService.queryActivityInfo(activityId)) +
            "状态:" + JSON.toJSONString(ActivityService.queryActivityInfo(activityId).getStatus()));
    }
}
