package com.example.quartzhelloworld.playground;

import com.example.quartzhelloworld.info.TImerInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PlaygroundController {

    private final PlaygroundService service;

    @PostMapping("/helloworld")
    public void runHelloWorldJob(){
        service.runHelloWorldJob();
    }

    @GetMapping("/allTimers")
    public List<TImerInfo> getAllRunningTimers(){
        return service.getAllRunningTimers();
    }
}

