package com.wbugaj;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by wbugaj on 2017-04-21.
 */
@Repository
public class BasicDao {
    JdbcTemplate jdbcTemplate;

    /**
     * You have to install database server and run it (PostgreSQL should autorun)
     * You need to create database and provide application with it's url,
     * owner's username and password
     *
     * (change placeholders)
     */

    @PostConstruct
    public void setJdbcTemplate() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/{databaseName}");
        driverManagerDataSource.setUsername("{username}");
        driverManagerDataSource.setPassword("{password}");
        jdbcTemplate = new JdbcTemplate(driverManagerDataSource);
    }

    public void createTable(String tableName) {
        String sql = "CREATE TABLE "+tableName+" (text VARCHAR )";
        jdbcTemplate.update(sql);
    }
    public void dropTable(String tableName) {
        String sql = "DROP TABLE " + tableName;
        jdbcTemplate.update(sql);
    }
    public void insertInto(String tableName, String text) {
        String sql = "INSERT INTO "+tableName+" VALUES('"+text+"')";
        jdbcTemplate.update(sql);
    }
    public List<String> selectFrom(String tableName) {
        String sql = "SELECT text FROM " + tableName;
        return jdbcTemplate.queryForList(sql, String.class);
    }
}
