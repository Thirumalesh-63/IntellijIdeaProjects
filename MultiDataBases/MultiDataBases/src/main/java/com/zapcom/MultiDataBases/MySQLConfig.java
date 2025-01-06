package com.zapcom.MultiDataBases;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class MySQLConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.mysql")
    public DataSourceProperties mysqlDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource mysqlDataSource() {
        return mysqlDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean
    public JdbcTemplate mysqlJdbcTemplate(DataSource mysqlDataSource) {
        return new JdbcTemplate(mysqlDataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate mysqlNamedParameterJdbcTemplate(DataSource mysqlDataSource) {
        return new NamedParameterJdbcTemplate(mysqlDataSource);
    }

    @Bean
    @ConfigurationProperties("spring.datasource.h2")
    public DataSourceProperties h2DataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource h2DataSource() {
        return h2DataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean
    public JdbcTemplate h2JdbcTemplate(DataSource h2DataSource) {
        return new JdbcTemplate(h2DataSource);
    }
}
