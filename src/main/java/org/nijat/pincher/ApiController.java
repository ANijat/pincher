package org.nijat.pincher;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.nijat.pincher.User;
import org.nijat.pincher.MailService;

@RestController
public class ApiController {

    @Autowired
    private MailService notificationService;
    @Autowired
    private User user;

    @RequestMapping("send-mail")
    public String send() {

        user.setEmailAddress("konul.aliyeva.1995@gmail.com");  //Receiver's email address
        try {
            notificationService.sendEmail(user);
        } catch (MailException mailException) {
            System.out.println(mailException);
        }
        return "Congratulations! Your mail has been send to the user.";
    }

    @RequestMapping("send-mail-attachment")
    public String sendWithAttachment() throws MessagingException {

        user.setEmailAddress("konul.aliyeva.1995@gmail.com"); //Receiver's email address

        try {
            notificationService.sendEmailWithAttachment(user);
        } catch (MailException mailException) {
            System.out.println(mailException);
        }
        return "Congratulations! huuuuuurrry up  .";
    }
}
