package com.spring.batch.config;

import java.sql.*;
import javax.sql.DataSource;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.batch.entity.Contract;

@Component
public class ContractReader extends JdbcCursorItemReader<Contract> implements ItemReader<Contract> {

    final static String SELECT_QUERY = "SELECT * FROM CONTRACT";
    public ContractReader(@Autowired DataSource primaryDataSource) {
        setDataSource(primaryDataSource);
        setSql(SELECT_QUERY);
        setFetchSize(100);
        setRowMapper(new ContractRowMapper());
    }

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