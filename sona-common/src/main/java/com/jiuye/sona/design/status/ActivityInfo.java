package com.jiuye.sona.design.status;

import lombok.Data;

import java.util.Date;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/12 15:31
 * @Email: huxinjian@jiuyescm.com
 */
@Data
public class ActivityInfo {

    /**
     * 活动ID
     */
    private String activityId;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 活动状态
     */
    private Enum<Status> status;

    /**
     * 开始时间
     */
    private Date beginTime;

    /**
     *  结束时间
     */
    private Date endTime;
}
