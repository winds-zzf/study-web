package com.winds.task;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
@Component
@EnableScheduling
public class JobTask {
    public void start() throws InterruptedException{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.err.println("定时任务开始执行。"+format.format(new Date()));
    }
}
