package com.winds.config;

import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import com.winds.task.JobTask;

@Configuration
public class QuartzConfiguration {

    @Bean(name="jobDetail")
    public MethodInvokingJobDetailFactoryBean detailFactoryBean(JobTask task) {
        // ScheduledTask为需要执行的任务
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();

        /*
         * 是否并发执行
         * 例如每3秒执行一次任务，但是当前任务还没有执行完，就已经过了3s了。
         * 如果此处为true，则下一个任务会并发执行，如果此处为false，则下一个任务会等待上一个任务执行完后，再开始执行
         */
        jobDetail.setConcurrent(true);
        jobDetail.setName("scheduler");     //设置任务的名字
        jobDetail.setGroup("scheduler_group");  //设置任务的分组，这些属性都可以存储在数据库中，在多任务的时候使用

        /*
         * 这两行代码表示执行task对象中的scheduleTest方法，定时执行的逻辑都在scheduleTest中
         */
        jobDetail.setTargetObject(task);
        jobDetail.setTargetMethod("start");
        return jobDetail;
    }

    @Bean(name="jobTrigger")
    public CronTriggerFactoryBean cronJobTrigger(MethodInvokingJobDetailFactoryBean jobDetail){
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setJobDetail(jobDetail.getObject());
        trigger.setCronExpression("*/5 * * * * ?"); // 每5s执行一次
        trigger.setName("myTrigger");   // trigger的name
        return trigger;
    }

    /**
     * 注意这里的Trigger使用的是org.quartz.Trigger
     */
    @Bean(name="scheduler")
    public SchedulerFactoryBean schedulerFactory(Trigger cronJobTrigger){
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        /*
         * 设置是否任意一个已定义的Job会覆盖现在的Job。默认为false，即已定义的Job不会覆盖现有的Job
         */
        bean.setOverwriteExistingJobs(true); // 延时启动，应用启动5s后，定时器才开始启动
        bean.setStartupDelay(5);
        bean.setTriggers(cronJobTrigger);

        return bean;
    }

    /**
     * 多任务时的Scheduler，动态设置Trigger。一个SchedulerFactoryBean可能会有多个Trigger
     */
    @Bean(name="multitaskScheduler")
    public SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        return schedulerFactoryBean;
    }
}
