package gestionefile;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;


public class Copiatore extends Thread{
    String nomeFile;
    String fileCopiato;
    String contenuto;
    
    public Copiatore(String nomeFile, String fileCopiato){
        this.nomeFile = nomeFile;
        this.fileCopiato = fileCopiato;
    }
    
    
    
    public void copiatoreFile() {
        Lettore lettore = new Lettore(nomeFile);
        String contenutoFile;
        try {
            // Leggi il contenuto del file e memorizzalo in una stringa
            contenutoFile = new String(Files.readAllBytes(Paths.get(nomeFile)));
            Scrittore scrittore = new Scrittore(fileCopiato,contenutoFile);
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
         try {
            threadScrittore.join();
        } catch (InterruptedException ex) {
            System.err.println("Errore nel metodo join()");
        } 
    } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void run(){
        copiatoreFile();
    }
}