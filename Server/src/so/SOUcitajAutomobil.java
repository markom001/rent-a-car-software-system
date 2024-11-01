/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.Automobil;
import domen.OpstiDomenskiObjekat;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mitro
 */
public class SOUcitajAutomobil extends ApstraktnaSO{

    Automobil automobil;

    public Automobil getAutomobil() {
        return automobil;
    }
    
    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Automobil)) {
            throw new Exception("Nevalidan objekat!");
        }
    }
    
    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws SQLException {
        
        ArrayList<OpstiDomenskiObjekat> lista = DBBroker.getInstance().select(odo);
        ArrayList<Automobil> listaAutomobila = new ArrayList<>();
        for (OpstiDomenskiObjekat el : lista) {
            listaAutomobila.add((Automobil) el);
        }
        
        Automobil a = (Automobil) odo;
        
        for(Automobil auto : listaAutomobila){
            if(auto.getAutomobilID() == a.getAutomobilID()){
                this.automobil = auto;
            }
        }
    }
    
    
}
