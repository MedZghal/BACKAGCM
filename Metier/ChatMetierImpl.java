package com.perfectsolution.Clinique.Metier;

import org.springframework.stereotype.*;
import com.perfectsolution.Clinique.Dao.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;
import com.perfectsolution.Clinique.Entities.*;

@Service
public class ChatMetierImpl implements ChatMetier
{
    @Autowired
    public ChatRepository chatRepository;
    
    @Override
    public List<Messanger> getChatList() {
        return (List<Messanger>)this.chatRepository.findAll();
    }
}
