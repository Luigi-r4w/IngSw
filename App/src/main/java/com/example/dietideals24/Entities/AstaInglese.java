package com.example.dietideals24.Entities;

import java.io.Serializable;

public class AstaInglese implements Serializable {

    private Integer id;
    private String nome;
    private String descrizione;
    private String foto;
    private String utente;
    private String categoria;
    private Integer offertaMinima;
    private Integer intervalloDiTempo;
    private Integer sogliaDiRialzo;
    private Integer ultimaOfferta;
    private String scaduta;

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getOffertaMinima() {
        return offertaMinima;
    }

    public void setOffertaMinima(Integer offertaMinima) {
        this.offertaMinima = offertaMinima;
    }

    public Integer getIntervalloDiTempo() {
        return intervalloDiTempo;
    }

    public void setIntervalloDiTempo(Integer intervalloDiTempo) {
        this.intervalloDiTempo = intervalloDiTempo;
    }

    public Integer getSogliaDiRialzo() {
        return sogliaDiRialzo;
    }

    public void setSogliaDiRialzo(Integer sogliaDiRialzo) {
        this.sogliaDiRialzo = sogliaDiRialzo;
    }

    public Integer getUltimaOfferta() {
        return ultimaOfferta;
    }

    public void setUltimaOfferta(Integer ultimaOfferta) {
        this.ultimaOfferta = ultimaOfferta;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScaduta() {
        return scaduta;
    }

    public void setScaduta(String scaduta) {
        this.scaduta = scaduta;
    }
}
