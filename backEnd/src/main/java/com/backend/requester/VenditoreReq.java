package com.backend.requester;

import org.springframework.web.bind.annotation.*;

import com.backend.dao.VenditoreDAO;
import com.backend.dto.Venditore;

@RestController
@RequestMapping("/venditore")
public class VenditoreReq {
    VenditoreDAO venditore = new VenditoreDAO();

    @GetMapping("/{mail}/{pass}")
    public Boolean autenticazione(@PathVariable("mail") String mail, @PathVariable("pass") String pass) {
        return venditore.autenticazione(mail, pass);
    }

    @PostMapping("/")
    public void newVenditore(@RequestBody Venditore user) {
        venditore.inserisciUtente(user);
    }
    @PostMapping("/link")
    public void link(@RequestBody Venditore user){
        venditore.aggiungiLink(user);
    }
    @PostMapping("/bio")
    public void bio(@RequestBody Venditore user)  {
        venditore.aggiungiBio(user);
    }
    @PostMapping("/posizione")
    public void posizione(@RequestBody Venditore user){
        venditore.aggiungiPosizione(user);
    }

    @GetMapping("/{mail}")
    public Venditore info(@PathVariable("mail") String mail) throws Exception {
        return venditore.infoVenditore(mail);
    }

    @PostMapping("/update")
    public void update(@RequestBody Venditore user) {
        venditore.aggiungiBio(user);
        venditore.aggiungiLink(user);
        venditore.aggiungiPosizione(user);
    }

}
