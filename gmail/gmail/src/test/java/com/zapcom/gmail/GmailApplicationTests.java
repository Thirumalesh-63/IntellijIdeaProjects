package com.zapcom.gmail;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.apache.hc.core5.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.zapcom.common.model.Booking;
import com.zapcom.common.model.User;
import com.zapcom.gmail.controller.GmailController;
import com.zapcom.gmail.controller.Service.GmailService;
@SpringBootTest
@AutoConfigureMockMvc
class GmailApplicationTests {

	@Test
	void contextLoads() {
	}
	
	
	@InjectMocks
	private GmailController gmailController;

	
	@Mock
	private GmailService gmailService;
	
	Booking book;
	
	@BeforeEach
	public void setup() {
		book=new Booking();
		// Initialize other fields if necessary
		book.setPnrNumber("98776465789");
	}
	
	@Test
	public void testGetUser() {
		when(gmailService.saveBooking(book)).thenReturn(book);

		String response = gmailController.sendmail(book);

		verify(gmailService, times(1)).saveBooking(book);
		assert (response).equals("Message Sent");
	}

}
