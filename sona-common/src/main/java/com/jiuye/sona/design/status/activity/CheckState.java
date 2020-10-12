package com.jiuye.sona.design.status.activity;

import com.jiuye.sona.design.status.ActivityService;
import com.jiuye.sona.design.status.Result;
import com.jiuye.sona.design.status.Status;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/12 16:01
 * @Email: huxinjian@jiuyescm.com
 */
public class CheckState extends State {

    @Override
    public Result checkPass(String activityId, Enum<Status> currentStatus)
    {
        ActivityService.execStatus(activityId, currentStatus,
            Status.Pass);
        return new Result("0000", "活动审核通过完成");
    }

    @Override
    public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus,
            Status.Refuse);
        return new Result("0000", "活动审核拒绝完成");
    }

    @Override
    public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Editing);
        return new Result("0000", "活动审核撤销回到编辑中");
    }

    @Override
    public Result close(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus,
            Status.Close);
        return new Result("0000", "活动审核关闭完成");
    }
}
