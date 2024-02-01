package gestionefile;

/**
 *
 * @author MC
 * @version 12/01/23
 */
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestioneFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //1)LETTURA
        Lettore lettore = new Lettore("user.json");
        lettore.start();
        try {
            lettore.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(GestioneFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //2)ELABORAZIONE
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci l'username: ");
        String username = scanner.nextLine();
        System.out.println("Inserisci la password: ");
        String password = scanner.nextLine().toUpperCase();
        
        Cifratore cifratore = new Cifratore("BRUCO");
        String passwordCifrata = cifratore.cifra(password);
        
        
        //3) SCRITTURA
        Scrittore scrittore = new Scrittore("output.csv", username + ";" + passwordCifrata);
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
        try {
            threadScrittore.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(GestioneFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //COPIA
        Copiatore copiatore = new Copiatore("output.csv", "copia.csv");
        copiatore.start();
        try {
            copiatore.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(GestioneFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
