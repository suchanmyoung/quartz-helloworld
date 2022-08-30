package com.example.quartzhelloworld.jobs;

import com.example.quartzhelloworld.info.TImerInfo;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Slf4j
public class HelloWorldJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        TImerInfo info = (TImerInfo) jobDataMap.get(HelloWorldJob.class.getSimpleName());
        log.info(info.getCallbackData());
    }
}
