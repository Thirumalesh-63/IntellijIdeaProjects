package com.zapcon.JPAMultidatabases.Config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class H2DataSourceConfiguration {


    @Bean
    @ConfigurationProperties("spring.datasource.h2")
    public DataSourceProperties h2Properties(){

        return new DataSourceProperties();
    }

    @Bean
    public DataSource h2DataSorce(){

        return h2Properties().initializeDataSourceBuilder().build();
    }
}
