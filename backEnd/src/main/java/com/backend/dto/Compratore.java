package com.backend.dto;

public class Compratore {
    private String nome;
    private String email;
    private String password;
    private String link;
    private String posizione;
    private String descrizione;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPosizione() {
        return posizione;
    }

    public void setPosizione(String posizione) {
        this.posizione = posizione;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Compratore(String nome, String email, String password,String link,String posizione, String descrizione){
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.link = link;
        this.posizione = posizione;
        this.descrizione = descrizione;
    }
}
