/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.SlobodanTermin;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mitro
 */
public class SOUcitajListuSlobodnihTermina extends ApstraktnaSO{

    private ArrayList<SlobodanTermin> listaSlobodnihTermina;

    public SOUcitajListuSlobodnihTermina() {
        listaSlobodnihTermina = new ArrayList<>();
    }

    public ArrayList<SlobodanTermin> getListaSlobodnihTermina() {
        return listaSlobodnihTermina;
    }
     
    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof SlobodanTermin)) {
            throw new Exception("Nevalidan objekat!");
        }    
    }

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws SQLException {
     
        ArrayList<OpstiDomenskiObjekat> lista = DBBroker.getInstance().select(odo);
        for (OpstiDomenskiObjekat el : lista) {
            listaSlobodnihTermina.add((SlobodanTermin) el);
        }       
    }
    
}
