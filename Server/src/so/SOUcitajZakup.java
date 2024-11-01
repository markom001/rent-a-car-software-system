/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.ZakupAutomobila;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mitro
 */
public class SOUcitajZakup extends ApstraktnaSO{

    ZakupAutomobila zakup;

    public ZakupAutomobila getZakup() {
        return zakup;
    }
    
    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof ZakupAutomobila)) {
            throw new Exception("Nevalidan objekat!");
        }
    }

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws SQLException {
        
        ArrayList<OpstiDomenskiObjekat> lista = DBBroker.getInstance().select(odo);
        ArrayList<ZakupAutomobila> listaZakupa = new ArrayList<>();
        
        for (OpstiDomenskiObjekat el : lista) {
            listaZakupa.add((ZakupAutomobila) el);
        }
    
        ZakupAutomobila z = (ZakupAutomobila) odo;
        
        for (ZakupAutomobila zakup : listaZakupa) {
            if(zakup.getZakupID() == z.getZakupID()){
                this.zakup = zakup;
                break;
            }
        }    
    }
    
}
