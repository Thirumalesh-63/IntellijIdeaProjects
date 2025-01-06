package com.zapcon.JPAMultidatabases.Config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class MySqlDataSourceConfiguration {


    @Bean
    @ConfigurationProperties("spring.datasource.mysql")
    public DataSourceProperties mySqlProperties(){

        return new DataSourceProperties();
    }

    @Primary
    @Bean
    public DataSource mySqlDataSource(){

        return mySqlProperties().initializeDataSourceBuilder().build();
    }
}
