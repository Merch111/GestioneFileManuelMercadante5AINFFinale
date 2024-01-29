package gestionefile;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedWriter;

/**
 *
 * @author MC
 * @ 12/01/23
 */

public class Lettore extends Thread{
    String nomeFile = "user.json";
    String fileOutput = "output.csv";
    String fileCopia = "copia.csv";
    
    public Lettore(String nomeFile){
        this.nomeFile = nomeFile;
    }
    
    /**
     * Legge il file senza tener conto del tipo di file
     * e lo mostra in output
     */
    public void leggi(){
        FileReader fr;
        
        int i; 
        try { 
            //1) apro il file
            fr = new FileReader(nomeFile);
            
            //2) leggo carattere per carattere 
            while ((i=fr.read()) != -1);
            
            System.out.print("\n\r");
            //3) chiudo il file
            fr.close();
        } catch (IOException ex) {
            System.err.println("Errore in lettura!");
        }
    }
    
    public void input(){
        Scanner scanner = new Scanner(System.in);
        
         //3) prendo in input l'username
            System.out.print("Inserisci l'username: ");
            String username = scanner.nextLine();
             
            //4) prendo in input la password
            System.out.print("Inserisci la password: ");
            String password = scanner.nextLine();
        
        scanner.close();
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutput))){
            writer.write("<username>;<password>");
        } catch (IOException e){
            System.out.println("Errore di scrittura");
        }
    }
    
    public void copia(){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileOutput)); 
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileCopia))) {
            
        } catch (IOException e) {
            System.out.println("Errore nella copia");
         }
    }
    

    public void run(){
        leggi();
        input();
        copia();
    }
}
