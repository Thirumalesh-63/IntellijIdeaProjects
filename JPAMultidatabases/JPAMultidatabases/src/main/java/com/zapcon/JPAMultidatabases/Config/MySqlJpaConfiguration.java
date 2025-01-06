package com.zapcon.JPAMultidatabases.Config;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


@Configuration
@EnableJpaRepositories (
        basePackages = "com.zapcon.JPAMultidatabases.OrdersRepo",
        entityManagerFactoryRef = "mySqlEntityManagerFactoryBean",
        transactionManagerRef = "mySqlTransactionManger"
)
public class MySqlJpaConfiguration {


    @Bean
    public LocalContainerEntityManagerFactoryBean mySqlEntityManagerFactoryBean(
            EntityManagerFactoryBuilder builder,
            @Qualifier("mySqlDataSource") DataSource dataSource) {

        return builder
                .dataSource(dataSource)
                .packages("com.zapcon.JPAMultidatabases.OrderEntity")
                .build();
    }

    @Bean
    PlatformTransactionManager mySqlTransactionManger(@Qualifier("mySqlEntityManagerFactoryBean") LocalContainerEntityManagerFactoryBean lcemf){

        return new JpaTransactionManager(lcemf.getObject());
    }
}
