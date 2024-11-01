/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.AutomobilSaTerminom;
import domen.OpstiDomenskiObjekat;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mitro
 */
public class SOVratiAutoTermine extends ApstraktnaSO{

    private ArrayList<AutomobilSaTerminom> listaAutoTermina;

    public ArrayList<AutomobilSaTerminom> getListaAutoTermina() {
        return listaAutoTermina;
    }

    public SOVratiAutoTermine() {
        listaAutoTermina = new ArrayList<>();
    }
     
    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof AutomobilSaTerminom)){          
            throw new Exception("Nevalidan objekat!");
        }
    }

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws SQLException {
       
        ArrayList<OpstiDomenskiObjekat> listaAutoTermina = DBBroker.getInstance().select(odo);
        
        for (OpstiDomenskiObjekat el : listaAutoTermina) {
            this.listaAutoTermina.add((AutomobilSaTerminom) el);
        }        
    }
    
    
    
}
