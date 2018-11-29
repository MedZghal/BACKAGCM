package com.perfectsolution.Clinique.Services;

import com.perfectsolution.Clinique.Metier.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;
import com.perfectsolution.Clinique.Entities.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChatRestService
{
    @Autowired
    public ChatMetier chatMetier;
    
    @GetMapping({ "/ChatMsg" })
    public List<Messanger> getChatList() {
        return this.chatMetier.getChatList();
    }
}
