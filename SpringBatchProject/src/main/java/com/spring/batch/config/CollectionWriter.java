package com.spring.batch.config;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.*;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.spring.batch.entity.Collection;

@Component
public class CollectionWriter extends JdbcBatchItemWriter<Collection> implements ItemWriter<Collection>{
	
	final static String INSERT_QUERY = "INSERT INTO COLLECTION (clientnumber, collectiondate, premium) VALUES (:clientnumber, :collectiondate, :premium)";

	public CollectionWriter(NamedParameterJdbcTemplate jdbcTemplate) {
		setSql(INSERT_QUERY);
		setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
		setJdbcTemplate(jdbcTemplate);
		setAssertUpdates(false);
	}

	@Override
	public void write(List<? extends Collection> list) throws Exception {
		super.write(list);
	}
}

