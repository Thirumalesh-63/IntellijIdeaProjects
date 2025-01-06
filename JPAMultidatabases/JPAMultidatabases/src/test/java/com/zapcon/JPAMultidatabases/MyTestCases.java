package com.zapcon.JPAMultidatabases;

import com.zapcon.JPAMultidatabases.Config.MySqlJpaConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class MyTestCases {

    @InjectMocks
    private MySqlJpaConfiguration mySqlJpaConfiguration;

    @Mock
    private EntityManagerFactoryBuilder entityManagerFactoryBuilder;

    @Mock
    private DataSource mySqlDataSource;

    private LocalContainerEntityManagerFactoryBean mockFactoryBean;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockFactoryBean = new LocalContainerEntityManagerFactoryBean();

        // Create intermediate mocks
        EntityManagerFactoryBuilder.Builder mockBuilder = mock(EntityManagerFactoryBuilder.Builder.class);

        // Mock each part of the method chain
        when(entityManagerFactoryBuilder.dataSource(mySqlDataSource)).thenReturn(mockBuilder);
        when(mockBuilder.packages("com.zapcon.JPAMultidatabases.OrderEntity")).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockFactoryBean);
    }

    @Test
    void testMySqlEntityManagerFactoryBean() {
        // Act
        LocalContainerEntityManagerFactoryBean result = mySqlJpaConfiguration.mySqlEntityManagerFactoryBean(entityManagerFactoryBuilder, mySqlDataSource);

        // Assert
        assertNotNull(result);
        verify(entityManagerFactoryBuilder).dataSource(mySqlDataSource);
        verify(entityManagerFactoryBuilder.dataSource(mySqlDataSource)).packages("com.zapcon.JPAMultidatabases.OrderEntity");
        verify(entityManagerFactoryBuilder.dataSource(mySqlDataSource).packages("com.zapcon.JPAMultidatabases.OrderEntity")).build();
    }
}