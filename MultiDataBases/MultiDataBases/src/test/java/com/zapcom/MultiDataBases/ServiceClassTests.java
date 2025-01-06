//package com.zapcom.MultiDataBases;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//public class ServiceClassTests{
//
//    @Test
//    void contextLoads() {
//    }
//
//    @Mock
//    private JdbcTemplate h2JdbcTemplate;
//
//    @Mock
//    private JdbcTemplate mysqlJdbcTemplate;
//
//    private User user;
//
//    @InjectMocks
//    private Service1 userservice;
//
//    @BeforeEach
//    public void setup() {
////        MockitoAnnotations.openMocks(this);
//        user = new User();
//        user.setId(1);
//        user.setName("Test User");
//        // Initialize other fields if necessary
//    }
//
//    @Test
//    public void testSqldatabase_UserExists() {
//
//        // Mock the behavior of findById to return 1 (user exists)
//        when(userservice.findById(user.getId())).thenReturn(10);
//        when(userservice.updateRecord(user)).thenReturn(1);
//        // Act
//        String result = userservice.sqldatabase(user);
//
//        // Assert
//        assertEquals("User updated successfully", result);
//
//    }
//    @Test
//    public void testSqldatabase_UserDoesNotExist() {
//        when(userservice.findById(user.getId())).thenReturn(0);
//        when(userservice.saveRecord(user)).thenReturn(1);
//        // Act
//        String result = userservice.sqldatabase(user);
//
//        // Assert
//        assertEquals("User inserted successfully.", result);
//    }
//    @Test
//    public void testSqldatabase_ExceptionThrown() {
//        // Mock behavior to throw an exception in findById
//        when(userservice.findById(user.getId())).thenThrow(new RuntimeException("Database error"));
//
//        // Act
//        String result = userservice.sqldatabase(user);
//
//        // Assert
//        assertEquals("error occured", result);
//    }
//}
//
//
