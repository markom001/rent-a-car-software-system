/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Prodavac;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logika.ServerKontroler;

/**
 *
 * @author mitro
 */
public class SOPronadjiProdavca extends ApstraktnaSO {

    private Prodavac prodavac;

    public Prodavac getProdavac() {
        return prodavac;
    }
    
    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {       
        if(!(odo instanceof Prodavac)){
            throw new Exception("Nevalidan objekat");
        }       
    }

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws SQLException{
        
        try {
            DBBroker.getInstance().poveziSe();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SOPronadjiProdavca.class.getName()).log(Level.SEVERE, null, ex);
        }
             
        ArrayList<OpstiDomenskiObjekat> lista = DBBroker.getInstance().select(odo);
        ArrayList<Prodavac> listaProdavaca = new ArrayList<>();
        
        Prodavac prodavac = (Prodavac) odo;
        
        for (OpstiDomenskiObjekat o : lista) {
            listaProdavaca.add((Prodavac) o);
        }
        
        if(ServerKontroler.getInstance().postojiUListi(prodavac)){
            throw new SQLException("Vec ste prijavljeni");
        }
            
        for (Prodavac pr : listaProdavaca) {
            if(pr.getKorisnickoIme().equals(prodavac.getKorisnickoIme()) && pr.getLozinka().equals(prodavac.getLozinka())){
                this.prodavac = pr;
                ServerKontroler.getInstance().dodajUListu(pr);
                break;
            }
        }
    }
    
    
}
