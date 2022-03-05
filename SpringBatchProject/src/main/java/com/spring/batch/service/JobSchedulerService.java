package com.spring.batch.service;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.Service;

import lombok.SneakyThrows;

//job scheduler to trigger job 
@Service
public class JobSchedulerService {

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

