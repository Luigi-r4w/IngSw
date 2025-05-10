package com.backEnd;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.backend.dao.VenditoreDAO;

public class TestJUnit {
    
/*
    @Test
    public void testAutenticazioneCorretta(){
        VenditoreDAO venditore = new VenditoreDAO();
        Boolean var = venditore.autenticazione("test", "test");
        assertTrue(var, "il risultato dovrebbe essere true");
    }

    @Test
    public void testAutenticazioneFallita(){
        VenditoreDAO venditore = new VenditoreDAO();
        Boolean var = venditore.autenticazione("errore", "errore");
        assertFalse(var, "il risultato dovrebbe essere false");
    }

    @Test
    public void testAutenticazionePasswordNonValida(){
        VenditoreDAO venditore = new VenditoreDAO();
        Boolean var = venditore.autenticazione("test", "questapasswordnonèvalidapoichétroppolungasuperai30caratteri");
        assertFalse(var, "il risultato dovrebbe essere false");
    }

    @Test
    public void testAutenticazioneEmailNonValida(){
        VenditoreDAO venditore = new VenditoreDAO();
        Boolean var = venditore.autenticazione("questaemailnonèvalidapoichétroppolungasuperai30caratteri@mail.com", "test");
        assertFalse(var, "il risultato dovrebbe essere false");
    }

    @Test
    public void testInserisciUtenteValido(){
        VenditoreDAO venditoreDAO = new VenditoreDAO();
        Boolean var = venditoreDAO.inserisciUtente("testUtente", "testUtente1@mail.com", "test");
        assertTrue(var,"il risultato dovrebbe essere true");
    }

    @Test
    public void testInserisciUtenteGiàEsistente(){
        VenditoreDAO venditoreDAO = new VenditoreDAO();
        Boolean var = venditoreDAO.inserisciUtente("test", "test", "test");
        assertFalse(var,"il risultato dovrebbe essere false");
    }

    @Test
    public void testInserisciUtenteNonValidoPassNull(){
        VenditoreDAO venditoreDAO = new VenditoreDAO();
        Boolean var = venditoreDAO.inserisciUtente("utenteNonValido", "null", null);
        assertFalse(var,"il risultato dovrebbe essere false");
    }
    @Test
    public void testInserisciUtenteNonValidEmailNull(){
        VenditoreDAO venditoreDAO = new VenditoreDAO();
        Boolean var = venditoreDAO.inserisciUtente("utenteNonValido", null, "null");
        assertFalse(var,"il risultato dovrebbe essere false");
    }
    @Test
    public void testInserisciUtenteNonValidoNomeNull(){
        VenditoreDAO venditoreDAO = new VenditoreDAO();
        Boolean var = venditoreDAO.inserisciUtente(null, "null", "null");
        assertFalse(var,"il risultato dovrebbe essere false");
    }

    @Test
    public void testAggiungiPosizioneValido(){
        VenditoreDAO venditoreDAO = new VenditoreDAO();
        Boolean var = venditoreDAO.aggiungiPosizione( "testUtente1@mail.com", "Napoli");
        assertTrue(var,"il risultato dovrebbe essere true");
    }

    @Test
    public void testAggiungiPosizioneUtenteNull(){
        VenditoreDAO venditoreDAO = new VenditoreDAO();
        Boolean var = venditoreDAO.aggiungiPosizione( null, "Napoli");
        assertFalse(var,"il risultato dovrebbe essere false");
    }

    @Test
    public void testAggiungiPosizionePosizioneNull(){
        VenditoreDAO venditoreDAO = new VenditoreDAO();
        Boolean var = venditoreDAO.aggiungiPosizione( "testUtente1@mail.com", null);
        assertFalse(var,"il risultato dovrebbe essere false");
    }

    @Test
    public void testAggiungiLinkValido(){
        VenditoreDAO venditoreDAO = new VenditoreDAO();
        Boolean var = venditoreDAO.aggiungiLink( "testUtente1@mail.com", "https://www.instagram.com/");
        assertTrue(var,"il risultato dovrebbe essere true");
    }

    @Test
    public void testAggiungiLinkUtenteNull(){
        VenditoreDAO venditoreDAO = new VenditoreDAO();
        Boolean var = venditoreDAO.aggiungiLink( null, "https://www.instagram.com/");
        assertFalse(var,"il risultato dovrebbe essere false");
    }

    @Test
    public void testAggiungiLinkLinkNull(){
        VenditoreDAO venditoreDAO = new VenditoreDAO();
        Boolean var = venditoreDAO.aggiungiLink( "testUtente1@mail.com", null);
        assertFalse(var,"il risultato dovrebbe essere false");
    }


*/

}
