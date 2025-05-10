package com.example.dietideals24.Entities;

import java.io.Serializable;

public class Venditore implements Serializable {

    private String nome;
    private String email;
    private String password;
    private String link;
    private String posizione;
    private String descrizione;

    public Venditore(){}

    public Venditore(String nome, String email, String pass){
        this.nome=nome;
        this.email=email;
        this.password=pass;

    }

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
}
