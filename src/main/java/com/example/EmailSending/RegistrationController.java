package com.example.EmailSending;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private NotificationService notificationService;

    @RequestMapping("/signup")
    public String signup(){
        return "Please sign up for our service";
    }

    @RequestMapping("/signup_success")
    public String signupSuccess(){

        //create user
        User user = new User();
        user.setFirstName("Don");
        user.setLastName("vega");
        user.setEmailAddress("vivek.raman@quinbay.com");


        //send a notification
        try {
            notificationService.sendNotification(user);
        }catch (MailException e){
            //catch error
            System.out.println("ERROR SENDING EMAIL"+ e.getMessage());
        }


        return "Thank you for registering with us";
    }

}
