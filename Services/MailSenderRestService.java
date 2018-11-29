package com.perfectsolution.Clinique.Services;

import com.perfectsolution.Clinique.Metier.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import javax.mail.*;

@RestController
public class MailSenderRestService
{
    @Autowired
    public MailSenderService mailSenderService;
    
    @PostMapping({ "/SendMailSimple" })
    public void sendSimpleMail(@RequestParam final String to, @RequestParam final String subject, @RequestParam final String text) {
        this.mailSenderService.sendSimpleMail(to, subject, text);
    }
    
    @PostMapping({ "/SendMailHtml" })
    public void sendHTMLMail(@RequestParam final String to, @RequestParam final String subject, @RequestParam final String text) throws MessagingException {
        this.mailSenderService.sendHTMLMail(to, subject, text);
    }
    
    @PostMapping({ "/SendMailAttach" })
    public void sendMessageWithAttachment(@RequestParam final String to, @RequestParam final String subject, @RequestParam final String text, @RequestParam final String pathToAttachment) throws MessagingException {
        this.mailSenderService.sendMessageWithAttachment(to, subject, text, pathToAttachment);
    }
}
