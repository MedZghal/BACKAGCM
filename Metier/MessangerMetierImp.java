package com.perfectsolution.Clinique.Metier;

import org.springframework.stereotype.*;
import org.springframework.messaging.simp.*;
import org.springframework.beans.factory.annotation.*;
import com.perfectsolution.Clinique.Entities.*;

@Service
public class MessangerMetierImp
{
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    
    public void notify(final Messanger notification, final String username) {
        this.messagingTemplate.convertAndSendToUser(username, "/queue/notify", (Object)notification);
    }
    
    public void chatSend(final Messanger notification, final String username) {
        this.messagingTemplate.convertAndSendToUser(username, "/queue/chatSend", (Object)notification);
    }
    
    public void chatRecive(final Messanger notification, final String username) {
        this.messagingTemplate.convertAndSendToUser(username, "/queue/chatRecive", (Object)notification);
    }
}
