package com.perfectsolution.Clinique.Metier;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.mail.*;
import org.springframework.mail.javamail.*;
import javax.mail.internet.*;
import javax.mail.*;
import java.io.*;
import org.springframework.core.io.*;

@Service
public class MailSenderService
{
    @Autowired
    public JavaMailSender mailSender;
    
    public void sendSimpleMail(final String to, final String subject, final String text) {
        final SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        this.mailSender.send(message);
    }
    
    public void sendHTMLMail(final String to, final String subject, final String text) throws MessagingException {
        final MimeMessage message = this.mailSender.createMimeMessage();
        final MimeMessageHelper helper = new MimeMessageHelper(message, false, "utf-8");
        helper.setTo(to);
        helper.setSubject(subject);
        message.setContent((Object)text, "text/html");
        this.mailSender.send(message);
    }
    
    public void sendMessageWithAttachment(final String to, final String subject, final String text, final String pathToAttachment) throws MessagingException {
        final MimeMessage message = this.mailSender.createMimeMessage();
        final MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text);
        final FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
        helper.addAttachment("Invoice", (InputStreamSource)file);
        this.mailSender.send(message);
    }
}
