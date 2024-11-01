/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.Musterija;
import domen.OpstiDomenskiObjekat;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mitro
 */
public class SOUcitajMusteriju extends ApstraktnaSO {

    private Musterija musterija;

    public Musterija getMusterija() {
        return musterija;
    }
 
    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Musterija)) {
            throw new Exception("Nevalidan objekat!");
        }
    }

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws SQLException {
        
        ArrayList<OpstiDomenskiObjekat> lista = DBBroker.getInstance().select(odo);
        ArrayList<Musterija> listaMusterija = new ArrayList<>();
        for (OpstiDomenskiObjekat el : lista) {
            listaMusterija.add((Musterija) el);
        }
        
        Musterija m = (Musterija) odo;
        
        for(Musterija musterija : listaMusterija){
            if(musterija.getMusterijaID() == m.getMusterijaID()){
                this.musterija =  musterija;
            }
        }
        
    }
}
