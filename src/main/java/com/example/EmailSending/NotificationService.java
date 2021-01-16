package com.example.EmailSending;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    public NotificationService(JavaMailSender javaMailSender){
        this.javaMailSender=javaMailSender;
 }
    private JavaMailSender javaMailSender;
//
//

    public void sendNotification(User user) throws MailException {



        //send email
        SimpleMailMessage mail =new SimpleMailMessage();
        mail.setTo(user.getEmailAddress());
        mail.setFrom("tejasaik23@gmail.com");
        mail.setSubject("Toys are comming soon");
        mail.setText("This is cool email");

        javaMailSender.send(mail);
    }
}
