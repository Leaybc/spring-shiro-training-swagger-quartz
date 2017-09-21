package com.lee.commons.utils;


import com.lee.commons.scan.BusinessException;
import com.lee.model.PlanInfo;
import com.lee.quartz.JobFactory;
import com.lee.quartz.JobSyncFactory;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 定时任务辅助类
 * <p>
 * Created by liyd on 12/19/14.
 */
public class ScheduleUtils {

    /**
     * 日志对象
     */
    private static final Logger LOG = LoggerFactory.getLogger(ScheduleUtils.class);

    /**
     * 获取触发器key
     *
     * @param jobName
     * @param jobGroup
     * @return
     */
    public static TriggerKey getTriggerKey(String jobName, String jobGroup) {

        return TriggerKey.triggerKey(jobName, jobGroup);
    }

    /**
     * 获取表达式触发器
     *
     * @param scheduler the scheduler
     * @param jobName   the job name
     * @param jobGroup  the job group
     * @return cron trigger
     */
    public static CronTrigger getCronTrigger(Scheduler scheduler, String jobName, String jobGroup) {

        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
            return (CronTrigger) scheduler.getTrigger(triggerKey);
        } catch (SchedulerException e) {
            LOG.error("获取定时任务CronTrigger出现异常", e);
            throw new BusinessException("获取定时任务CronTrigger出现异常");
        }
    }

    /**
     * 创建任务
     *
     * @param scheduler the scheduler
     * @param planInfo  the planInfo
     */
    public static CronTrigger createScheduleJob(Scheduler scheduler, PlanInfo planInfo) {
        CronTrigger cronTrigger = createScheduleJob(scheduler, planInfo.getId().toString(), planInfo.getId().toString(),
                planInfo.getCronValue(), true, planInfo);
        return cronTrigger;
    }

    /**
     * 创建定时任务
     *
     * @param scheduler      the scheduler
     * @param jobName        the job name
     * @param jobGroup       the job group
     * @param cronExpression the cron expression
     * @param isSync         the is sync
     * @param param          the param
     */
    public static CronTrigger createScheduleJob(Scheduler scheduler, String jobName, String jobGroup,
                                                String cronExpression, boolean isSync, Object param) {
        //同步或异步
        Class<? extends Job> jobClass = isSync ? JobSyncFactory.class : JobFactory.class;

        //构建job信息
        JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroup).build();

        //放入参数，运行时的方法可以获取
        jobDetail.getJobDataMap().put(PlanInfo.JOB_PARAM_KEY, param);

        //表达式调度构建器
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

        //按新的cronExpression表达式构建一个新的trigger
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName, jobGroup)
                .withSchedule(scheduleBuilder).build();

        try {
            scheduler.scheduleJob(jobDetail, trigger);
            return trigger;
        } catch (SchedulerException e) {
            e.printStackTrace();
            LOG.error("创建定时任务失败", e);
            throw new BusinessException("创建定时任务失败");
        }
    }

    /**
     * 运行一次任务
     *
     * @param scheduler
     * @param jobName
     * @param jobGroup
     */
    public static void runOnce(Scheduler scheduler, String jobName, String jobGroup) {
        JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
        try {
            scheduler.triggerJob(jobKey);
        } catch (SchedulerException e) {
            LOG.error("运行一次定时任务失败", e);
            throw new BusinessException("运行一次定时任务失败");
        }
    }

    /**
     * 暂停任务
     *
     * @param scheduler
     * @param jobName
     * @param jobGroup
     */
    public static void pauseJob(Scheduler scheduler, String jobName, String jobGroup) {

        JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
        try {
            scheduler.pauseJob(jobKey);
        } catch (SchedulerException e) {
            LOG.error("暂停定时任务失败", e);
            throw new BusinessException("暂停定时任务失败");
        }
    }

    /**
     * 恢复任务
     *
     * @param scheduler
     * @param jobName
     * @param jobGroup
     */
    public static void resumeJob(Scheduler scheduler, String jobName, String jobGroup) {

        JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
        try {
            scheduler.resumeJob(jobKey);
        } catch (SchedulerException e) {
            LOG.error("暂停定时任务失败", e);
            throw new BusinessException("暂停定时任务失败");
        }
    }

    /**
     * 获取jobKey
     *
     * @param jobName  the job name
     * @param jobGroup the job group
     * @return the job key
     */
    public static JobKey getJobKey(String jobName, String jobGroup) {

        return JobKey.jobKey(jobName, jobGroup);
    }

    /**
     * 更新定时任务
     *
     * @param scheduler the scheduler
     * @param planInfo  the schedule job
     */
    public static void updateScheduleJob(Scheduler scheduler, PlanInfo planInfo) {
        updateScheduleJob(scheduler, planInfo.getId().toString(), planInfo.getId().toString(),
                planInfo.getCronValue(), true, planInfo);
    }

    /**
     * 更新定时任务
     *
     * @param scheduler      the scheduler
     * @param jobName        the job name
     * @param jobGroup       the job group
     * @param cronExpression the cron expression
     * @param isSync         the is sync
     * @param param          the param
     */
    public static void updateScheduleJob(Scheduler scheduler, String jobName, String jobGroup,
                                         String cronExpression, boolean isSync, Object param) {

        //同步或异步
//        Class<? extends Job> jobClass = isSync ? JobSyncFactory.class : JobFactory.class;

        try {
//            JobDetail jobDetail = scheduler.getJobDetail(getJobKey(jobName, jobGroup));

//            jobDetail = jobDetail.getJobBuilder().ofType(jobClass).build();

            //更新参数 实际测试中发现无法更新
//            JobDataMap jobDataMap = jobDetail.getJobDataMap();
//            jobDataMap.put(ScheduleJobVo.JOB_PARAM_KEY, param);
//            jobDetail.getJobBuilder().usingJobData(jobDataMap);

            TriggerKey triggerKey = ScheduleUtils.getTriggerKey(jobName, jobGroup);

            //表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

            if (trigger == null) {
                //创建触发器

                //构建job信息
                JobDetail jobDetail = JobBuilder.newJob(JobSyncFactory.class).withIdentity(jobName, jobGroup).build();
                //放入参数，运行时的方法可以获取
                jobDetail.getJobDataMap().put(PlanInfo.JOB_PARAM_KEY, param);
                trigger = TriggerBuilder.newTrigger().withIdentity(jobName, jobGroup)
                        .withSchedule(scheduleBuilder).build();
                try {
                    scheduler.scheduleJob(jobDetail, trigger);
                } catch (SchedulerException e) {
                    LOG.error("创建定时任务失败", e);
                    throw new BusinessException("创建定时任务失败");
                }
            } else {
                //按新的cronExpression表达式重新构建trigger
                trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder)
                        .build();

                //按新的trigger重新设置job执行
                scheduler.rescheduleJob(triggerKey, trigger);
            }

        } catch (SchedulerException e) {
            LOG.error("更新定时任务失败", e);
            throw new BusinessException("更新定时任务失败");
        }
    }

    /**
     * 删除定时任务
     *
     * @param scheduler
     * @param jobName
     * @param jobGroup
     */
    public static void deleteScheduleJob(Scheduler scheduler, String jobName, String jobGroup) {
        try {
            scheduler.deleteJob(getJobKey(jobName, jobGroup));
        } catch (SchedulerException e) {
            LOG.error("删除定时任务失败", e);
            throw new BusinessException("删除定时任务失败");
        }
    }
}
