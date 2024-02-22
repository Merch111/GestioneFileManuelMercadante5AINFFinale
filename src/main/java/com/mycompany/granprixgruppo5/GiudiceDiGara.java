/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.granprixgruppo5;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elisa
 */
public class GiudiceDiGara {
    
    public void comunicaInizio() {
        System.out.println("INIZIO GARA");
    }
    
    public void comunicaFine() {
        System.out.println("FINE GARA");
    }
    
    public void sospendiMacchina(Thread t1) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Per quanti secondi vuoi sospendere la gara?: ");
        int secondi = scanner.nextInt();
        
        int millisecondi = secondi*1000;
        try {
            t1.sleep(millisecondi);
        } catch (InterruptedException ex) {
            Logger.getLogger(GiudiceDiGara.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void pubblicaClassifica() {
        
    }
}
