package com.spring.batch.config;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.spring.batch.entity.Collection;


/**
 * This is a writer class which contains the business logic to write the data to
 * output database.
 * 
 * @author Bhagyashri Niphade
 */
@Component
public class CollectionWriter extends JdbcBatchItemWriter<Collection> implements ItemWriter<Collection>{
	
	public CollectionWriter(NamedParameterJdbcTemplate jdbcTemplate, @Value("${spring.batch.entity.contract.insert}") String collectioninsertSql) {
		setSql(collectioninsertSql);
		setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
		setJdbcTemplate(jdbcTemplate);
		setAssertUpdates(false);
	}

	@Override
	public void write(List<? extends Collection> list) throws Exception {
		super.write(list);
	}
}

