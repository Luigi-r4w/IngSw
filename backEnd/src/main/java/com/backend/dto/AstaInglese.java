package com.backend.dto;

public class AstaInglese {
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
    private Integer scaduta;

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

    public Integer getScaduta() {
        return scaduta;
    }

    public void setScaduta(Integer scaduta) {
        this.scaduta = scaduta;
    }


    public AstaInglese(Integer id, String nome, String descrizione, String foto, String utente, String categoria, Integer offertaMinima, Integer intervalloDiTempo, Integer sogliaDiRialzo, Integer ultimaOfferta, Integer scaduta){
        this.id=id;
        this.nome=nome;
        this.descrizione=descrizione;
        this.foto=foto;
        this.categoria=categoria;
        this.utente=utente;
        this.offertaMinima=offertaMinima;
        if (intervalloDiTempo==null){
            this.intervalloDiTempo=60;
        }else {
            this.intervalloDiTempo=intervalloDiTempo;
        }
        if (sogliaDiRialzo==null){
            this.sogliaDiRialzo=10;
        }else {
            this.sogliaDiRialzo=sogliaDiRialzo;
        }
        this.ultimaOfferta=ultimaOfferta;
        this.scaduta=scaduta;
    }
}
