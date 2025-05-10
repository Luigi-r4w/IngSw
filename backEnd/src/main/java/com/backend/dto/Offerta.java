package com.backend.dto;

public class Offerta {
    private Integer id;
    private String utente;
    private Integer asta;
    private Integer valoreOfferta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getValoreOfferta() {
        return valoreOfferta;
    }

    public void setValoreOfferta(Integer offerta) {
        this.valoreOfferta = offerta;
    }

    public Offerta(Integer id, String utente, Integer asta, Integer offerta){
        this.asta=asta;
        this.utente=utente;
        this.id=id;
        this.valoreOfferta=offerta;
    }
}
