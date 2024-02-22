/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.granprixgruppo5;

import java.util.Random;

/**
 *
 * @author elisa
 */
public class Giocatore extends Thread{
    String username;
    String password;
    int velocita = 0;
    

    public Giocatore(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    
    
    public int impostaVelocita(int nPartecipanti) {
        Giocatore[] partecipanti = new Giocatore[nPartecipanti];
        int numeroCasuale = 0;
        Random random = new Random();
        for(int i = 0; i < nPartecipanti; i++) {
            numeroCasuale = random.nextInt(nPartecipanti);
        }
        return numeroCasuale;
    }
    
    public void gareggia() {
        int lunghezzaCircuito = 100;
        for(int i = 0; i < lunghezzaCircuito; i+=velocita) {
        }
        System.out.println("Arrivato a fine Gara");
    }
    
    
    @Override
    
    public void run() {
        gareggia();
    }
}
