package com.dh.moneymanager.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender mailSender;
    public EmailService(JavaMailSender mailSender){
        this.mailSender=mailSender;
    }
    private String fromEmail= "dinushkahimesh@gmail.com";

    public void sendEmail(String to,String subject,String body){
        try{
            SimpleMailMessage msg=new SimpleMailMessage();
            msg.setFrom(fromEmail);
            msg.setTo(to);
            msg.setSubject(subject);
            msg.setText(body);
            mailSender.send(msg);
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
