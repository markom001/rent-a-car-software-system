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
public class SOVratiZakupe extends ApstraktnaSO {

    private ArrayList<ZakupAutomobila> listaZakupa;

    public ArrayList<ZakupAutomobila> getListaZakupa() {
        return listaZakupa;
    }

    public SOVratiZakupe() {
        listaZakupa = new ArrayList<>();
    }
   
    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        
        if(!(odo instanceof ZakupAutomobila)){          
            throw new Exception("Nevalidan objekat!");
        }
    }
    
    
    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws SQLException {
        
        ArrayList<OpstiDomenskiObjekat> listaZakupa = DBBroker.getInstance().select(odo);
        
        for (OpstiDomenskiObjekat el : listaZakupa) {
            this.listaZakupa.add((ZakupAutomobila) el);
        }
        
    }
    
    
    
}
