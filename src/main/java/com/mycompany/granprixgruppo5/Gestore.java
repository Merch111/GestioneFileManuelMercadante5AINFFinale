/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.granprixgruppo5;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Studenti
 */
public class Gestore {
    String username;
    String password;
    int nGiocatori = 0;
    
    String fileGiocatori = "giocatori.csv";
    
    
    public String inputUsername() {
        Scanner scanner = new Scanner(System.in);
            
        System.out.println("Inserisci l'username: ");
        username = scanner.nextLine();
        
        
        scanner.close();
        
        return username;
        
    }
    
    public String inputPassword() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Inserisci la password: ");
        password = scanner.nextLine().toUpperCase();
        
        scanner.close();
        return password;
    }
    
    
    public void scriviEcifra(Giocatore g) {
        Cifratore cifratore = new Cifratore("BRUCO");
        String passwordCifrata = cifratore.cifra(g.password);
        
        Scrittore scrittore = new Scrittore("giocatori.csv", g.username + ";" + passwordCifrata + "-");
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
        try {
            threadScrittore.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(GranPrixGruppo5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    
    
}


