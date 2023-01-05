package notificationservice.notificationservice.service;




import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import notificationservice.notificationservice.model.MessageDTO;

public interface EmailService {
	void sendEmail(MessageDTO maDto);
}


@Service
class EmailServiceImpl implements EmailService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private SpringTemplateEngine templateEngine;

	@Override
	public void sendEmail(MessageDTO maDto) {
		try {
			logger.info("Start ... Sending Email!");
			
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, StandardCharsets.UTF_8.name());
			
			Context context = new Context();
			context.setVariable("name", maDto.getToName());
			context.setVariable("content", maDto.getContent());
			String html = templateEngine.process("welcom-email", context);
			
			helper.setTo(maDto.getTo());
			helper.setText(html, true);
			helper.setFrom(maDto.getFrom());
			helper.setSubject(maDto.getSubject());
			javaMailSender.send(message);
			
			logger.info("END ... Email send success");
		} catch (MessagingException e) {
			logger.error("Email send with error: "+ e.getMessage());
		}
	}
	
}
