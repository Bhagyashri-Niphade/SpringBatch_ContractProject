package com.spring.batch.component;

import java.sql.*;
import javax.sql.DataSource;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.batch.entity.Contract;

/**
 * This is a reader class which contains the business logic to read the data
 * from input database.
 * 
 * @author Bhagyashri Niphade
 */
@Component
public class ContractReader extends JdbcCursorItemReader<Contract> implements ItemReader<Contract> {
    
    /**
	 * Parameterized constructor to read the data from database table.
	 * 
	 * @param dataSource.
	 */
    public ContractReader(@Autowired DataSource primaryDataSource, 
    		@Value("${spring.batch.entity.contract.select}") String contractSelectSql) {
        setDataSource(primaryDataSource);
        setSql(contractSelectSql);
        setFetchSize(100);
        setRowMapper(new ContractRowMapper());
    }

    /**
	 * This is a mapper class which maps every row with the instance of user-defined
	 * class. It iterates the ResultSet internally and adds it into the collection.
	 * 
	 */
    public class ContractRowMapper implements RowMapper<Contract> {
        @Override
        public Contract mapRow(ResultSet rs, int rowNum) throws SQLException {
            Contract contract = new Contract();
            contract.setId(rs.getInt("id"));
            contract.setClientnumber(rs.getInt("clientnumber"));
            contract.setCollectionday(rs.getInt("collectionday"));
            contract.setProductCode(rs.getString("productCode"));
            contract.setStatus(rs.getString("status"));
            return contract;
        }
    }
}