package com.spring.batch.config;

import java.util.*;
import javax.sql.DataSource;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.*;
import org.springframework.batch.item.database.support.MySqlPagingQueryProvider;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.spring.batch.entity.Contract;

@Configuration
//ItemReader configuration to read the input table (Contract) from database 
public class ItemReaderConfiguration {

    @Bean
    public ItemReader<Contract> itemReader(DataSource dataSource) {
        JdbcPagingItemReader<Contract> jdbcPagingItemReader = new JdbcPagingItemReader<>();
        jdbcPagingItemReader.setDataSource(dataSource);
        jdbcPagingItemReader.setPageSize(1000);

        PagingQueryProvider queryProvider = createQuery();
        jdbcPagingItemReader.setQueryProvider(queryProvider);
        jdbcPagingItemReader.setRowMapper(new BeanPropertyRowMapper<>(Contract.class));
        return jdbcPagingItemReader;
    }

    private PagingQueryProvider createQuery() {
        MySqlPagingQueryProvider queryProvider = new MySqlPagingQueryProvider();
        queryProvider.setSelectClause("SELECT * ");
        queryProvider.setFromClause("FROM CONTRACT");
        queryProvider.setSortKeys(sortByCreationDate());
        return queryProvider;
    }

    private Map<String, Order> sortByCreationDate() {
        Map<String, Order> stringOrderMap = new LinkedHashMap<>();
        stringOrderMap.put("collectionday", Order.ASCENDING);
        return stringOrderMap;
    }

}