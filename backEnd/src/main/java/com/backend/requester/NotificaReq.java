package com.backend.requester;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;

import com.backend.dao.NotificaDAO;
import com.backend.dto.Notifica;

@RestController
@RequestMapping("/notifica")
public class NotificaReq {
    NotificaDAO notificaDAO = new NotificaDAO();
    
    @PostMapping("/")
    public void newNotifica(@RequestBody Notifica notifica) {
        notificaDAO.inserisciNotifica(notifica);
    }

    @GetMapping("/venditore/{mail}")
    public ArrayList<Notifica> venditore(@PathVariable("mail") String mail) throws Exception{
        return notificaDAO.venditoreNotifiche(mail);
    }

    @GetMapping("/compratore/{mail}")
    public ArrayList<Notifica> compratore(@PathVariable("mail") String mail) throws Exception  {
        return notificaDAO.compratoreNotifiche(mail);
    }
}
