package com.spring.batch.config;

import java.util.List;

import org.slf4j.*;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.spring.batch.entity.Collection;

import lombok.extern.slf4j.Slf4j;

@Configuration
//ItemWriter configuration to write the data into Collection after processing Contract data
public class ItemWriterConfiguration {

	Logger log = LoggerFactory.getLogger(ItemWriterConfiguration.class);

	@Bean
	public ItemWriter<Collection> itemWriter(NamedParameterJdbcTemplate jdbcTemplate) {

		final String INSERT_QUERY = "INSERT INTO COLLECTION (clientnumber, collectiondate, premium) VALUES (:clientnumber, :collectiondate, :premium)";

		JdbcBatchItemWriter<Collection> itemWriter = new JdbcBatchItemWriter<Collection>() {
			public void write(List<? extends Collection> items) throws Exception {
				//writing all items in database
				super.write(items);
				log.info("item processed - " + items.size());

			}
		};

		itemWriter.setSql(INSERT_QUERY);
		itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
		itemWriter.setJdbcTemplate(jdbcTemplate);
		itemWriter.setAssertUpdates(false);

		return itemWriter;
	}

}