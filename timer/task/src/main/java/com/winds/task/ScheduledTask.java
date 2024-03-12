package com.winds.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 通过添加@Scheduled注解实现定时任务
 * 具体来讲就是在方法上使用@Scheduled注解后，这个方法就会被定期执行
 */
@Component
public class ScheduledTask {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);

    @Scheduled(fixedDelay = 30000)
    public void testOne(){
        log.info("每隔1分钟执行一次");
    }

    @Scheduled(fixedRate = 30000)
    public void testTwo(){
        log.info("每30s执行一次");
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    public void initTask(){
        log.info("执行任务"+new Date());
    }
}
