package com.example.quartzhelloworld.info;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TImerInfo {
    private int totalFireCount;
    private boolean runForever;
    private long repeatIntervalMs;
    private long initialOffsetMs;
    private String callbackData;
}
