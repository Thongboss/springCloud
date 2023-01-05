package notificationservice.notificationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {
	private String from;
	private String to;
	private String toName;
	private String subject;
	private String content;
}
