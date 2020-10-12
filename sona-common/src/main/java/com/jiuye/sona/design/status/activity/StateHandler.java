package com.jiuye.sona.design.status.activity;

import com.jiuye.sona.design.status.Result;
import com.jiuye.sona.design.status.Status;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/12 16:04
 * @Email: huxinjian@jiuyescm.com
 */
public class StateHandler {

    private Map<Enum<Status>, State> stateMap = new ConcurrentHashMap<Enum<Status>, State>();

    public StateHandler() {
        // 待审核
        stateMap.put(Status.Check, new CheckState());
        // 已关闭
        //stateMap.put(Status.Close, new CloseState());
        // 活动中
        //stateMap.put(Status.Doing, new DoingState());
        // 编辑中
        stateMap.put(Status.Editing, new EditingState());
        // 已开启
        //stateMap.put(Status.Open, new OpenState());
        // 审核通过
        //stateMap.put(Status.Pass, new PassState());
        // 审核拒绝
        //stateMap.put(Status.Refuse, new RefuseState());
    }

    public Result arraignment(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).arraignment(activityId, currentStatus);
    }

    public Result checkPass(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).checkPass(activityId, currentStatus);
    }

    public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).checkRefuse(activityId, currentStatus);
    }


    public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).checkRevoke(activityId, currentStatus);
    }

    public Result close(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).close(activityId, currentStatus);
    }
}
