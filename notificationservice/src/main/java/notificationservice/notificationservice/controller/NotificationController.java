package notificationservice.notificationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import notificationservice.notificationservice.model.MessageDTO;
import notificationservice.notificationservice.service.EmailService;

@RestController
public class NotificationController {
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/send-notification")
	public void sendNotification(@RequestBody MessageDTO messageDTO) {
		emailService.sendEmail(messageDTO);
	}
}
