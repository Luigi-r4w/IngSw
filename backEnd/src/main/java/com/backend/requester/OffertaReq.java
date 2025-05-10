package com.backend.requester;

import org.springframework.web.bind.annotation.*;

import com.backend.dao.OffertaDAO;
import com.backend.dto.Offerta;


@RestController
@RequestMapping("/offerta")
public class OffertaReq {
    OffertaDAO offertaDAO = new OffertaDAO();

    @PostMapping("/")
    public void newOfferta(@RequestBody Offerta offerta) {
        offertaDAO.inserisciOfferta(offerta);
    }

    @GetMapping("/{id}")
    public  Offerta info(@PathVariable("id") Integer id) throws Exception {
        return  offertaDAO.mostraOffera(id);
    }

    @GetMapping("/offerta/{id}")
    public  Integer valoreOfferta(@PathVariable("id") Integer id) throws Exception {
        return  offertaDAO.valoreOfferta(id);
    }

    @GetMapping("/compratore/{id}")
    public  String compratoreOfferta(@PathVariable("id") Integer id) throws Exception {
        return  offertaDAO.compratoreOfferta(id);
    }
}
