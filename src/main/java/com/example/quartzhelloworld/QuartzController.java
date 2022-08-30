package com.example.quartzhelloworld;

import org.springframework.web.bind.annotation.*;

@RestController
public class QuartzController {

    @PostMapping("/job")
    public void addJob(){

    }

    @GetMapping("/jobs")
    public void getJobs(){

    }

    @DeleteMapping("/job")
    public void deleteJob(){

    }

    @PutMapping("/job")
    public void pauseJob(){

    }

    @PutMapping("/reJob")
    public void resumeJob(){

    }
}
