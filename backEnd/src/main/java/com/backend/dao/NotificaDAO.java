package com.backend.dao;

import com.backend.dto.Notifica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class NotificaDAO {
    public Boolean inserisciNotifica(Notifica notifica){
        try{
            Connection con = null;
            String sql = "Insert into notifica VALUES(?,?,?)";
            con = dbConnection.getConnection();
            PreparedStatement p1 = con.prepareStatement(sql);
            p1.setString(1, notifica.getVenditore());
            p1.setString(2, notifica.getCompratore());
            p1.setInt(3, notifica.getAsta());
            p1.executeUpdate();
            con.close();
        return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public ArrayList<Notifica> venditoreNotifiche(String email) throws Exception {
        Connection con = null;
        String sql = "select * from notifica where venditore = ?";
        con = dbConnection.getConnection();
        PreparedStatement p1 = con.prepareStatement(sql);
        p1.setString(1, email);
        ResultSet rs = p1.executeQuery();
        ArrayList<Notifica> notifiche = new ArrayList<>();
        while (rs.next()){
            notifiche.add(new Notifica(rs.getString(1),rs.getString(2),rs.getInt(3)));
        }

        con.close();
        rs.close();
        return notifiche;
    }

    public ArrayList<Notifica> compratoreNotifiche(String email) throws Exception {
        Connection con = null;
        String sql = "select * from notifica where compratore = ?";
        con = dbConnection.getConnection();
        PreparedStatement p1 = con.prepareStatement(sql);
        p1.setString(1, email);
        ResultSet rs = p1.executeQuery();

        ArrayList<Notifica> notifiche = new ArrayList<>();
        while (rs.next()){
            notifiche.add(new Notifica(rs.getString(1),rs.getString(2),rs.getInt(3)));
        }
        con.close();
        rs.close();
        return notifiche;
    }
}
