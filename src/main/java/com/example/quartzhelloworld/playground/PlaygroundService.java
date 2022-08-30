package com.example.quartzhelloworld.playground;

import com.example.quartzhelloworld.info.TImerInfo;
import com.example.quartzhelloworld.jobs.HelloWorldJob;
import com.example.quartzhelloworld.timeservice.SchedulerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class PlaygroundService {

    private final SchedulerService scheduler;

    public void runHelloWorldJob(){
        final TImerInfo info = new TImerInfo();
        info.setTotalFireCount(5);
        info.setRepeatIntervalMs(2000);
        info.setInitialOffsetMs(1000);
        info.setCallbackData("MyCallBack");

        scheduler.schedule(HelloWorldJob.class, info);
    }

    public List<TImerInfo> getAllRunningTimers(){
        return scheduler.getAllRunningTimers();
    }

    public TImerInfo getRunningTimer(String timerId) {
        return scheduler.getRunningTimer(timerId);
    }
}
