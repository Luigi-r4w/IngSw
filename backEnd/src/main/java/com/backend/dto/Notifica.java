package com.backend.dto;

public class Notifica {
    private String venditore;
    private String compratore;
    private Integer asta;

    public String getVenditore() {
        return venditore;
    }

    public void setVenditore(String venditore) {
        this.venditore = venditore;
    }

    public String getCompratore() {
        return compratore;
    }

    public void setCompratore(String compratore) {
        this.compratore = compratore;
    }

    public Integer getAsta() {
        return asta;
    }

    public void setAsta(Integer asta) {
        this.asta = asta;
    }
    public Notifica(String venditore, String compratore, Integer asta){
        this.asta=asta;
        this.compratore=compratore;
        this.venditore=venditore;
    }
}
