package com.spring.batch.config;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.*;

import lombok.SneakyThrows;

//job scheduler to trigger job 
@Configuration
@EnableScheduling
public class JobSchedulerConfiguration {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;


    @SneakyThrows
    //scheduled everyday at 6am using cron
    @Scheduled(cron = "0 0 6 * * *")
    @Async
    public void startBatch() throws Exception {

        JobParameters jobParameter = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis()).toJobParameters();
        
        //run job 
        jobLauncher.run(job, jobParameter);

        System.out.println("batch started...");
    }
}

