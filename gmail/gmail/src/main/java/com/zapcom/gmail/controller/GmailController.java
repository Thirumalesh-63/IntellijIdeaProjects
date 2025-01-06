package com.zapcom.gmail.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.retry.annotation.Backoff;

import com.zapcom.common.model.Booking;
import com.zapcom.gmail.controller.Service.GmailService;
import com.zapcom.gmail.controller.exceptions.InvalidEmailException;

@RestController
@RequestMapping("/gmail")
public class GmailController {
	
	
	@Autowired
	private GmailService gmailService;
	
	private static Logger log=LoggerFactory.getLogger(GmailController.class);
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@RetryableTopic(attempts = "4",autoStartDltHandler = "true",exclude = {InvalidEmailException.class},
			backoff = @Backoff(delay = 2000, multiplier = 2, maxDelay = 10000)
)
    @KafkaListener(topics = "Booking",groupId = "bookings")
	public String sendmail(Booking booking)  {
		
	//	gmailService.saveBooking(booking);
		
		log.info(booking.getCruise().getCruiseName());
//		  if(booking.getUser().getName().equals("kiran")){
//			  throw new InvalidEmailException("invalid email");
//			  }
//		  else if(booking.getUser().getName().equals("jairaj")) {
//			  throw new RuntimeException();
//		  }
//		 
		
		
		log.info(booking.getCruise().getCruiseName());
		log.info(booking.getUser().getEmail());
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("gt121603@gmail.com");
	    message.setTo(booking.getUser().getEmail());
	    // Set the subject to include cruise information
	    message.setSubject("Booking Confirmation for " + booking.getCruise().getCruiseName());

	    // Customize the email text
	    String emailText = String.format(
	        "Hello %s,\n\nThank you for booking with us!\n\n" +
	        "You have successfully booked the cruise '%s'.\n" +
	        "Booking Details:\n" +
	        "User: %s\n" +
	        "Cruise Name: %s\n" +
	        "Cruise Start Date: %s\n" +
	        "Cruise Start Destination: %s\n" +
	        "We look forward to seeing you on cruise!\n\n" +
	        "\n\n\n" +
	        "Best regards,\n" +
	        "Cruise Company",
	        booking.getUser().getName(),
	        booking.getCruise().getCruiseName(),
	        booking.getUser().getEmail(),
	        booking.getCruise().getCruiseName(),
	        booking.getCruise().getStartdate(),
	        booking.getCruise().getStartdestination()
	    );

	    log.info(emailText);
	    message.setText(emailText);
	        javaMailSender.send(message);
	        return "Message Sent";
	}
	
	
	    @DltHandler
	    public void listenDLT(Booking book,@Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                @Header(KafkaHeaders.OFFSET) long offset) {
	        log.info("DLT Received : {} , from {} , offset {}",book.getCruise().getCruiseName(),topic,offset);
	    }
}
	


