package Main.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import Main.Services.EmailService;

@Service
public class Email implements EmailService {


	private String to;
	private String subject;
	private String bodytext;
	
	@Autowired
    private JavaMailSender javaMailSender;

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBodytext() {
		return bodytext;
	}

	public void setBodytext(String bodytext) {
		this.bodytext = bodytext;
	}

	public Email() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sendEmail( String to, String subject, String bodytext) {
       
		SimpleMailMessage msg = new SimpleMailMessage();
		
        msg.setTo(to);
        msg.setSubject(subject);
        msg.setText(bodytext);
        
        javaMailSender.send(msg);
		
	}

	public Email( String to, String subject, String bodytext) {
		super();
	
		this.to = to;
		this.subject = subject;
		this.bodytext = bodytext;
	}


	
}
