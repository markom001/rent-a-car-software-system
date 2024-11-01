/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.RacunZakupaAutomobila;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mitro
 */
public class SOVratiRacunZakupa extends ApstraktnaSO{
   
    private RacunZakupaAutomobila racun;

    public RacunZakupaAutomobila getRacun() {
        return racun;
    }
    
    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        
         if (!(odo instanceof RacunZakupaAutomobila)) {
            throw new Exception("Nevalidan objekat!");
        }           
    }
    
    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws SQLException {

        RacunZakupaAutomobila rza = (RacunZakupaAutomobila) odo;
        ArrayList<OpstiDomenskiObjekat> lista = DBBroker.getInstance().select(odo);
        ArrayList<RacunZakupaAutomobila> listaRacuna = new ArrayList<>();
        
        for (OpstiDomenskiObjekat el : lista) {
            listaRacuna.add((RacunZakupaAutomobila) el);
        }
        
        for (RacunZakupaAutomobila r : listaRacuna) {
            if(r.getZakupAutomobila().getZakupID() == rza.getZakupAutomobila().getZakupID()){
                this.racun = r;
                break;
            }
        }        
    }
    
}
