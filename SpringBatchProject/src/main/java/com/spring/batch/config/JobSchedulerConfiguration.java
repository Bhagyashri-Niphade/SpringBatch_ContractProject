package com.spring.batch.config;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.*;

import lombok.SneakyThrows;

/**
 * This is a scheduler class which schedules multiple jobs and launches
 * according to the parameters provided.
 * 
 * @author Bhagyashri Niphade
 */
@Configuration
@EnableScheduling
public class JobSchedulerConfiguration {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    /**
	 * Triggers the specified job with the given parameters.
	 * 
	 * @throws Exception
	 */
    @SneakyThrows
    @Scheduled(cron = "0 0 6 * * *")
    @Async
    public void startBatch() throws Exception {

        JobParameters jobParameter = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis()).toJobParameters();
      
        jobLauncher.run(job, jobParameter);

        System.out.println("batch started...");
    }
}

