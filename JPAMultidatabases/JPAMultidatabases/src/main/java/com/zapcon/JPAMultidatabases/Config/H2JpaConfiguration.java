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
        basePackages = "com.zapcon.JPAMultidatabases.ProductsRepo",
        entityManagerFactoryRef = "H2JpaManagerFactoryBean",
        transactionManagerRef = "h2TransactionManger"
)
public class H2JpaConfiguration {


    @Bean
    public LocalContainerEntityManagerFactoryBean H2JpaManagerFactoryBean(
            EntityManagerFactoryBuilder builder,
            @Qualifier("h2DataSorce") DataSource dataSource) {

        return builder
                .dataSource(dataSource)
                .packages("com.zapcon.JPAMultidatabases.ProductEntity")
                .build();
    }

    @Bean
    PlatformTransactionManager h2TransactionManger(@Qualifier("H2JpaManagerFactoryBean") LocalContainerEntityManagerFactoryBean lcemf){

        return new JpaTransactionManager(lcemf.getObject());
    }

}
