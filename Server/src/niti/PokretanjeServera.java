/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

/**
 *
 * @author mitro
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PokretanjeServera extends Thread {

    @Override
    public void run() {
            
        try {
            ServerSocket ss = new ServerSocket(9000);
            System.out.println("Server je pokrenut");
            while(!isInterrupted()){            
                Socket s = ss.accept();
                System.out.println("Klijent se povezao");
                ObradaZahteva oz = new ObradaZahteva(s);
                oz.start();
            }
            
        } catch (IOException ex) {
            System.out.println("Server je vec pokrenut!");
        }
        
    }

    
}
