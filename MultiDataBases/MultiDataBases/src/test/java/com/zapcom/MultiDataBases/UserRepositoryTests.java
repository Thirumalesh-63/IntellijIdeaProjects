package com.zapcom.MultiDataBases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserRepositoryTests {

    @InjectMocks
    private UserRepository userRepository;  // The class under test

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;  // Mocking NamedParameterJdbcTemplate

    @Mock
    private JdbcTemplate mysqlJdbcTemplate;  // Mocking JdbcTemplate

    private User user;

    @BeforeEach
    public void setup() {
        user = new User();
        user.setId(1);
        user.setName("Test User");
    }


    @Test
    public void testSaveRecord() {
        // Define the expected SQL query with named parameters
        String query = "INSERT INTO user (id, name) VALUES (:id,:name)";
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", user.getId());
        params.put("name", user.getName());

        // Create MapSqlParameterSource from the params
        MapSqlParameterSource expectedParamSource = new MapSqlParameterSource(params);

        // Mock the `update` method to return 1 row affected when called with the correct arguments
        when(namedParameterJdbcTemplate.update(eq(query), any(MapSqlParameterSource.class)))
                .thenReturn(1); // Assuming 1 row is affected by the insert

        // Call the method under test
        userRepository.saveRecord(query, params);

        // Capture the arguments passed to the update method
        ArgumentCaptor<MapSqlParameterSource> captor = ArgumentCaptor.forClass(MapSqlParameterSource.class);
        verify(namedParameterJdbcTemplate, times(1)).update(eq(query), captor.capture());

        // Verify the captured parameters
        MapSqlParameterSource capturedParams = captor.getValue();
        assertEquals(expectedParamSource.getValues(), capturedParams.getValues()); // Verify the parameters match
    }
}


