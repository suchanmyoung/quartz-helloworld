package com.config;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class SimpleJob extends QuartzJobBean {

    private int MAX_SLEEP_IN_SECONDS = 5;
    private volatile Thread curThread;

    @SneakyThrows
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        JobKey jobKey = context.getJobDetail().getKey();
        curThread = Thread.currentThread();

        IntStream.range(0, 5).forEach(i ->
                log.info("Simple Job Counting - {}", i));
        TimeUnit.SECONDS.sleep(MAX_SLEEP_IN_SECONDS);
    }
}
