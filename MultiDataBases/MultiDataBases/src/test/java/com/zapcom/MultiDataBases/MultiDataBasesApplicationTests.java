package com.zapcom.MultiDataBases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.mockito.Mockito.*;

@SpringBootTest
class MultiDataBasesApplicationTests {

	@Test
	void contextLoads() {
	}

	private User user;

	@Mock
	private Service1 userservice;

	@InjectMocks
	private Controller userController;

	@BeforeEach
	public void setup() {
		user = new User();
		user.setId(1);
		user.setName("Test User");
		// Initialize other fields if necessary
	}

	@Test
	public void testGetUser() {
		when(userservice.sqldatabase(user)).thenReturn("User updated successfully ");

		String response = userController.getAllFromsql(user);

		verify(userservice, times(1)).sqldatabase(user);
		assert (response).contains("successfully");
	}

}
