package com.jiuye.sona.design.status.activity;

import com.jiuye.sona.design.status.Result;
import com.jiuye.sona.design.status.Status;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/12 15:49
 * @Email: huxinjian@jiuyescm.com
 */
public abstract class State {

    /**
     * 活动提审
     *
     * @param activityId
     * @param currentStatus
     * @return
     */
    public Result arraignment(String activityId, Enum<Status>
        currentStatus){
        return new Result("0001", "待审核状态不可᯿复提审");
    }

    /**
     * 审核通过
     *
     * @param activityId 活动ID
     * @param currentStatus 当前状态
     * @return 执⾏结果
     */
    public Result checkPass(String activityId, Enum<Status>
        currentStatus){
        return new Result("0001", "编辑中不可审核通过");
    }

    /**
     * 审核拒绝
     *
     * @param activityId 活动ID
     * @param currentStatus 当前状态
     * @return 执⾏结果
     */
    public Result checkRefuse(String activityId, Enum<Status>
        currentStatus){
        return new Result("0001", "编辑中不可审核拒绝");
    }
    /**
     * 撤审撤销
     *
     * @param activityId 活动ID
     * @param currentStatus 当前状态
     * @return 执⾏结果
     */
    public Result checkRevoke(String activityId, Enum<Status>
        currentStatus) {
        return new Result("0001", "编辑中不可撤销审核");
    }

    /**
     * 活动关闭
     *
     * @param activityId 活动ID
     * @param currentStatus 当前状态
     * @return 执⾏结果
     */
    public Result close(String activityId, Enum<Status>
        currentStatus) {
        return new Result("0000", "活动关闭成功");
    }

    /**
     * 活动开启
     *
     * @param activityId 活动ID
     * @param currentStatus 当前状态
     * @return 执⾏结果
     */
    public Result open(String activityId, Enum<Status>
        currentStatus){
        return new Result("0001", "⾮关闭活动不可开启");
    }

    /**
     * 活动执⾏
     *
     * @param activityId 活动ID
     * @param currentStatus 当前状态
     * @return 执⾏结果
     */
    public Result doing(String activityId, Enum<Status>
        currentStatus){
        return new Result("0001", "编辑中活动不可执⾏活动中变更");
    }
}
