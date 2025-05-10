package com.backend.dao;

import com.backend.dto.Compratore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompratoreDAO {
    public Boolean inserisciUtente(Compratore utente) {
        
        try {
            Connection con = null;
            String sql = "Insert into compratore(nome, email, password) VALUES(?,?,?)";
            con = dbConnection.getConnection();
            PreparedStatement p1 = con.prepareStatement(sql);
            p1.setString(1, utente.getNome());
            p1.setString(2, utente.getEmail());
            p1.setString(3, utente.getPassword());
            p1.executeUpdate();
            con.close();
            return true;
        }
        catch (SQLException e){
            System.out.println(e);
            return false;
        }
    }

    public Boolean aggiungiLink(Compratore utente) {
                
        try {
            Connection con = null;
            String sql = "Update compratore set link=? where email=? ";
            con = dbConnection.getConnection();
            PreparedStatement p1 = con.prepareStatement(sql);
            p1.setString(1, utente.getLink());
            p1.setString(2, utente.getEmail());
            p1.executeUpdate();
            con.close();
            return true;
        }
        catch (SQLException e){
            System.out.println(e);
            return false;
        }
    }

    public Boolean aggiungiBio(Compratore utente) {
        try {
            Connection con = null;
            String sql = "Update compratore set bio=? where email=? ";
            con = dbConnection.getConnection();
            PreparedStatement p1 = con.prepareStatement(sql);
            p1.setString(2, utente.getEmail());
            p1.setString(1, utente.getDescrizione());
            p1.executeUpdate();
            con.close();
            return true;
        }
        catch (SQLException e){
            System.out.println(e);
            return false;
        }
    }

    public Boolean aggiungiPosizione(Compratore utente) {
        try {
            Connection con = null;
            String sql = "Update compratore set posizione=? where email=? ";
            con = dbConnection.getConnection();
            PreparedStatement p1 = con.prepareStatement(sql);
            p1.setString(1, utente.getPosizione());
            p1.setString(2, utente.getEmail());
            p1.executeUpdate();
            con.close();
            return true;
        }
        catch (SQLException e){
            System.out.println(e);
            return false;
        }
        
        
    }

    public Boolean autenticazione(String email, String pass) throws Exception {
        
        try {
            Connection con = null;
            String sql = "select * from compratore where email = ? AND password = ?";
            con = dbConnection.getConnection();
            PreparedStatement p1 = con.prepareStatement(sql);
            p1.setString(1, email.trim());
            p1.setString(2, pass.trim());
            ResultSet rs = p1.executeQuery();
            con.close();
            if (!rs.next()){
                return false;
            }
            return true;
        }
        catch (SQLException e){
            System.out.println(e);
            return false;
        }
    }


    public Compratore info(String email) throws Exception {
        Connection con = null;
        String sql = "select * from compratore where email = ? ";
        con = dbConnection.getConnection();
        PreparedStatement p1 = con.prepareStatement(sql);
        p1.setString(1, email.trim());
        ResultSet rs = p1.executeQuery();
        rs.next();
        Compratore compratore = new Compratore(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
        con.close();
        return compratore;
    }
}
