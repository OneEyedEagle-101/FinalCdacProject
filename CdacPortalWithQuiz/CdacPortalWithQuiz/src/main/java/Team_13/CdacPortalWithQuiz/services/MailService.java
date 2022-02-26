package Team_13.CdacPortalWithQuiz.services;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService{

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(String email) {
       
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(email); 
        message.setSubject("Something"); 
        message.setText("<H1>Hello<H1>");
        emailSender.send(message);
     
    }
    public void sendSimpleMessage(String email,String otp) {
        
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(email); 
        message.setSubject("Something"); 
        message.setText(otp);
        emailSender.send(message);
    }
}
