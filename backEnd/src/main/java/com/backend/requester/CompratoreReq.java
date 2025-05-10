package com.backend.requester;

import org.springframework.web.bind.annotation.*;

import com.backend.dao.CompratoreDAO;
import com.backend.dto.Compratore;

@RestController
@RequestMapping("/compratore")
public class CompratoreReq {
    CompratoreDAO compratoreDAO = new CompratoreDAO();

    @GetMapping("/{mail}/{pass}")
    public Boolean autenticazione(@PathVariable("mail") String mail, @PathVariable("pass") String pass) throws Exception{
        return compratoreDAO.autenticazione(mail, pass);
    }

    @PostMapping("/")
    public void newCompratore(@RequestBody Compratore user)  {
        compratoreDAO.inserisciUtente(user);
    }
    @PostMapping("/link")
    public void link(@RequestBody Compratore user)  {
        compratoreDAO.aggiungiLink(user);
    }
    @PostMapping("/bio")
    public void bio(@RequestBody Compratore user) {
        compratoreDAO.aggiungiBio(user);
    }
    @PostMapping("/posizione")
    public void posizione(@RequestBody Compratore user) {
        compratoreDAO.aggiungiPosizione(user);
    }

    @GetMapping("/{mail}")
    public Compratore info(@PathVariable("mail") String mail) throws Exception {
        return compratoreDAO.info(mail);
    }

    @PostMapping("/update")
    public void update(@RequestBody Compratore user){
        compratoreDAO.aggiungiBio(user);
        compratoreDAO.aggiungiLink(user);
        compratoreDAO.aggiungiPosizione(user);
    }
}
