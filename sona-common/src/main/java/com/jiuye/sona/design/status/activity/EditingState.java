package com.jiuye.sona.design.status.activity;

import com.jiuye.sona.design.status.ActivityService;
import com.jiuye.sona.design.status.Result;
import com.jiuye.sona.design.status.Status;

/**
 * 编辑状态
 *
 * @Author: xinjian.hu
 * @Date: 2020/10/12 15:53
 * @Email: huxinjian@jiuyescm.com
 */
public class EditingState extends State {

    @Override
    public Result arraignment(String activityId, Enum<Status>
        currentStatus){
        ActivityService.execStatus(activityId, currentStatus, Status.Check);
        return new Result("0000", "活动提审成功");
    }

    @Override
    public Result close(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus,
            Status.Close);
        return new Result("0000", "活动关闭成功");
    }
}
