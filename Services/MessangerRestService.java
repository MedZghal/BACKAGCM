package com.perfectsolution.Clinique.Services;

import org.springframework.stereotype.*;
import com.perfectsolution.Clinique.Metier.*;
import org.springframework.beans.factory.annotation.*;
import java.security.*;
import com.perfectsolution.Clinique.Entities.*;
import org.springframework.http.*;
import java.net.*;
import java.io.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class MessangerRestService
{
    @Autowired
    public MessangerMetierImp messangerMetierImp;
    
    @RequestMapping(value = { "/hello" }, method = { RequestMethod.GET }, produces = { "application/json" })
    public ResponseEntity<Messanger> hello(final Principal principal) throws MalformedURLException, IOException {
        final ResponseEntity<Messanger> rep = (ResponseEntity<Messanger>)new ResponseEntity((Object)new Messanger("GEMP Login, " + principal.getName() + "!", principal.getName(), "", "", "", "", ""), HttpStatus.OK);
        return rep;
    }
    
    @RequestMapping({ "/" })
    public String index() {
        return "index";
    }
    
    @RequestMapping({ "/notifications" })
    public String notifications() {
        return "notifications";
    }
    
    @RequestMapping(value = { "/SendMsg" }, method = { RequestMethod.POST })
    @ResponseBody
    public ResponseEntity<?> SendMsg(@RequestParam final String msg, @RequestParam final String user, final Principal principal) {
        this.messangerMetierImp.chatSend(new Messanger(principal.getName(), principal.getName(), "", "", "", "", msg), user);
        return (ResponseEntity<?>)new ResponseEntity(HttpStatus.OK);
    }
    
    @RequestMapping(value = { "/ReciveMsg" }, method = { RequestMethod.POST })
    @ResponseBody
    public ResponseEntity<?> ReciveMsg(@RequestParam final String msg, @RequestParam final String user, final Principal principal) {
        this.messangerMetierImp.chatRecive(new Messanger(principal.getName(), principal.getName(), "", "", "", "", msg), user);
        return (ResponseEntity<?>)new ResponseEntity(HttpStatus.OK);
    }
}
