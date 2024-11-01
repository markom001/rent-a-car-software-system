/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import forme.KlijentskaForma;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mitro
 */
public class SatNit extends Thread {
 
    KlijentskaForma kf;

    public SatNit(KlijentskaForma kf) {
        this.kf = kf;
    }

    @Override
    public void run() {
       
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy - HH:mm:ss");
        
        while(!Thread.currentThread().isInterrupted()){
            
            try {
                Thread.sleep(100);
                kf.getLblSat().setText(sdf.format(new Date()));
            } catch (InterruptedException ex) {
                Logger.getLogger(SatNit.class.getName()).log(Level.SEVERE, null, ex);
            }
               
        }     
    }
    
}
