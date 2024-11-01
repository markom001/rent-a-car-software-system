/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sesija;

import domen.Prodavac;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mitro
 */
public class Sesija {
    
    private static Sesija instance;
    private Socket soket;
    private Prodavac prodavac;

    public Sesija() {
        
        try {
            soket = new Socket("localhost", 9000);
        } catch (IOException ex) {
            System.out.println("Neuspesno povezivanje sa serverom");
        }       
    }

    public static Sesija getInstance() {
        if(instance == null){
            instance = new Sesija();
        }
        return instance;
    }

    public Socket getSoket() {
        return soket;
    }

    public void setProdavac(Prodavac prodavac) {
        this.prodavac = prodavac;
    }

    public Prodavac getProdavac() {
        return prodavac;
    }
    
}
