package com.lee.quartz;


import com.xiaoleilu.hutool.date.DateUtil;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


/**
 * 同步的任务工厂类
 * <p>
 * Created by liyd on 12/19/14.
 */
public class JobSyncFactory implements Job {
    @Autowired
    private Scheduler scheduler;


    /* 日志对象 */
    private static final Logger LOG = LoggerFactory.getLogger(JobSyncFactory.class);

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOG.info("JobSyncFactory execute");
        JobDataMap mergedJobDataMap = jobExecutionContext.getMergedJobDataMap();
        System.out.println(DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
