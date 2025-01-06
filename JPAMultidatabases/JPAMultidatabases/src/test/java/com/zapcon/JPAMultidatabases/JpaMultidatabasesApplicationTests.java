package com.zapcon.JPAMultidatabases;
import com.zapcon.JPAMultidatabases.Config.MySqlJpaConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MySqlJpaConfigurationTest {

	@Autowired
	private MySqlJpaConfiguration mySqlJpaConfiguration;

	@Autowired
	private EntityManagerFactoryBuilder entityManagerFactoryBuilder;

	@Autowired
	private DataSource mySqlDataSource;

	@Test
	void testMySqlEntityManagerFactoryBean() {
		// Act
		LocalContainerEntityManagerFactoryBean result = mySqlJpaConfiguration.mySqlEntityManagerFactoryBean(entityManagerFactoryBuilder, mySqlDataSource);

		// Assert
		assertNotNull(result);
	}

}
