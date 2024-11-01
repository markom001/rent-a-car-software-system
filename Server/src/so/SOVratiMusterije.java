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
public class SOVratiMusterije extends ApstraktnaSO{

    
    private ArrayList<Musterija> listaMusterija;

    public ArrayList<Musterija> getListaMusterija() {
        return listaMusterija;
    } 

    public SOVratiMusterije() {
        listaMusterija = new ArrayList<>();
    }
    
    
    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
       if(!(odo instanceof Musterija)){          
            throw new Exception("Nevalidan objekat!");
        }
    }

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = DBBroker.getInstance().select(odo);
        
        for (OpstiDomenskiObjekat el : lista) {
            listaMusterija.add((Musterija) el);
        }   
    }
    
    
    
}
