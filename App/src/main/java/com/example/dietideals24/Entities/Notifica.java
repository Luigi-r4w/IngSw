package com.example.dietideals24.Entities;

import java.io.Serializable;

public class Notifica implements Serializable {
    private String venditore;
    private String compratore;
    private int asta;

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

    public int getAsta() {
        return asta;
    }

    public void setAsta(int asta) {
        this.asta = asta;
    }
}