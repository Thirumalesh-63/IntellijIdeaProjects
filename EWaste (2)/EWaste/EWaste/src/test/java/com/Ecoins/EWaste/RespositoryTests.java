package com.Ecoins.EWaste;

import org.springframework.boot.test.context.SpringBootTest;

import com.Ecoins.EWaste.Model.IdentityUserDetailsMapper;
import com.Ecoins.EWaste.Model.UserDetails;
import com.Ecoins.EWaste.Repository.SQLQueries;
import com.Ecoins.EWaste.Repository.UsersRepository;
import com.Ecoins.EWaste.Service.Service1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RespositoryTests {


    @InjectMocks
    private SQLQueries queries;


    @Test
    void contextLoads() {
    }


    @Test
    public void testUpsertUserDetails_UserExists() throws Exception {

        // Mock the repository behavior
        when(queries.findById(456)).thenReturn(1); // Simulate that user exists
        when(queries.updateRecord(any())).thenReturn(1); // Simulate update
        when(queries.saveRecord(any())).thenReturn(1); // Simulate save (though this shouldn't be called)

        // When
//        String result = userService.upsertUserDetails(jsonLiteral);
//
//        // Then
//        assertEquals("456", result); // Check if the returned userId is correct

    }
}

