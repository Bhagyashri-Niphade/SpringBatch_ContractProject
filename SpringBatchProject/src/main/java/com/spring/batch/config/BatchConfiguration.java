package com.spring.batch.config;

import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import com.spring.batch.entity.*;

@Configuration
@EnableBatchProcessing
//Main File for batch processing
public class BatchConfiguration {
	
	 @Autowired
	    public StepBuilderFactory stepBuilderFactory;

		@Autowired
	    private CollectionProcessor processor;

	    @Autowired
	    private ContractReader reader;

	    @Autowired
	    private CollectionWriter writer;

		@Bean
		public Job startBatch(JobBuilderFactory jobBuilderFactory, Step step1) {
			return jobBuilderFactory.get("contractEffective").incrementer(new RunIdIncrementer()).start(step1).build();
		}

		@Bean
		public Step step1(StepBuilderFactory stepBuilderFactory,
				ItemWriter<Collection> itemWriter) {

			return stepBuilderFactory.get("step1")
					.<Contract, Collection>chunk(1000)
	                .reader(reader)
	                .processor(processor)
					.writer(writer)
					.build();
		}
}
