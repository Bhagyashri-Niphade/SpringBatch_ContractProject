package com.spring.batch.config;

import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

import com.spring.batch.component.CollectionProcessor;
import com.spring.batch.component.CollectionWriter;
import com.spring.batch.component.ContractReader;
import com.spring.batch.entity.*;


/**
 * This is a Configuration class which loads the Spring beans for the batch
 * configuration - job and steps.
 * 
 * @author Bhagyashri Niphade
 */
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	
	 @Autowired
	    public StepBuilderFactory stepBuilderFactory;

		@Autowired
	    private CollectionProcessor processor;

	    @Autowired
	    private ContractReader reader;

	    @Autowired
	    private CollectionWriter writer;

		/**
		 * Creates job for calculating premium.
		 * 
		 * @return Created job instance.
		 */
		@Bean
		public Job startBatch(JobBuilderFactory jobBuilderFactory, Step step1) {
			return jobBuilderFactory.get("contractEffective").incrementer(new RunIdIncrementer()).start(step1).build();
		}


		/**
		 * Creates Step for calculating premium with reader, writer and processor.
		 * 
		 * @return Created Step instance.
		 */
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
