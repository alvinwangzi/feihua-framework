package com.feihua.framework.scheduler.test;

import com.feihua.framework.scheduler.BaseQuartzJob;
import org.quartz.JobExecutionContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yangwei
 * Created at 2018/12/18 11:13
 */
public class QuartzJobExample extends BaseQuartzJob {
    @Override
    public void doExecute(JobExecutionContext jobExecutionContext) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "★★★★★★★★★★★");
    }
}
