package com.example.quartzhelloworld.timeservice;

import com.example.quartzhelloworld.info.TImerInfo;
import com.example.quartzhelloworld.util.TimerUtils;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class SchedulerService {

    private final Scheduler scheduler;

    @SneakyThrows
    public void schedule(final Class jobClass, final TImerInfo info) {
        log.info("Schedule");
        final JobDetail jobDetail = TimerUtils.buildJobDetail(jobClass, info);
        final Trigger trigger = TimerUtils.buildTrigger(jobClass, info);

        scheduler.scheduleJob(jobDetail, trigger);
    }

    @SneakyThrows
    public List<TImerInfo> getAllRunningTimers(){
        return scheduler.getJobKeys(GroupMatcher.anyGroup())
                .stream()
                .map(jobKey -> {
                    try {
                        return (TImerInfo) scheduler.getJobDetail(jobKey).getJobDataMap().get(jobKey.getName());
                    } catch (SchedulerException e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    public TImerInfo getRunningTimer(String timerId) {
        return (TImerInfo) scheduler.getJobDetail(new JobKey(timerId)).getJobDataMap().get(timerId);
    }

    @SneakyThrows
    @PostConstruct
    public void init(){
        log.info("Init");
        scheduler.start();
    }

    @SneakyThrows
    @PreDestroy
    public void preDestroy() {
        log.info("Destroy");
        scheduler.shutdown();
    }
}
