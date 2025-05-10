package com.example.dietideals24.Entities;

import java.io.Serializable;

public class Offerta implements Serializable {
    private String id;
    private String utente;
    private Integer asta;
    private Integer offerta;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public Integer getAsta() {
        return asta;
    }

    public void setAsta(Integer asta) {
        this.asta = asta;
    }

    public Integer getOfferta() {
        return offerta;
    }

    public void setOfferta(Integer offerta) {
        this.offerta = offerta;
    }
}
