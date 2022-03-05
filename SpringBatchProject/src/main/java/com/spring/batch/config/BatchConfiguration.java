package com.spring.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.batch.entity.*;

@Configuration
//Main File for batch processing
public class BatchConfiguration {
	
	@Autowired
	private Myprocessor myprocessor;

	@Bean
	public Job startBatch(JobBuilderFactory jobBuilderFactory, Step step1) {
		return jobBuilderFactory.get("contractEffective").incrementer(new RunIdIncrementer()).start(step1).build();
	}

	@Bean
	public Step step1(StepBuilderFactory stepBuilderFactory,
			ItemReader<Contract> itemReader,
			ItemProcessor<Contract, Collection> itemProcessor, 
			ItemWriter<Collection> itemWriter) {

		return stepBuilderFactory.get("step1")
				.<Contract, Collection>chunk(1000)
				.reader(itemReader)
				.processor(myprocessor)
				.writer(itemWriter)
				.build();
	}

}
